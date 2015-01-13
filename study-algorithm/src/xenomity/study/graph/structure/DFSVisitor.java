package xenomity.study.graph.structure;

import xenomity.study.graph.structure.Graph.Edge;
import xenomity.study.graph.structure.Graph.Vertex;

/**
 * A spanning tree visitor callback interface
 * 
 * @see Graph#dfsSpanningTree(Vertex, DFSVisitor)
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 * @param <T>
 */
interface DFSVisitor<T> {
	/**
	 * Called by the graph traversal methods when a vertex is first visited.
	 * 
	 * @param g - the graph
	 * @param v - the vertex being visited.
	 */
	public void visit(Graph<T> g, Vertex<T> v);

	/**
	 * Used dfsSpanningTree to notify the visitor of each outgoing edge to an
	 * unvisited vertex.
	 * 
	 * @param g - the graph
	 * @param v - the vertex being visited
	 * @param e - the outgoing edge from v
	 */
	public void visit(Graph<T> g, Vertex<T> v, Edge<T> e);
}