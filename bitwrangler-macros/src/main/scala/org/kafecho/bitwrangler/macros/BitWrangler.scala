package org.kafecho.bitwrangler.macros

import language.experimental.macros
import scala.reflect.macros.Context
import akka.util.ByteString
import scala.reflect.NameTransformer.encode


/** A set of methods to extract bit level information from an Akka ByteString.
 *  
 * Not much of this code is ByteString specific, and it could well be changed to work with vanilla byte arrays. 
 * The methods are implemented as Scala macros, with the aim of generating code that is efficient and close enough to a hand written equivalent.
 * The macros generate Scala' AST by combining sub-trees together.
 * Many thanks for http://stackoverflow.com/questions/11055210/whats-the-easiest-way-to-use-reify-get-an-ast-of-an-expression-in-scala for some useful tips on how to create and combine ASTs.
 * The motivation for this set of methods is to simplify how one can write and read bit-manipulation methods. 
 * @author Guillaume Belrose. 
 */
object BitWrangler {
  
  /** Check if the bit at the given bit offset within the ByteString is set to 0 or 1.
   * 
   * This macro expects the offset value to be known at compile time (it has to be a constant literal).   
   */
  def boolean(bytes: ByteString, offset: Int) = macro booleanImpl

  //def boolean(offset: Int)(implicit bytes: ByteString) : Boolean = boolean(bytes,offset)
  
  /** Read a given set of bits at a given position and return the corresponding value.
   *  
   * The macro expects both the offset and the length to be known at compile time. 
   */
  def int(bytes: ByteString, offset: Int, length: Int) = macro intImpl

  //def int(offset: Int, length: Int)(implicit bytes: ByteString) : Int = int(bytes,offset,length)

  val bitMasks = Map(
    0 -> 0x80,
    1 -> 0x40,
    2 -> 0x20,
    3 -> 0x10,
    4 -> 0x08,
    5 -> 0x04,
    6 -> 0x02,
    7 -> 0x01)

  private[this] val lengthMasks = Map(
    1 -> 0x01,
    2 -> 0x03,
    3 -> 0x07,
    4 -> 0x0F,
    5 -> 0x1F,
    6 -> 0x3F,
    7 -> 0x7F,
    8 -> 0xFF)


  private[this] def op(s: String)(implicit c: Context): c.universe.TermName =
    c.universe.newTermName(encode(s))

  private[this] def const(a: Any)(implicit c: Context): List[c.universe.Literal] =
    List(c.universe.Literal(c.universe.Constant(a)))

  private[this] def nthElement(c: Context)(tree: c.Tree, index: Int) = {
    import c.universe._
    implicit val cc: c.type = c
    Apply(Select(tree, op("apply")), const(index))
  }

  private[this] def intValue(c: Context)(tree: c.Tree, offset: Int, nbBits: Int) = {
    import c.universe._
    implicit val cc: c.type = c
    val shiftBy = 8 - offset - nbBits
    val shifted = shiftBy match{
      case 0 => tree
      case v => Apply(Select(tree, op(">>")), const(v))
    }
    Apply(Select(shifted, op("&")), const(lengthMasks(nbBits)))
  }

  /** Implementation of the boolean macro*/
  def booleanImpl(c: Context)(bytes: c.Expr[ByteString], offset: c.Expr[Int]): c.Expr[Boolean] = {
    import c.universe._
    implicit val cc: c.type = c
    val Literal(Constant(o: Int)) = offset.tree
    val what = nthElement(c)(bytes.tree, o / 8)
    val masked = Apply(Select(what, op("&")), const(bitMasks(o % 8)))
    c.Expr(Apply(Select(masked, op("!=")), const(0)))
  }

  /** Implementation of the int macro*/
  def intImpl(c: Context)(bytes: c.Expr[ByteString], offset: c.Expr[Int], length: c.Expr[Int]): c.Expr[Int] = {
    import c.universe._
    implicit val cc: c.type = c

    val Literal(Constant(o: Int)) = offset.tree
    val Literal(Constant(l: Int)) = length.tree
    val startByte = o / 8
    val endByte = (o + l - 1) / 8

    var value: Option[c.universe.Apply] = None
    var readSoFar = 0
    var read = 0

    var i = startByte
    while (i <= endByte) {
      if (i == startByte) {
        val firstOffset = o % 8
        read = l.min(8 - firstOffset)
        val myByte = nthElement(c)(bytes.tree, i)
        value = Some(intValue(c)(myByte, firstOffset, read))
        readSoFar += read
      } else {
        value = value.map { v =>
          read match {
            case 0xFF => v
            case s => Apply(Select(v, op("<<")), const(s))
          }
        }
        read = 8.min(l - readSoFar)
        val myByte = nthElement(c)(bytes.tree, i)
        val myValue = intValue(c)(myByte, 0, read)
        readSoFar += read

        value = value.map { v => Apply(Select(v, op("|")), List(myValue)) }
      }
      i += 1
    }
    c.Expr(value.get)
  }
}