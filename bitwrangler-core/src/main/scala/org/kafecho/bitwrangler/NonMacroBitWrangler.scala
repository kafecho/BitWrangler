package org.kafecho.bitwrangler

import akka.util.ByteString

object NonMacroBitWrangler{
  private[this] val bitMasks = Map(
    0 -> 0x80,
    1 -> 0x40,
    2 -> 0x20,
    3 -> 0x10,
    4 -> 0x08,
    5 -> 0x04,
    6 -> 0x02,
    7 -> 0x01)

  /** Read a boolean value at a given bit offset within a ByteString */
  def boolean(bytes :ByteString, offset: Int): Boolean = {
    (bytes(offset / 8) & bitMasks(offset % 8)) != 0
  }
    
  private[this] val lengthMasks = Map(
    1 -> 0x01,
    2 -> 0x03,
    3 -> 0x07,
    4 -> 0x0F,
    5 -> 0x1F,
    6 -> 0x3F,
    7 -> 0x7F,
    8 -> 0xFF)


    
    private[this] def int(b: Byte, offset: Int, nbBits: Int): Int = {
    (b  >> (8 - offset - nbBits)) & lengthMasks(nbBits)
  }


  /** Read an integer value at a given bit offset with a given length within a ByteString */
  def int(bytes: ByteString, offset: Int, length: Int): Int = {
    val startByte = offset / 8
    val endByte   = (offset + length - 1) / 8
    var i = startByte
    var value : Int = 0
    var toRead : Int = 0
    var readSoFar : Int = 0
    while (i <= endByte) {
      if (i == startByte){
    	val firstOffset = offset % 8
    	toRead = length.min(8 - firstOffset)
        value = int( bytes(i), firstOffset, toRead)
        readSoFar += toRead
      } else{
        value = (value << toRead)
        toRead = 8.min(length - readSoFar)
        val lastValue = int( bytes(i), 0, toRead)
        value = value | lastValue
        readSoFar += toRead
      }
      i += 1
    }
    value
  }
}