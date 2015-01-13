package xenomity.study.graph.structure;

import xenomity.study.graph.structure.Graph.Vertex;

/**
 * A graph visitor interface.
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 * @param <T>
 */
interface Visitor<T> {
	/**
	 * Called by the graph traversal methods when a vertex is first visited.
	 * 
	 * @param g - the graph
	 * @param v - the vertex being visited.
	 */
	public void visit(Graph<T> g, Vertex<T> v);
}