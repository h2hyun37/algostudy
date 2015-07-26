package xenomity.acmicpc

import scala.collection.mutable.ArrayBuffer

/**
 * No. 1017
 * 
 * @author Xenomity a.k.a P-slinc’ (이승한)
 */
object No1017 {
  def solve(numbers: Array[Int]): Array[Int] = {
    var resultQueue: Array[Int] = new Array(0)
    
    for (i <- 1 until numbers.length) {
      if (isPrime(numbers(0) + numbers(i))) {
        val clonedNumbers: List[Int] = List(numbers: _*).filter(n => n != numbers(0) && n != numbers(i))
        
        if (isRecursiveMatch(clonedNumbers)) {
        	resultQueue = resultQueue :+ numbers(i)
        }
      }
    }
    
    return resultQueue
  }
  
  private def isPrime(number: Int): Boolean = {
    for (i <- 2 to number / 2) {
      if (number % i == 0) {
        return false
      }
    }
    
    return true
  }
  
  private def isRecursiveMatch(numbers: List[Int]): Boolean = {
    if (numbers.length > 2) {
      for (i <- 0 until numbers.length - 1) {
        for (j <- i + 1 until numbers.length) {
          if (isPrime(numbers(i) + numbers(j))) {
            val clonedNumbers: List[Int] = List(numbers: _*).filter(n => n != numbers(i) && n != numbers(j))
            
            return isRecursiveMatch(clonedNumbers)
          }
        }
      }
    } else {
      return isPrime(numbers(0) + numbers(1))
    }
    
    return false
  }
  
  def main(args: Array[String]) {
    println(solve(Array(1, 4, 7, 10, 11, 12)).mkString(", "))
  }
}