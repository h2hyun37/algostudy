package xenomity.examination.graph;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class GraphSortTest {
	
	private static final int[][] MATRIX_DATA = {
		{ 1, 2, 3 },
		{ 0, 2 },
		{ 0, 1, 3, 4 },
		{ 0, 2, 5, 6 },
		{ 2 },
		{ 3, 6, 7 },
		{ 5, 7 },
		{ 5, 6 }
	};
	
	private Sortable bfs = (matrix, beginVertexIndex) -> {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[matrix.length];
		visited[beginVertexIndex] = true;
		
		queue.add(beginVertexIndex);
		
		while (!queue.isEmpty()) {
			int vertexIndex = queue.poll();
			
			System.out.printf("%d ", vertexIndex);
			
			for (int i = 0; i < matrix[vertexIndex].length; i++) {
				int linkedVertex = matrix[vertexIndex][i];
				
				if (!visited[linkedVertex]) {
					visited[linkedVertex] = true;
					
					queue.add(linkedVertex);
				}
			}
		}
	};
	
	private Sortable dfs = new DFS();
	
	@Test
	public void bfs() {
		bfs.sort(MATRIX_DATA, 0);
	}
	
	@Test
	public void dfs() {
		dfs.sort(MATRIX_DATA, 0);
	}
	
}
