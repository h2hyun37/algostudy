package xenomity.acmicpc

/**
 * No. 1018
 * 
 * @author Xenomity a.k.a P-slinc’ (이승한)
 */
object No1018 {
  def solve(chessBoard: Array[String]): Int = {
    // #1. Initialize
    var replaceCounter: Int = 0
    var source: StringBuilder = new StringBuilder()
    val criteriaPoint = chessBoard.length
    
    for (i <- 0 until criteriaPoint) {
      source.append(chessBoard(i))
    }
    
    // #2. Match & Replace
    for (i <- 0 until source.length - 1) {
      if ((i + 1) % criteriaPoint == 0 && i < source.length - 1) {
        if (source.charAt(i) != source.charAt(i + 1)) {
          source.replace(i + 1, i + 2, source.charAt(i).toString())
          replaceCounter += 1
        }
      } else if (source.charAt(i) == source.charAt(i + 1)) {
        if (source.charAt(i + 1) == 'W') {
          source.replace(i + 1, i + 2, "B")
        } else {
          source.replace(i + 1, i + 2, "W")
        }
        
        replaceCounter += 1
      }
    }
    
    return replaceCounter
  }
  
  def main(args: Array[String]) {
    println(
        solve(
            Array(
                "WBWBWBWB",
                "BWBWBWBW",
                "WBWBWBWB",
                "BWBBBWBW",
                "WBWBWBWB",
                "BWBWBWBW",
                "WBWBWBWB",
                "BWBWBWBW")))
  }
}