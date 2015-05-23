package xenomity.examination

object Daum2 {
  final val RIGHT_CASE: String = "right word"
	final val WRONG_CASE: String = "wrong word"
	final val UNKNOWN_CASE: String = "unknown word"
  private final val CHAR_QUESTION: Char = '?'
  
  def solve(inputs: Array[String]) {
    for (i <- 0 until inputs.length) {
      printf("%s: %s\n", inputs(i), validate(inputs(i)))
    }
  }
  
  /*
   * Validation
   * 
   * rule:
   * 정상: ?거나 나머지 케이스를 통과하는 경우 정상.
   * 잘못됨: 1이나 2가 연속으로 나오거나, ?가 홀수개로 연속되어 나오면 그 앞과 뒤의 숫자가 다르거나, ?가 짝수개로 연속되어 나오면 그 앞과 뒤의 숫자가 같으면 잘못된 케이스.
   * 알 수 없음: ?로 시작하거나 끝나거나, ?가 홀수개로 연속되어 나오면 그 앞과 뒤의 숫자가 같거나, ?가 짝수개로 연속되어 나오면 그 앞과 뒤의 숫자가 다르면 알 수 없 케이스.
   */
  private def validate(word: String): String = {
    if (word.equals(String.valueOf(CHAR_QUESTION))) {
      return RIGHT_CASE
    }
    
    if (word.contains("11") || word.contains("22")) {
      return WRONG_CASE
    }
    
    if (word.contains(String.valueOf(CHAR_QUESTION))) {
      if (word.charAt(0) == CHAR_QUESTION || word.charAt(word.length() - 1) == CHAR_QUESTION) {
        return UNKNOWN_CASE
      }
      
      val startQuestionIndex = word.indexOf(CHAR_QUESTION)
      val endQuestionIndex = word.lastIndexOf(CHAR_QUESTION)
      val previousCharacter = word.charAt(startQuestionIndex - 1)
      val nextCharacter = word.charAt(endQuestionIndex + 1)
      val questionStream = word.substring(startQuestionIndex, endQuestionIndex + 1)
      
      if (questionStream.length() % 2 == 0) {
        if (previousCharacter == nextCharacter) {
          return WRONG_CASE
        } else {
          return UNKNOWN_CASE
        }
      } else {
        if (previousCharacter == nextCharacter) {
          return UNKNOWN_CASE
        } else {
          return WRONG_CASE
        }
      }
    }
    
    RIGHT_CASE
  }
  
  def main(args: Array[String]) {
    solve(Array("?", "11", "22", "12", "1?2", "??1", "1??1", "1???1", "1???2"))
  }
}