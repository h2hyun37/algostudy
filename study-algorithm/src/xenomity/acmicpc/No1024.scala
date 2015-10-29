package xenomity.acmicpc

object No1024 {
  def solve(n: Int, l: Int): Seq[Int] = {
    var sequenceSize: Int = l
    
    while (sequenceSize >= 2 && sequenceSize < 100) {
      var sum: Int = 0
      var startNumber: Int = 1
      
      while (sum < n) {
        val tempSequence: Range = startNumber until startNumber + sequenceSize
        sum = tempSequence sum
        
        if (sum == n) {
          return tempSequence
        }
        
        startNumber += 1
      }
      
      sequenceSize += 1
    }
    
    return Seq(-1)
  }
  
  def main(args: Array[String]) {
    println(solve(18, 2) mkString(" "))
  }
}