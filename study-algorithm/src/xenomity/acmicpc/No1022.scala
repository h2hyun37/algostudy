package xenomity.acmicpc

import scala.util.control.Breaks

object No1022 {
  def solve(r1: Int, c1: Int, r2: Int, c2: Int) = {
    // initialize
    val lineLength: Int = math.abs(r1) * 2 + 1
    var currentX: Int = lineLength / 2
    var currentY: Int = currentX
    var currentPoint = 1
    val endPoint = lineLength * lineLength
    val matrix: Array[Array[Int]] = new Array(lineLength)
    
    for (i <- 0 until lineLength) {
      matrix(i) = new Array(lineLength)
    }
    
    matrix(currentY)(currentX) = currentPoint
    var grade: Int = 0
    
    // bind
    Breaks.breakable {
      while (currentPoint <= endPoint) {
        grade += 1
        
        for (j <- 0 until grade) {
          currentX += 1
          
          if (currentPoint >= endPoint) {
            Breaks.break
          }
          
          bind()
        }
        
        for (j <- 0 until grade) {
          currentY -= 1
          bind()
        }
        
        grade += 1
        
        for (j <- 0 until grade) {
          currentX -= 1
          bind()
        }
        
        for (j <- 0 until grade) {
          currentY += 1
          bind()
        }
      }
    }
    
    def bind() {
      currentPoint += 1
        
      matrix(currentY)(currentX) = currentPoint
    }
    
    // printing
    for (i <- 0 until lineLength - (math.abs(r1) - math.abs(r2))) {
      for (j <- 0 until lineLength - (math.abs(c1) - math.abs(c2))) {
        printf("%d\t", matrix(i)(j))
      }
      
      println
    }
  }
  
  def main(args: Array[String]) {
    solve(-3, -3, 2, 0)
  }
}