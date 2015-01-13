package xenomity.study.graph.structure;

import xenomity.study.graph.structure.Graph.Vertex;

/**
 * A graph visitor interface that can throw an exception during a visit callback.
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 * @param <T>
 * @param <E>
 */
interface VisitorEX<T, E extends Exception> {
	/**
	 * Called by the graph traversal methods when a vertex is first visited.
	 * 
	 * @param g - the graph
	 * @param v - the vertex being visited.
	 * @throws E exception for any error
	 */
	public void visit(Graph<T> g, Vertex<T> v) throws E;
}