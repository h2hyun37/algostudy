package xenomity.study.graph

/**
 * Prim Algorithm (Minimum Spanning Tree)
 */
class PrimMST(matrix:Array[Array[Int]]) {

  private var vertexCount = matrix.length;
  private var lowCost = new Array[Int](vertexCount);
  private var closest = new Array[Int](vertexCount);
  
  def search() {
    for (i <- 0 to (vertexCount - 1)) {
      lowCost(i) = matrix(0)(i);
      closest(i) = 0;
    }
    
    for (i <- 1 to (vertexCount - 1)) {
      var tempIndex = 1;
      
      for (j <- 2 to (vertexCount - 1)) {
        if (lowCost(j) < lowCost(tempIndex)) {
          tempIndex = j;
        }
      }
      
      lowCost(tempIndex) = 999;
      
      for (j <- 1 to (vertexCount - 1)) {
        if (lowCost(j) > matrix(tempIndex)(j) && lowCost(j) < 999) {
          lowCost(j) = matrix(tempIndex)(j);
          closest(j) = tempIndex;
        }
      }
    }
  }
  
}