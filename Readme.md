## BitWrangler

BitWrangler is my 1st attempt at writing a macro from Scala 2.10.

It is a simple library which makes it easy to execute bit-level operations on sequence of bytes. 

For the time being, it works with Akka byte string which happens to be the data structure that I've be using for some Akka prototype I am working on. 

BitWrangler was designed to simplify how to unpack binary-level data into Scala case classes. 

Normally, in order to do bit-level unpacking, you have to use bit-shifting (<< and >>), bit masks and AND and OR operations. That is not difficult, but the code produced as a result is a bit hard to read.

I wanted to provide a higher level interface, where on can say, given a data structure containing bytes, 
-check if a bit at a given bit offset is set (boolean)
-retrieve an integer value from a given bit offset and for a given length.

The 2 Scala macros have written basically create ASTs for those bit-level processing operation based on input data (the bit offset, and the length) which must be known at compile time.

Here is a simple example 

import akka.util.ByteString
import org.kafecho.bitwrangler.macros.BitWrangler._
object SimpleExample extends App {
	
    // AKA 00000111
	val data = ByteString(0x07)


	// Read the bit at position 7 (this should be one)
	println (boolean(data,7))

	// Read 2 bits starting from position 5 (this should be 3)
	println (int(data,5,2))

	// Read 3 bits starting from position 5 (this should be 3)
	println (int(data,5,3))

}


