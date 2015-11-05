package xenomity.acmicpc

import scala.collection.mutable.ArrayBuffer

object No1025 {
  def solve(matrix: Array[Array[Int]]): Int = {
    // initialize
    var buffer = Array[Int]()
    var sqrts = Array[Int]()
    
    for (i <- 0 until matrix.length) {
      buffer ++= matrix(i)
    }
    
    // 1자리에 해당하는 제곱수만 확인.
    for (i <- 0 until buffer.length) {
      for (j <- 0 until buffer.length) {
        val tempNumber = buffer(i) * 10 + buffer(j)
        
        if (math.sqrt(tempNumber) isValidInt) {
          sqrts :+= tempNumber
        }
      }
    }

    sqrts max
  }
  
  def main(args: Array[String]) {
    println(
        solve(
            Array(
                Array(1, 2, 3),
                Array(4, 5, 6))))
  }
}