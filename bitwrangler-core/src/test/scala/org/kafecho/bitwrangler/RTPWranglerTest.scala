package org.kafecho.bitwrangler

import akka.util.ByteString

object RTPWranglerTest extends App {
  val bytes = ByteString(-128, -95, 101, 110, 69, -59, -30, 0, 51, 14, -91, 27, 71, 64, 68, 29, 0, 0, 1, -64, 1, 10, -128, -128, 5, 43, 23, 23, -11, -115, -1, -15, 80, -128, 32, 95, -4, 33, 76, -2, -1, -4, -99, -102, 80, -92, -77, 66, -92, -53, -81, 109, -15, -41, 83, 121, -65, 35, 87, -58, 126, 49, -27, -33, 90, -112, -66, 79, -19, 124, 107, -26, 94, 49, -76, -66, 111, 103, 73, -87, -111, 115, -74, -17, 89, 122, -101, -108, -10, -15, 15, -74, -107, 29, -57, 116, 122, 44, 41, -110, 12, -54, 44, 103, 114, 107, -117, 114, 127, 116, -75, -47, 20, 99, 73, 115, 7, -100, -121, -46, -18, -95, -2, -118, -33, -84, -128, 22, 26, -89, 50, 26, -12, 122, 32, -85, 47, 102, -67, -20, -29, 10, -46, -85, -53, 126, 27, 50, -18, 122, 114, -18, 58, 91, 26, -36, 45, 7, -57, -13, -47, -81, 73, -23, -30, 43, -78, -101, 47, 55, -68, -62, 14, -100, -24, -99, -84, -121, -76, -52, -24, -18, -22, -23, -123, -72, -44, 116, 57, -115, 0, -110, -50, 96, -67, 13, -42, 123, 17, 44, 71, 0, 69, 19, 62, 70, -51, 41, -75, -14, 115, -115, 124, -11, -8, 16, -61, 122, -77, 125, -118, -30, 104, 31, 102, -123, 34, 78, 125, 36, -81, 62, 97, 25, -21, 21, 56, -98, 77, 68, -8, 34, -122, -115, -15, -35, 89, -115, -87, 62, -30, 88, 55, -121, 86, 86, -113, -95, 86, -12, -90, 44, 32, 38, -86, -67, -115, -8, 69, -34, 49, -128, -30, 75, -53, 55, -119, 55, 85, -54, -109, 112, 29, 119, -85, -75, 87, 15, 111, -126, -22, 13, 12, -125, -101, -33, 99, 77, 66, -23, 120, -102, 10, 31, 107, 102, 101, 122, 15, 115, 114, 115, 91, 117, -65, -26, -6, 83, -109, 20, 48, -114, 55, 5, 11, 105, 96, -31, 5, 18, -22, 11, 49, -19, 115, 114, 3, -28, -113, 120, 57, 104, 33, -101, 68, 70, -36, -17, -61, 44, 64, -32, -21, -78, 122, 108, -13, 1, -125, 14, 97, -27, -116, 71, 71, 75, 123, 13, 61, -47, -108, -31, -42, -4, 116, -75, -44, 90, -70, -27, -39, -37, -74, 48, -60, 1, -104, -71, 71, 0, 69, 20, -108, 123, 31, 117, -60, 73, 28, 102, 50, -16, -4, 60, -107, -2, 8, 28, 69, -51, -20, -13, -120, -25, -28, 98, 4, 103, -72, 0, 60, 59, -7, -57, -71, -87, -11, -35, 39, -115, -87, 97, 25, 28, -48, 62, -75, 30, -105, -93, -103, 75, 117, -56, 12, -35, -94, -76, -42, 121, -8, -9, 88, -104, 16, -87, -116, 68, 35, 116, -71, -61, 76, -102, 63, 19, -62, 118, 4, 71, 67, 104, 111, 9, -98, -98, 23, 73, -72, 5, -111, 60, -70, 13, -112, -104, 107, -41, 13, -47, -30, 92, -111, -28, -81, 126, 109, 120, -113, -102, 23, -71, 96, -62, 22, -125, -48, -25, 39, -12, -36, -127, 61, -126, -2, 118, 43, -7, -45, -65, 21, 113, 95, -75, 69, -73, -60, -3, -17, 95, -48, 27, 83, 42, -48, 14, 58, -106, -40, 67, -58, 4, 17, -15, 8, 17, -26, 38, 110, 104, 80, -99, 33, 63, -117, 6, 98, 33, 72, 24, 69, -69, -124, -13, -83, 53, 120, 19, -58, -9, 84, 53, -63, -42, -128, -9, 71, 0, 69, 21, -78, 118, -111, 53, 31, 48, 110, -5, -36, -126, 78, 62, 76, 23, 35, -125, 109, 70, 17, 25, 24, 8, 103, 9, 104, -19, -118, -85, 56, -14, 89, -32, 39, 39, 114, -60, -126, -113, 82, -104, 74, 43, -54, 35, -7, -64, 80, -90, 80, -119, 46, 28, -56, -22, 71, 92, -100, 29, -36, -52, -87, 82, -54, 111, 121, 67, 84, -117, -18, -4, 29, -47, -106, -96, -104, 72, 86, 7, 72, -60, -119, 29, 80, -72, 127, -120, -78, -112, 49, -24, -24, -70, 5, 59, 86, -48, 58, 83, -86, -109, 62, -47, 19, -68, -14, 14, -38, 83, 100, 49, -13, -44, 88, 54, 96, 58, -110, -109, 76, 17, -67, -44, 27, -57, 35, 18, 22, 64, -47, 33, 4, 94, 24, -76, 31, 44, -43, 37, -11, -121, 86, -75, -59, 122, -35, 86, -122, -21, 86, 70, -7, 20, -70, -50, -6, -54, -10, -60, -95, 5, 23, 90, -60, -44, 50, -92, -124, -74, 55, -90, 86, 87, 53, -118, -85, -83, 0, 67, -70, 120, 21, 116, 21, 72, 71, 0, 69, 22, -103, -116, -77, -28, -88, 33, 81, 20, 40, -121, 88, -19, -71, -117, -76, -75, -18, 68, -6, 76, 97, -73, 69, -5, 21, 82, -59, -64, -73, 2, -83, -112, -84, -91, 99, 84, 1, -9, -93, -111, 19, -24, -116, 62, 42, 3, 103, -116, 48, 2, -97, -101, 126, -64, 119, 17, -104, 23, -84, 43, 118, -14, 68, -114, -121, -37, -119, 103, 103, 53, 69, -71, -126, -108, 37, 89, 89, 54, 123, 103, 16, 18, -59, 7, -12, -67, 96, -106, -45, 7, -57, 86, -35, -22, -123, -62, -31, -127, 124, 67, -20, -34, -39, 58, 18, -115, 55, -9, 58, -6, 18, -53, -128, 36, -62, -109, -114, 106, 71, -23, -68, 77, 104, -28, -17, -126, 71, 63, 57, 109, -101, 19, 63, 116, 62, -9, -67, -5, -6, -43, 21, -21, 78, 110, 79, -82, 105, 112, 114, -123, -116, -31, 103, -98, 22, -12, -48, -27, -76, -95, -65, 83, 59, -3, 39, -16, 19, 7, -121, -6, 90, -19, 45, -76, -12, -94, -127, -24, 3, 99, -64, -102, 90, 97, 71, 0, 69, 55, -86, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -40, 126, -122, -73, -74, 101, 62, -73, -59, 93, -52, -1, -80, 71, 64, 69, 24, 0, 0, 1, -32, 20, 127, -128, -64, 10, 59, 23, 25, 52, -27, 27, 23, 23, -6, 61, 0, 0, 0, 1, 9, -32, 0, 0, 0, 1, 65, -101, -86, 73, -31, 15, 38, 83, 2, 43, -1, -21, 61, 32, -4, 114, -4, -17, -84, 29, -31, -123, -127, -31, 47, 73, 109, 68, -11, 120, -109, 46, -38, 25, -1, 13, 10, 106, -10, 70, 12, 64, 65, -3, 96, 60, -83, 40, -82, -99, 79, -85, -26, -68, 56, -72, 29, -56, -26, 65, 24, -107, -115, -74, -76, -91, 38, 94, 71, -101, -73, 110, -36, 82, -86, -55, 52, -11, -76, 85, 79, 56, 55, -128, 57, -117, -87, 54, -103, -55, -95, -83, -23, 94, -107, -33, -106, 124, -117, -28, 89, -3, -58, -48, -117, 58, -46, -25, -108, 18, -98, -105, 31, 38, 47, -72, -121, 108, 20, 3, -35, -115, 34, -63, -103, 90, -56, 54, -117, 36, -75, 109, -75, -120, 20, -32, 66, 36, 77, -101, 107, -48, 69, -39, -90, 78, 26, 99, -13, -1, -18, -62, 33, -43, -82)

  val rtpPacketB = RTPPacketWithoutMacro(bytes)
  val rtpPacketA = RTPPacketWithMacro(bytes)
  val rtpPacketC = RTPPacketByHand(bytes)

  println(rtpPacketA.toString)
  println(rtpPacketB.toString)
  println(rtpPacketC.toString)

  val nbLoops = 5
  val nbIterations = 10000000

  for (loop <- 0 until nbLoops){

    println("By hand...")
    Timer.timeThis {
      for (i <- 0 until nbIterations){
        RTPPacketByHand(bytes).toString
      }
    }

    println("With macro...")
    Timer.timeThis {
      for (i <- 0 until nbIterations) {
        RTPPacketWithMacro(bytes).toString
      }
    }

    println("Without macro...")
    Timer.timeThis {
      for (i <- 0 until nbIterations) {
        RTPPacketWithoutMacro(bytes).toString
      }
    }

  }
}