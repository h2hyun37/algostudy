package xenomity.acmicpc

object No1010 {
  def combination(total: Int, selections: Int): Long = {
    var counter = total
    var numerator: Long = 1
    
    while (counter >= total - selections + 1) {
      numerator *= counter
      
      counter -= 1
    }
    
    var denominator: Long = 1
    counter = selections
    
    while (counter > 0) {
      denominator *= counter
      
      counter -= 1
    }
    
    numerator / denominator
  }
  
  def main(args: Array[String]) {
    println(combination(2, 2))
    println(combination(5, 1))
    println(combination(29, 13))
  }
}