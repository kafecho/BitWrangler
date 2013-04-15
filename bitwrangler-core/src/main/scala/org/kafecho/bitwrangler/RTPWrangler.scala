package org.kafecho.bitwrangler

import akka.util.ByteString

trait RTPPacketParser{
  val bytes : ByteString
  def version : Int
  def padding : Boolean
  def extension	: Boolean
  def csrcCount : Int
  def marker : Boolean
  def payloadType : Int
  def sequenceNumber : Int
  def timestamp : Int
  def srscID : Int
  override def toString = "RTPPacket(" +
    "version = " + version + ", " +
    "padding = " + padding + ", " +
    "extension = " + extension + ", " +
    "csrcCount = " + csrcCount + ", " +
    "marker = " + marker + ", " +
    "payloadType = " + payloadType + ", " +
    "sequenceNumber = " + sequenceNumber + ", " +
    "timestamp = " + timestamp + ", " +
    "srscID = " + srscID + ")"
}

/** A parser which uses the bit wrangler to extract information from an RTP packet.*/
trait RTPPacketParserWithMacro extends RTPPacketParser {
  import org.kafecho.bitwrangler.macros.BitWrangler._
  def version 		 = int(bytes,0,2)
  def padding 		 = boolean(bytes,2)
  def extension		 = boolean(bytes,3) 
  def csrcCount		 = int(bytes,4,4)
  def marker 		 = boolean(bytes,8)
  def payloadType    = int(bytes,9,7)
  def sequenceNumber = int(bytes,16,16)
  def timestamp 	 = int(bytes,32,32)
  def srscID 		 = int(bytes,64,32)
}

/** A parser which uses the non-macro bit wrangler to extract information from an RTP packet.*/
trait RTPPacketParserWithoutMacro extends RTPPacketParser {
  import org.kafecho.bitwrangler.NonMacroBitWrangler._
  def version 	= int(bytes,0,2)
  def padding 	= boolean(bytes,2)
  def extension	= boolean(bytes,3) 
  def csrcCount = int(bytes,4,4)
  def marker = boolean(bytes,8)
  def payloadType = int(bytes,9,7)
  def sequenceNumber = int(bytes,16,16)
  def timestamp = int(bytes,32,32)
  def srscID = int(bytes,64,32)
}

/** A simple hand-written parser which extracts information from a RTP packet.
 * See http://en.wikipedia.org/wiki/Real-time_Transport_Protocol  
 */
trait RTPPacketParserByHand extends RTPPacketParser{
  def version = (bytes(0) & 0xc0) >> 6
  def padding = (bytes(0) & 0x20) != 0
  def extension = (bytes(0) & 0x10) != 0
  def csrcCount = (bytes(0) & 0x0f)
  def marker = (bytes(1) & 0x80) != 0
  def payloadType = (bytes(1) & 0x7f)
  def sequenceNumber = (bytes(2) & 0xff) << 8 | (bytes(3) & 0xff)
  def timestamp = ((bytes(4) & 0xff) << 24) | ((bytes(5) & 0xff) << 16) | ((bytes(6) & 0xff) << 8) | (bytes(7) & 0xff)
  def srscID = ((bytes(8) & 0xff) << 24) | ((bytes(9) & 0xff) << 16) | ((bytes(10) & 0xff) << 8) | (bytes(11) & 0xff)
}

case class RTPPacketWithMacro(bytes: ByteString) extends RTPPacketParserWithMacro

case class RTPPacketWithoutMacro(bytes: ByteString) extends RTPPacketParserWithoutMacro

case class RTPPacketByHand(bytes: ByteString) extends RTPPacketParserByHand

