package xenomity.acmicpc

object No1009 {
  private final val MAX_COM: Int = 10
  
  def identityPararrelNumber(a: Int, b: Int): Int = {
    var lastNumber = a
    
    for (i <- 2 to b) {
      lastNumber = lastNumber * a % MAX_COM
    }
    
    if (lastNumber == 0) {
      lastNumber = MAX_COM
    }
    
    lastNumber
  }
  
  def main(args: Array[String]) {
    println(identityPararrelNumber(1, 6))
    println(identityPararrelNumber(3, 7))
    println(identityPararrelNumber(6, 2))
    println(identityPararrelNumber(7, 100))
    println(identityPararrelNumber(9, 635))
  }
}