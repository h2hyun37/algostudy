package xenomity.acmicpc

object No1012 {
  private final val FLAG_MARKED: Int = 100
	private final val FLAG_NONE: Int = 0
	private final val FLAG_EXIST: Int = 1
  
  def solve(matrix: Array[Array[Int]]): Int = {
    var distinctCounter: Int = 0
    
    for (y <- 0 until matrix.length) {
      for (x <- 0 until matrix(0).length) {
        if (y > 0) {
          if (matrix(y - 1)(x) >= FLAG_MARKED && matrix(y)(x) == FLAG_EXIST) {
            matrix(y)(x) = matrix(y - 1)(x)
          }
        }
        
        if (x > 0) {
          if (matrix(y)(x - 1) >= FLAG_MARKED && matrix(y)(x) == FLAG_EXIST) {
            matrix(y)(x) = matrix(y)(x - 1)
          }
        }
        
        if (matrix(y)(x) == FLAG_EXIST) {
          distinctCounter += 1
          
          matrix(y)(x) = FLAG_MARKED + distinctCounter
        }
      }
    }
    
    distinctCounter
  }
  
  def main(args: Array[String]) {
    val result = solve(Array(
        Array(1, 1, 0, 0, 0, 0, 0, 0, 0, 0),
        Array(0, 1, 0, 0, 0, 0, 0, 0, 0, 0),
        Array(0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
        Array(0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
        Array(0, 0, 1, 1, 0, 0, 0, 1, 1, 1),
        Array(0, 0, 0, 0, 1, 0, 0, 1, 1, 1)))
        
    println(result)
  }
}