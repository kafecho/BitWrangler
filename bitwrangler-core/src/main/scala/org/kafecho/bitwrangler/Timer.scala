package org.kafecho.bitwrangler

object Timer{
  def timeThis[T](fn : => T) : T = {
    val start = System.nanoTime()
    val t = fn
    val stop = System.nanoTime
    println (s"It took ${stop-start} nanosecs to execute the code.")
    t
  }
}
