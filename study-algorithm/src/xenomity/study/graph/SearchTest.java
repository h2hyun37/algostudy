package xenomity.study.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Breadth First/Depth First Search Test (BFS/DFS)
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 * @since 2015. 1. 10.
 *
 */
public final class SearchTest {
	
	private int[][] graphMatrix;
	private boolean[] visited;
	
	/**
	 * The Constructor
	 * 
	 * @param graphMatrix graph matrix
	 */
	public SearchTest(int[][] graphMatrix) {
		this.graphMatrix = graphMatrix;
		this.visited = new boolean[graphMatrix.length];
	}

	/**
	 * Search by BFS
	 * 
	 * @param beginVertex begin vertex
	 */
	public void bfs(int beginVertex) {
		// initialize
		Queue<Integer> queue = new LinkedList<>();
		initialize();
		
		System.out.print("BFS - " + beginVertex + " ");
		
		visited[beginVertex] = true;
		queue.add(beginVertex);
		
		int currentVertex = beginVertex;
		while (!queue.isEmpty()) {
			for (int i = 0; i < graphMatrix.length; i++) {
				if (graphMatrix[currentVertex][i] == 1 && !visited[i]) {
					queue.add(i);
					visited[i] = true;
					
					System.out.print("- " + i + " ");
				}
			}
			
			currentVertex = queue.poll();
		}
		
		System.out.println();
	}
	
	/**
	 * Search by DFS
	 * 
	 * @param beginVertex begin vertex
	 */
	public void dfs(int beginVertex) {
		// initialize
		initialize();
		
		System.out.print("DFS ");
		
		recursiveDfs(beginVertex);
		
		System.out.println();
	}
	
	private void recursiveDfs(int beginVertex) {
		visited[beginVertex] = true;
		
		System.out.print("- " + beginVertex + " ");
		
		for (int i = 0; i < graphMatrix.length; i++) {
			if (graphMatrix[beginVertex][i] == 1 && !visited[i]) {
				recursiveDfs(i);
			}
		}
	}
	
	private void initialize() {
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) {
		int[][] testGraphMatrix = {
			{ 0, 1, 1, 1, 0, 0, 0, 0 },
			{ 1, 0, 1, 0, 0, 0, 0, 0 },
			{ 1, 1, 0, 1, 1, 0, 0, 0 },
			{ 1, 0, 1, 0, 0, 1, 1, 0 },
			{ 0, 0, 1, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 1, 0, 0, 1, 1 },
			{ 0, 0, 0, 1, 0, 1, 0, 1 },
			{ 0, 0, 0, 0, 0, 1, 1, 0 }
		};
		
		SearchTest test = new SearchTest(testGraphMatrix);
		test.bfs(0);
		test.dfs(0);
	}

}
