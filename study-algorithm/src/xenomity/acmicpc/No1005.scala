package xenomity.acmicpc

/**
 * No 1005
 */
object No1005 {
  
  private class Vertex(val id: Int, val weight: Int, val nextVertex: Int) {}
  
  private var sum: Int = 0
  private var sums: Array[Int] = new Array[Int](10)
  private var sumIndex: Int = 0
  
  // initialize
  private def init() {
    sum = 0
    sums = new Array[Int](10)
    sumIndex = 0
  }
  
  // resolve
  def resolve(graph: Array[Array[Vertex]], beginVertex: Int, targetVertex: Int): Int = {
    // #1. initialize
    init()
    
    // #2. graph - depth first search (dfs)
    dfs(graph, beginVertex, targetVertex)
    
    // #3. calculate max value
    var result: Int = 0

    for (i <- 0 until sums.length) {
      if (result < sums(i)) {
        result = sums(i)
      }
    }
    
    result
  }
  
  // depth first search (dfs)
  private def dfs(graph: Array[Array[Vertex]], currentVertex: Int, targetVertex: Int) {
    if (currentVertex == targetVertex) {
      sums(sumIndex) = sum;
      sumIndex += 1;
      
      return
    }
    
    for (i <- 0 until graph(currentVertex).length) {
      val nextVertex = graph(currentVertex)(i).nextVertex
      sum += graph(currentVertex)(i).weight
      
  	  dfs(graph, nextVertex, targetVertex)
      
      sum -= graph(currentVertex)(i).weight
    }
  }
  
  def main(args: Array[String]) {
    println("Result: " + resolve(
        Array(
            Array(new Vertex(0, 10, 1)),
            Array(new Vertex(1, 1, 2), new Vertex(1, 100, 3)),
            Array(new Vertex(2, 10, 4)),
            Array(new Vertex(3, 10, 4)),
            Array()), 0, 4))
            
    println("Result: " + resolve(
        Array(
            Array(new Vertex(0, 10, 1)),
            Array(new Vertex(1, 20, 2), new Vertex(1, 1, 3)),
            Array(new Vertex(2, 5, 4), new Vertex(2, 8, 5)),
            Array(new Vertex(3, 7, 6)),
            Array(),
            Array(new Vertex(5, 1, 7)),
            Array(new Vertex(6, 1, 7)),
            Array(new Vertex(7, 43, 8)),
            Array()), 0, 7))
  }
}