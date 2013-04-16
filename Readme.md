BitWrangler
============

Overview
--------

BitWrangler is my 1st attempt at writing a macro from Scala 2.10.

It is a simple library which makes it easy to execute bit-level operations on sequence of bytes. 

For the time being, it works with Akka ByteString which happens to be the data structure that I've be using for some Akka prototype I am working on. 

BitWrangler was designed to simplify how to unpack binary-level data into Scala case classes. 

Normally, in order to do bit-level unpacking, you have to use bit-shifting (<< and >>), bit masks and AND and OR operations. That is not difficult, but the code produced as a result is a bit hard to read.

I wanted to provide a higher level interface, where on can say, given a data structure containing bytes, 
* check if a bit at a given bit offset is set (boolean)
* retrieve an integer value from a given bit offset and for a given length.

How are macros used?
--------------------

I've written a set of Scala macros to create ASTs for those bit-level processing operation based on input data which is be known at compile time.

Here is a simple example on how to use the macros:

```scala
import akka.util.ByteString
import org.kafecho.bitwrangler.macros.BitWrangler._
object SimpleExample extends App {
    // AKA 00000111
	val data = ByteString(0x07)
	// Read the bit at position 7 (this should be one)
	println (boolean(data,7))
	// Read 2 bits starting from position 5 (this should be 3)
	println (int(data,5,2))
}
```
The Scala compiler will use the macros and translate the calls to:

* SimpleExample.this.data.apply(0).$amp(1).$bang$eq(0) <=> (data(0) & 0x01) != 0
* SimpleExample.this.data.apply(0).$greater$greater(1).$amp(3) (data(0) >> 1) & (0x03)

Which is similar to what you could write by hand.

The boolean macro is as follows:
```scala
  /** Implementation of the boolean macro*/
  def booleanImpl(c: Context)(bytes: c.Expr[ByteString], offset: c.Expr[Int]): c.Expr[Boolean] = {
    import c.universe._
    implicit val cc: c.type = c
    val Literal(Constant(o: Int)) = offset.tree
    val what = nthElement(c)(bytes.tree, o / 8)
    val masked = Apply(Select(what, op("&")), const(bitMasks(o % 8)))
    c.Expr(Apply(Select(masked, op("!=")), const(0)))
  }
```

In a nutshell, the macro builds an AST of bit shifting and masking operations. 

I also provide a non-macro version of the BitWrangler and some unit tests and some micro benchmarks.


Limitation of the approach
--------------------------
The macros require information provided at compile time using literals. It does expect the offset and lenght attributes to be known at compile time. The following will compile.

```scala
object SimpleTest extends App{
  val bytes = ByteString(1,2,3,4)
  import org.kafecho.bitwrangler.macros.BitWrangler._
  println (boolean(bytes,0))
}
```

However, this won't, since x is not a constant literal.

```scala
object SimpleTest extends App{
  val bytes = ByteString(1,2,3,4)
  import org.kafecho.bitwrangler.macros.BitWrangler._
  val x = 0
  println (boolean(bytes,x))
}
```


Project structure
-----------------
The project is implemented as a Maven multi-module project.

The bitwrangler-macros module contains the macros implementation.
The bitwrangler-core module contains examples of how to use the macros.


Thanks to
---------

Many thanks to https://github.com/scalamacros/maven-example for helping me quickstart my Maven project.

Many thanks for http://stackoverflow.com/questions/11055210/whats-the-easiest-way-to-use-reify-get-an-ast-of-an-expression-in-scala for some useful tips on how to create and combine ASTs.
