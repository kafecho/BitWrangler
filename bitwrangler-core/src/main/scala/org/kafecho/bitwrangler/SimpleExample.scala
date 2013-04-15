package org.kafecho.bitwrangler

import akka.util.ByteString
import org.kafecho.bitwrangler.macros.BitWrangler._
object SimpleExample extends App {
	val data = ByteString(0x07)
	println (boolean(data,7))
	println (int(data,5,2))
	println (int(data,5,3))
}