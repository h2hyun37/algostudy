package xenomity.acmicpc

object No1026 {
  def solve(numbers: List[Int]): List[Int] = {
    if (numbers.length > 2) {
      for (i <- 0 until numbers.length - 1) {
        for ( j <- i + 1 until numbers.length) {
          if (isPrime(numbers(i) + numbers(j))) {
            val childNumbers = numbers
                  .filter(_ != numbers(i))
                  .filter(_ != numbers(j)).toList
            
            return List(numbers(i), numbers(j)) ++ solve(childNumbers)
          }
        }
      }
      
      return List[Int]()
    } else {
      if (isPrime(numbers(0) + numbers(1))) {
        return List(numbers(0), numbers(1))
      } else {
        return List[Int]()
      }
    }
  }
  
  private def isPrime(number: Int): Boolean = {
    for (i <- 2 until number) {
      if (number % i == 0) {
        return false
      }
    }
    
    return true
  }
  
  def main(args: Array[String]) {
    println(solve(List(1, 4, 7, 10, 11, 12)))
  }
}