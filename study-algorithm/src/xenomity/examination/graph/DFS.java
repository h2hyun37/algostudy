package xenomity.examination.graph;

public class DFS implements Sortable {

	@Override
	public void sort(int[][] matrixData, int beginVertexIndex) {
		boolean[] visited = new boolean[matrixData.length];
		
		aDfs(matrixData, beginVertexIndex, visited);
	}
	
	private void aDfs(int[][] matrixData, int vertexIndex, boolean[] visited) {
		visited[vertexIndex] = true;
		
		System.out.printf("%d ", vertexIndex);
		
		for (int i = 0; i < matrixData[vertexIndex].length; i++) {
			int linkedVertex = matrixData[vertexIndex][i];
			
			if (!visited[linkedVertex]) {
				aDfs(matrixData, linkedVertex, visited);
			}
		}
	}

}
