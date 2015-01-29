package xenomity.examination;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 홍길동이 세운 율도국은 도시계획이 잘되어 있어 바둑판처럼 가로/세로로 뻗은 도로들 사이에 가옥이 들어서 있다.
 * 부러울것 없는 율도국이었지만 관군의 토벌에 대한 대비책을 마련하지 않을 수는 없었다.
 * 이에 홍길동은 관군 의 침략을 효과적으로 봉쇄하기 위해 몇 곳의 사거리에 초소를 건설하여 관군의 침략에 대비하고 있었다.
 * 초소 사이의 신호 전달은 횃불을 이용하였는데 (가로 세로 상관없이 직선상으로) 초소가 보이는 곳 까지 가서 횃불 을 들면 해당 초소로 신호가 전달되는 방식이었다.
 * 초소들은 순서대로 신호를 전달받아야 했다. 다만 동일 직선상 에 있는 초소는 동시에 신호 전달이 가능하다 (문제 해설 참고)
 * 초소의 위치는 사사분면 위의 좌표로 주어지며, 통신병은 원점 O(0,0)에 위치한다.
 * 문제 : 초소들의 위치가 주어졌을 때 통신병의 최단 이동 거리를 구하시오
 * 
 * -- 주의 사항 --
 * - 초소의 순서는 (초소 좌표)입력 순서에 따른다.
 * - 반드시 정해진 순서대로 관군의 침략을 알려야 한다.
 * - 동일한직선거리상에있다면순서에상관없이명령을전달받을수있다.
 * - 가로/세로 거리는 1이라 가정한다.
 * - 통신병은 일직선으로만 이동 가능하다
 * - System.in 혹은 scanf등의 표준 입력을 이용하지 말고 코드상에 변수로 입력하시오
 * - 힌트:본문제는모든초소를방문해보지않고는해결할수없다.
 * 
 * 해설
 * 출력 형식 예시 (표준 출력) 11
 * ￼￼￼￼￼￼￼￼￼int count = 5; // 초소의 개수
 * // 초소의 좌표가 배열로 주어진다.
 * // 주어진 초소의 순서대로 명령이 전달되어야 함
 * int[][] gPoint =
 * {{8, 3},{7, -4},{8, 1},{-2, 1},{6, -2}}; //여기서는 {8,3}이 1번초소, {7,-4}가 2번초소
 * ￼￼￼￼￼통신병은 1번 초소에 명령을 전달하기 위해 (8,0) 혹은 (0,3) 두 위치로 이동 가능하다.
 * 두 위치 중 남은 초소에 명령 전달이 유리(최단거리인)한 위치를 찾는데, 여기서는 (8,0) 이다.
 * 이와 같은 방식으로 이동해서 최단 이동 경로를 구하게 되면 결국
 * (0,0) -> (8,0) -> (7,0) -> (7,1) -> (6,1) 이와 같이 이동하게 되어 결국 11만큼 이동하게 된다.
 * 3번째 초소{8,1}의 경우 {8,0}으로 이동했을때 동시에 신호를 전달받게 된다.
 * 
 */
public class DaumProblem1 {

	private static final int[][] TEST_MATRIX = {{8, 3}, {7, -4}, {8, 1}, {-2, 1}, {6, -2}};
	
	private DaumProblem1() {}
	
	public static int matrixPath(final int[][] matrixData) {
		Queue<Integer> xQueue = new LinkedList<>();
		Queue<Integer> yQueue = new LinkedList<>();
		int[] previousPoint = {0, 0};
		int totalNodeLength = 0;
		
		// TODO: 유리한 위치 점령(결국은 최단 거리 검색이 먼저 선행되야 하는 것이 아닌지...??)
		
		// 순회
		for (int i = 0; i < matrixData.length; i++) {
			int absX = matrixData[i][0];
			int absY = matrixData[i][1];
			
			if (yQueue.contains(absY)) {
				continue;
			} else if (xQueue.contains(absX) && !yQueue.contains(absY)) {
				xQueue.add(previousPoint[0]);
				yQueue.add(absY);
				
				totalNodeLength += (Math.abs(absY - previousPoint[1]));
				previousPoint[1] = absY;
			} else {
				xQueue.add(absX);
				yQueue.add(previousPoint[1]);
				
				totalNodeLength += (Math.abs(absX - previousPoint[0]));
				previousPoint[0] = absX;
			}
			
			System.out.println("Current Node: " + previousPoint[0] + ", " + previousPoint[1]);
			System.out.println("Current Sum: " + totalNodeLength);
			System.out.println();
		}
		
		return totalNodeLength;
	}
	
	public static void main(String[] args) {
		DaumProblem1.matrixPath(TEST_MATRIX);
	}
	
}
