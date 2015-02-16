package xenomity.examination.graph;

/**
 * Sort Interface
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 * @since 2015. 2. 16.
 *
 */
@FunctionalInterface
public interface Sortable {

	/**
	 * Sort
	 * 
	 * @param matrixData matrix data
	 * @param beginVertexIndex begin vertex index for search
	 */
	void sort(int[][] matrixData, int beginVertexIndex);
	
}
