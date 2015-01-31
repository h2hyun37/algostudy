package xenomity.examination

class InsertionSort(inputArray:Array[Int]) {

  def sort() {
    for (i <- 0 to (inputArray.length - 2)) {
      for (j <- (i + 1) to (inputArray.length - 1)) {
        if (inputArray(j) < inputArray(i)) {
        	var temp = inputArray(i);
        	inputArray(i) = inputArray(j);
          inputArray(j) = temp;
        }
      }
    }
  }
  
}

object InsertionSortTest {
  
  private var inputArray = Array(4, 7, 6, 1, 3, 9, 5, 2);
  
  def main(args:Array[String]) {
    new InsertionSort(inputArray).sort();
    
    println(inputArray.mkString(", "));
  }
  
}