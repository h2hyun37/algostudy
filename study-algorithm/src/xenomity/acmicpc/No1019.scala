package xenomity.acmicpc

import scala.collection.mutable.MutableList

/**
 * @author Xenomity a.k.a P-slinc’ (이승한)
 */
object No1019 {
  def solve(n: Int): String = {
    // initialize
    var queue = new Array[Int](10)

    // count
    for (i <- 1 to n) {
    	recursiveNumberCount(i, queue)
    }
    
    return queue.mkString(" ")
  }
  
  private def recursiveNumberCount(n: Int, queue: Array[Int]) {
    if (n >= 10) {
      val textNumber = String.valueOf(n)
      
      for (i <- 0 until textNumber.length()) {
        val charDigit = "" + textNumber.charAt(i)
        
        recursiveNumberCount(Integer.valueOf(charDigit), queue)
      }
    } else {
      queue(n) += 1
    }
  }
  
  def main(args: Array[String]) {
    println(solve(11))
  }
}