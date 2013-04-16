package org.kafecho.bitwrangler

import akka.util.ByteString

object SimpleTest extends App{
  val bytes = ByteString(1,2,3,4)
  import org.kafecho.bitwrangler.macros.BitWrangler._
  println (boolean(bytes,7))
}