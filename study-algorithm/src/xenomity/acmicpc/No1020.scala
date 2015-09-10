package xenomity.acmicpc

/**
 * @author Xenomity a.k.a P-slinc’ (이승한)
 */
object No1020 {
  val fixedLines = Array(6, 2, 5, 5, 4, 5, 6, 3, 7, 5)
  
  private def digitSum(counter: String): Int = counter.toList.map(x => fixedLines(x.asDigit)).sum
  
  private def makeTextNumber(length: Int, number: Int): String = {
		var textNumber = number.toString()
    val numberLength: Int = textNumber.length()
    
    if (length > numberLength) {
      for (i <- 0 until (length - numberLength)) {
        textNumber = "0" + textNumber
      }
    }
    
    return textNumber
  }
  
  def solve(counter: String): Int = {
    val counterLength: Int = counter.length
    val lineSum: Int = digitSum(counter)
    var currentNumber: Int = counter.toInt + 1
    
    while (digitSum(makeTextNumber(counterLength, currentNumber)) != lineSum) {
      currentNumber += 1
    }
    
    return currentNumber - counter.toInt
  }
  
  def main(args: Array[String]) {
    println(solve("007"))
  }
}