package xenomity.acmicpc

object No1011 {
  def getMinimumLength(startPosition: Int, endPosition: Int): Int = {
    // 만약 시작 지점과 도착 지점의 거리가 3 미만인 경우.
    if (endPosition - startPosition < 3) {
      endPosition - startPosition
    }
    
    // initialize
    var evalGap: Int = 0
    var currentPosition = startPosition
    var sequence: Array[Int] = Array()
    
    // 1씩 증가하는 증차 수열 생성.
    while (currentPosition < endPosition) {
      sequence = sequence :+ currentPosition
      
      evalGap += 1
      currentPosition += evalGap
    }
    
    // 증차 수열의 마지막 요소가 도착 지점의 바로 이전 요소와 같지 않다면 추가.
    // 처음과 마지막의 이동 거리는 무조건 1이라는 조건 때문임.
    if (sequence(sequence.size - 1) != (endPosition - 1)) {
      sequence = sequence :+ endPosition - 1
    }
    
    sequence.size
  }
  
  def main(args: Array[String]) {
    println(getMinimumLength(0, 3))
    println(getMinimumLength(1, 5))
    println(getMinimumLength(45, 50))
  }
}