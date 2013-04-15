BitWrangler
============

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

> import akka.util.ByteString
> import org.kafecho.bitwrangler.macros.BitWrangler._
> object SimpleExample extends App {
>    // AKA 00000111
>	val data = ByteString(0x07)
>
>	// Read the bit at position 7 (this should be one)
>	println (boolean(data,7))
>
>	// Read 2 bits starting from position 5 (this should be 3)
>	println (int(data,5,2))
> }

The Scala compiler will use the Macro and translate the calls to:

SimpleExample.this.data.apply(0).$amp(1).$bang$eq(0) <=> (data(0) & 0x01) != 0

SimpleExample.this.data.apply(0).$greater$greater(1).$amp(3) (data(0) >> 1) & (0x03)

Which is similar to what you could write by hand.

I also provide a non-macro version of the BitWrangler and some unit tests and some micro benchmarks.
