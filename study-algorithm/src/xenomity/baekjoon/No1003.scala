package xenomity.baekjoon

/*
 * No. 1003
 * 
 * 
 */
class No1003 {
  
  private var zeroCounter = 0;
  private var oneCounter = 0;

  def fibonacci(n: Int): Int = {
    if (n == 0) {
      zeroCounter += 1;
      
      0;
    } else if (n == 1) {
      oneCounter += 1;
      
      1;
    } else {
      fibonacci(n - 1) + fibonacci(n - 2);
    }
  }
  
  def reset() {
    zeroCounter = 0;
    oneCounter = 0;
  }
  
  def countZero(): Int = zeroCounter;
  def countOne(): Int = oneCounter;
  
}

object No1003Test {
  def main(args: Array[String]) {
    var no1003 = new No1003();
    
    no1003.fibonacci(0);
    printf("Zero Counter: %d, One Counter: %d\n", no1003 countZero, no1003 countOne);
    
    no1003.reset;
    no1003.fibonacci(1);
    printf("Zero Counter: %d, One Counter: %d\n", no1003 countZero, no1003 countOne);
    
    no1003.reset;
    no1003.fibonacci(3);
    printf("Zero Counter: %d, One Counter: %d\n", no1003 countZero, no1003 countOne);
  }
}