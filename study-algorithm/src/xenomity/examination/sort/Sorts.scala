package xenomity.examination.sort

object Sorts {
  def quickSort(array: Array[Int], startIndex: Int, endIndex: Int) {
    if (startIndex < endIndex) {
      val pivotIndex: Int = {
        val criteriaValue = array(endIndex)
        var partitionIndex = startIndex
        
        for (i <- startIndex until endIndex) {
          if (array(i) <= criteriaValue) {
            if (i != partitionIndex) {
              val temp = array(partitionIndex)
              array(partitionIndex) = array(i)
              array(i) = temp
            }
            
            partitionIndex += 1
          }
        }
        
        array(endIndex) = array(partitionIndex)
        array(partitionIndex) = criteriaValue;
        
        partitionIndex
      }
      
      quickSort(array, startIndex, pivotIndex - 1)
      quickSort(array, pivotIndex + 1, endIndex)
    }
  }
}

object SortTest {
  private final val INPUT_ARRAY = Array(7,4,6,9,2,3,1,5,8)
  
  def main(args: Array[String]) {
    Sorts.quickSort(INPUT_ARRAY, 0, INPUT_ARRAY.length - 1)
    
    println(INPUT_ARRAY.mkString(" "))
  }
}