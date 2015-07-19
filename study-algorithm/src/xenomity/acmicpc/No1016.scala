package xenomity.acmicpc

/**
 * No. 1016
 * 
 * @author Xenomity a.k.a P-slinc’ (이승한)
 */
object No1016 {
  def main(args: Array[String]) {
    val noSquareNumbers = 1.to(10).count(x => !math.sqrt(x).isValidInt)
    
    println(noSquareNumbers)
  }
}