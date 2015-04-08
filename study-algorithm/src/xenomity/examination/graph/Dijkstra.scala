package xenomity.examination.graph

/*
 * Vertex Trait
 */
trait Vertex {
  private var weight: Int = Int.MaxValue
  
  def getWeight() = weight
  def setWeight(weight: Int) = this.weight = weight
}
/*
 * Linked Vertex Implementation
 */
class LinkedVertex(final val id: String) extends Vertex {
  private final var edges = Array[Edge]()
  
  def addEdge(edge: Edge) = edges = edges :+ edge
  def removeEdge(index: Int) = edges(index) = null
  def getEdges() = edges
}

/*
 * Edge
 */
class Edge(val targetVertex: LinkedVertex, val length: Int)

/*
 * Dijkstra Algorithm
 */
object Dijkstra {
  def search(vertices: Array[LinkedVertex], rootVertexId: String, targetVertexId: String) {
    // argument validation
    val rootVertexOption = vertices.find(x => x.id.equals(rootVertexId))
    
    if (rootVertexOption.isEmpty) {
      throw new IllegalArgumentException("not found root vertex")
    }
    
    // 정점 집합 S.
    var queue = Array[LinkedVertex]()
    
    // 시작 정점 가중치 0으로 초기화
    rootVertexOption.get.setWeight(0)  // 가중치 0으로 초기화.
    
    // 모든 정점을 순회
    while (queue.length != vertices.length) {
      // 인접 집합 Q에서 가중치가 가장 작은 정점 u를 구한다.
      val minLengthVertex = vertices.filter(x => !queue.contains(x)).minBy(_.getWeight())
      
      // 정점 집합 S에 정점 u를 추가한다.
      queue = queue :+ minLengthVertex
      
      // 정점 u로부터 연결된 정점들의 집합 순회
      for (i <- 0 until minLengthVertex.getEdges().length) {
        val linkedEdge: Edge = minLengthVertex.getEdges()(i)
        
        if (!queue.contains(linkedEdge.targetVertex)) {
          val newLength = minLengthVertex.getWeight() + linkedEdge.length
          
          // 이전에 계산된 인접 정점의 거리보다 더 짧은 거리가 존재할 경우 가중치 재계산.
          if (newLength < linkedEdge.targetVertex.getWeight()) {
            linkedEdge.targetVertex.setWeight(newLength)
          }
        } else {
          // 인접 정점이 이미 계산되어 S 집합에 포함된 정점이라면 링크 제거.
          minLengthVertex.removeEdge(i)
        }
      }
      
      // debug
      printf("[DEBUG] Vertex ID: %s, Weight: %d\n", minLengthVertex.id, minLengthVertex.getWeight())
    }
    
    // result output
    val resultOption = vertices.find(x => x.id.equals(targetVertexId))
    
    if (resultOption.isEmpty) {
      println("target not found.")
    } else {
      val resultVertex = resultOption.get
      
      printf("[Result] Found Vertex: %s, Vertex Weight: %d", resultVertex.id, resultVertex.getWeight())
    }
  }
  
  def main(args: Array[String]) {
    // initialize graph data for test
    val vertexA: LinkedVertex = new LinkedVertex("A")
    val vertexB: LinkedVertex = new LinkedVertex("B")
    val vertexC: LinkedVertex = new LinkedVertex("C")
    val vertexD: LinkedVertex = new LinkedVertex("D")
    val vertexE: LinkedVertex = new LinkedVertex("E")
    val vertexF: LinkedVertex = new LinkedVertex("F")
    val vertexG: LinkedVertex = new LinkedVertex("G")
    val vertexH: LinkedVertex = new LinkedVertex("H")
    
    vertexA.addEdge(new Edge(vertexB, 8))
    vertexA.addEdge(new Edge(vertexC, 9))
    vertexA.addEdge(new Edge(vertexD, 11))
    vertexB.addEdge(new Edge(vertexE, 10))
    vertexC.addEdge(new Edge(vertexB, 6))
    vertexC.addEdge(new Edge(vertexD, 3))
    vertexC.addEdge(new Edge(vertexE, 1))
    vertexD.addEdge(new Edge(vertexF, 8))
    vertexD.addEdge(new Edge(vertexG, 8))
    vertexE.addEdge(new Edge(vertexH, 2))
    vertexF.addEdge(new Edge(vertexC, 12))
    vertexF.addEdge(new Edge(vertexH, 5))
    vertexG.addEdge(new Edge(vertexF, 7))
    vertexH.addEdge(new Edge(vertexG, 4))
    
    val vertices: Array[LinkedVertex] = Array(vertexA, vertexB, vertexC, vertexD, vertexE, vertexF, vertexG, vertexH)
    
    // dijkstra search
    search(vertices, vertexA.id, vertexH.id)
  }
}