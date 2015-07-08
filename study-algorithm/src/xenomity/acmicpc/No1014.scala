package xenomity.acmicpc

/**
 * No. 1014
 * 
 * @author Xenomity a.k.a P-slinc’ (이승한)
 */
object No1014 {
  private final val POSSIBLE_LOCATION: Char = '.'
  
  def solve(locationMap: Array[Array[Char]]): Int = {
    return count(locationMap, true).max(count(locationMap, false))
  }
  
  private def count(locationMap: Array[Array[Char]], isOdd: Boolean): Int = {
    var counter: Int = 0
    var startIndex: Int = 0
    
    if (isOdd) {
      startIndex = 1
    }
    
    for (i <- startIndex until locationMap(0).length by 2) {
      for (j <- 0 until locationMap.length) {
        if (locationMap(j)(i) == POSSIBLE_LOCATION) {
          counter = counter.+(1)
        }
      }
    }
    
    return counter
  }
  
  def main(args: Array[String]) {
    println(
        solve(
            Array(
                Array('.', '.', '.'),
                Array('.', '.', '.'))))
    println(
        solve(
            Array(
                Array('x', '.', 'x'),
                Array('x', 'x', 'x'))))
    println(
        solve(
            Array(
                Array('.', '.', '.', '.', 'x', '.', '.', '.', '.', '.'),
                Array('.', '.', '.', '.', '.', '.', '.', '.', '.', '.'),
                Array('.', '.', '.', '.', '.', '.', '.', '.', '.', '.'),
                Array('.', '.', 'x', '.', '.', '.', '.', '.', '.', '.'),
                Array('.', '.', '.', '.', '.', '.', '.', '.', '.', '.'),
                Array('x', '.', '.', '.', 'x', '.', 'x', '.', '.', '.'),
                Array('.', '.', '.', '.', '.', '.', '.', '.', '.', 'x'),
                Array('.', '.', '.', 'x', '.', '.', '.', '.', '.', '.'),
                Array('.', '.', '.', '.', '.', '.', '.', '.', 'x', '.'),
                Array('.', 'x', '.', '.', '.', 'x', '.', '.', '.', '.'))))
  }
}