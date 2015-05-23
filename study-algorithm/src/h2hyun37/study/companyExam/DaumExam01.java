package h2hyun37.study.companyExam;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DaumExam01 {

	static int[][] checkPoint = { { 8, 3 }, { 7, -4 }, { 8, 1 }, { -2, 1 }, { 6, -2 } };
	static int[] startPoint = { 0, 0 };


	/*
	 * 홍길동이 이동한 좌표를 class로 나타낸다.
	 *
	 * 내부에는
	 * 	- 이 좌표까지 이동하면서 누적된 각각의 이동거리
	 * 	- 이 좌표까지 이동하면서 신호를 전달한 초소 목록
	 *  - 다음 초소에 신호를 주기 위해 x축을 이동하는 좌표 정보
	 *  - 다음 초소에 신호를 주기 위해 y축을 이동하는 좌표 정보
	 *
	 *  등을 가지고 있다.
	 */
	class Visit {

		/* xy : 홍길동이 이동한 위치의 x,y 좌표 */
		int[] xy;

		/* accumulatedMovingDistance : 이 좌표까지 이동하면서 누적된 이동거리 */
		int accumulatedMovingDistance = 0;

		/* notificatedCheckPoint : 이 좌표까지 이동하면서 신호를 전달한 초소. */
		boolean[] notificatedCheckPoint = new boolean[checkPoint.length];

		/*
		 * childX : 다음 초소에 신호를 주기 위해 x축을 이동하는 좌표 정보 childY : 다음 초소에 신호를 주기 위해
		 * y축을 이동하는 좌표 정보
		 */
		Visit childX = null;
		Visit childY = null;


		public Visit(int[] xy) {
			this.xy = xy;
		}

		public Visit(int x, int y) {
			xy = new int[2];
			xy[0] = x;
			xy[1] = y;
		}

		public void setAccumulatedMovingDistance(Visit parent, int distance) {
			this.accumulatedMovingDistance = parent.accumulatedMovingDistance + distance;
		}

		public void copyNotificatedCheckPoint(Visit parent) {
			this.notificatedCheckPoint = Arrays.copyOf(
					parent.notificatedCheckPoint,
					parent.notificatedCheckPoint.length);
		}

		/*
		 * 신호를 전달한 초소 목록 업데이트
		 *
		 * 	- checkPointIdx : 이번에 신호를 전달할 초소 인덱스
		 *  - point : 이동한 위치. axis 가 'x' 면 이동한 위치의 x 좌표, 'y' 면 이동한 위치의 y 좌표
 		 *  - axis : 이동한 축. 'x' 또는 'y'만 가능
		 */
		public void updateNotification(int checkPointIdx, int point, char axis) {

			int axisIdx = -1;
			if (axis == 'x') {
				axisIdx = 0;
			} else if (axis == 'y') {
				axisIdx = 1;
			} else {
				return;
			}

			for (int idx = checkPointIdx; idx < this.notificatedCheckPoint.length; idx++) {
				if (point == checkPoint[idx][axisIdx]) {
					this.notificatedCheckPoint[idx] = true;
				}
			}
		}

	}


	/*
	 * (0,0) 을 root 로 하여
	 *  - x 축 이동하는 경우
	 *  - y 축 이동하는 경우
	 *
	 * 2가지 씩을 이진 트리 형태로 구성한다.
	 *
	 * 단 하위 노드를 생성하기 위해 이동하는 위치가 이미 횃불로 신호를 준 경우에는
	 * 하위 노드 생성을 하지 않고 넘어간다
	 *
	 * 이진 트리를 구성하기 위해 순회하는 방법은
	 * 	- 일단 레벨 순서 순회(level-order) (또는 너비 우선 순회(breadth-first traversal))로 순회하며 생성
	 * 	- 나중에는 preorder 로 해보자.
	 *
	 *
	 */
	public void solveProblem() {

		// 최단 이동거리 저장 변수
		int minDistance = Integer.MAX_VALUE;


		/* 시작점 (0,0) 설정 */
		Visit root = new Visit(startPoint);

		/*
		 * 이중 큐를 사용
		 *
		 * 	- parentQueue : level-order 로 순회하기 위해 홍길동이 이동하는 좌표를 queue 에 저장
		 *  - childQueue : parentQueue를 순회하면서 생기는 child node 들을 저장하여 다음 loop에서 사용.
		 */
		Queue<Visit> parentQueue = new LinkedList<Visit>();
		parentQueue.add(root);
		Queue<Visit> childQueue = new LinkedList<Visit>();

		System.out.printf("[start point : (%s,%s)]\n", root.xy[0], root.xy[1]);


		/*
		 * STEP 1-1) 모든 초소별 loop를 돈다
		 *
		 *	- checkPointIdx : 횃불로 신호를 주려는 초소의 index
		 */
		for (int checkPointIdx = 0; checkPointIdx < checkPoint.length; checkPointIdx++) {

			/* point : 이번에 횃불로 신호를 주려는 초소 */
			int[] pointXY = checkPoint[checkPointIdx];

			System.out.printf("\n[next checkPoint : (%s,%s)]\n", pointXY[0],
					pointXY[1]);


			/*
			 * STEP 1-2) 각 초소별 parent Node 들의 loop를 돈다 (Queue에서 하나씩 꺼내서)
			 */
			Visit visit = null;
			while ((visit = parentQueue.poll()) != null) {

				Visit child;

				child = moveToChild(visit, pointXY, checkPointIdx, 'x');
				// child node 가 중복될 필요는 없으므로 중복제외하고 입력
				if (!childQueue.contains(child))
					childQueue.add(child);

				/* 맨 마지막 leaf node 의 경우 최단거리를 비교하여 더욱 최단거리인 경우 별도 저장 */
				if (checkPointIdx == checkPoint.length - 1) {
					minDistance = child.accumulatedMovingDistance < minDistance ? child.accumulatedMovingDistance
							: minDistance;
				}

				child = moveToChild(visit, pointXY, checkPointIdx, 'y');
				// child node 가 중복될 필요는 없으므로 중복제외하고 입력
				if (!childQueue.contains(child))
					childQueue.add(child);

				/* 맨 마지막 leaf node 의 경우 최단거리를 비교하여 더욱 최단거리인 경우 별도 저장 */
				if (checkPointIdx == checkPoint.length - 1) {
					minDistance = child.accumulatedMovingDistance < minDistance ? child.accumulatedMovingDistance
							: minDistance;
				}
			}

			/*
			 * child 들을 parentQueue로 이동
			 */
			Visit child;
			while ((child = childQueue.poll()) != null) {
				parentQueue.add(child);
			}

		}

		System.out.println("MIN moving distance : " + minDistance);

	}


	/**
	 * @param checkPointIdx
	 * @param pointX
	 * @param parent
	 * @param nowX
	 * @param nowY
	 */
	private Visit moveToChild(Visit parent, int[] pointXY, int checkPointIdx,
			char axis) {

		if (!(axis == 'x' || axis == 'y')) {
			System.out.println("ERROR axis parameter : " + axis);
			return null;
		}

		/* 현재 이동위치의 x,y 좌표 */
		int parentX = parent.xy[0];
		int parentY = parent.xy[1];

		/* for debugging */
		System.out
				.printf("\t[parent (%s, %s)] accumulatedLength : %s, checkedPoint : %s\n",
						parentX, parentY, parent.accumulatedMovingDistance,
						Arrays.toString(parent.notificatedCheckPoint));

		/*
		 * 기존에 이미 신호를 준 초소는 PASS
		 */
		if (parent.notificatedCheckPoint[checkPointIdx] == true) {
			System.out
					.printf("\t\t[next checkPoint (%s, %s)] is already checked (checkPointIdx = %s, parent.notificatedCheckPoint = %s)\n\n",
							pointXY[0], pointXY[1], checkPointIdx,
							Arrays.toString(parent.notificatedCheckPoint));
			return parent;
		}

		/*
		 * 다음 이동위치(child) instance 생성 : axis 가 'x'면 x좌표, 'y'면 'y' 좌표를 구한다
		 */
		int point = -1;
		Visit child = null;
		int movingDistance = -1;

		if (axis == 'x') {
			point = pointXY[0];

			child = new Visit(point, parentY);
			movingDistance = Math.abs(point - parentX);

			parent.childX = child;
		} else {
			point = pointXY[1];

			child = new Visit(parentX, point);
			movingDistance = Math.abs(point - parentY);

			parent.childY = child;
		}


		/*
		 * 다음 이동 위치 instance 설정
		 *
		 * 	1) 누적된 이동거리 저장 : 기존 이동거리 + 이번 이동거리를 누적하여 더한다
		 * 	2) 누적된 신호전달 초소 복사
		 * 	3) 신호전달 초소 업데이트 : 이번 이동하면서 신호를 전달한 초소를 업데이트
		 */

		// 1) 누적된 이동거리 저장
		child.setAccumulatedMovingDistance(parent, movingDistance);

		// 2) 누적된 신호전달 초소 복사
		child.copyNotificatedCheckPoint(parent);

		// 3) 신호전달 초소 업데이트
		child.updateNotification(checkPointIdx, point, axis);



		/* for debugging */
		System.out
				.printf("\t\t[child%S (%s, %s)] accumulatedLength : %s, checkedPoint : %s\n\n",
						axis,
						child.xy[0], child.xy[1],
						child.accumulatedMovingDistance,
						Arrays.toString(child.notificatedCheckPoint));

		return child;
	}



	public static void main(String[] args) {

		DaumExam01 exam = new DaumExam01();
		exam.solveProblem();
	}

}
