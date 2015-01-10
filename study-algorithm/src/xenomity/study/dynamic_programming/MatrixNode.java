package xenomity.study.dynamic_programming;

/**
 * 행렬 경로 문제
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 * @since 2014. 12. 26.
 *
 */
public final class MatrixNode {

	private static final int[][] MATRIX_DATA = new int[][] {{6, 7, 12, 5}, {5, 3, 11, 8}, {7, 17, 3, 3}, {8, 10, 14, 9}};
	
	// The Constructor
	private MatrixNode() {}
	
	/**
	 * 최고 행렬 경로값 계산 (non-dynamic programming) 
	 * 
	 * @param i
	 * @param j
	 * @return max value
	 */
	public static int matrixPath(int i, int j) {
		if (i == 0 && j == 0) {
			return MATRIX_DATA[0][0];
		} else if(i == 0) {
			return MATRIX_DATA[0][j] + matrixPath(0, j - 1);
		} else if (j == 0) {
			return MATRIX_DATA[i][0] + matrixPath(i - 1, 0);
		} else {
			return MATRIX_DATA[i][j] + Math.max(matrixPath(i - 1, j), matrixPath(i, j - 1));
		}
	}
	
	public static void main(String[] args) {
		System.out.println(MatrixNode.matrixPath(2, 0));
	}
	
}
