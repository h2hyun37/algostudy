package h2hyun37.euler;



/*
 * 숫자 1부터 시작해서 우측으로부터 시계방향으로 감아 5×5 행렬을 만들면 아래와 같이 됩니다.
 *
 * 21 22 23 24 25
 * 20  7  8  9 10
 * 19  6  1  2 11
 * 18  5  4  3 12
 * 17 16 15 14 13
 *
 * 여기서 대각선상의 숫자를 모두 더한 값은 101 입니다.
 *
 * 같은 방식으로 1001×1001 행렬을 만들었을 때, 대각선상의 숫자를 더하면 얼마가 됩니까?
 *
 */

public class Problem28 extends AbstractProblem {




	@Override
	public void solveProblem() {

		int size = 1001; // 반드시 홀수여야 함

		int[][] matrix = new int[size][size];


		int step = 1; // 각 루프에서 진행할 step수
		int sign = 1; // 부호. +방향으로 나갈것인지 -방향으로 나갈것인지.
		int value = 1;
		int maxValue = size * size;

		int x = size / 2;
		int y = size / 2;

		matrix[x][y] = value;

		while (value <= maxValue) {

			/*
			 * y축
			 */
			for (int idx = 1; idx <= step; idx++) {

				if (++value > maxValue) {
					break;
				}

				y = y + sign;

				// System.out.printf("[idx:%d (step:%d)] (%d,%d) : %d\n",
				// idx, step, x, y, value);

				matrix[x][y] = value;

			}

			/*
			 * x축
			 */
			for (int idx = 1; idx <= step; idx++) {

				if (++value > maxValue) {
					break;
				}

				x = x + sign;

				// System.out.printf("[idx:%d (step:%d)] (%d,%d) : %d\n",
				// idx, step, x, y, value);

				matrix[x][y] = value;

			}


			step++;
			sign *= -1;

		}

		// for (int a = 0; a < size; a++) {
		// for (int b = 0; b < size; b++) {
		// System.out.printf("%3d ", matrix[a][b]);
		// }
		// System.out.print("\n");
		// }

		int sum = 0;
		for (int idx1 = 0, idx2x = size - 1, idx2y = 0; idx1 < size
				&& idx2x >= 0;) {

			if (idx1 == idx2x && idx1 == idx2y) {
				sum += matrix[idx1][idx1];
			} else {
				sum += matrix[idx1][idx1];
				sum += matrix[idx2y][idx2x];
			}

			idx1++;
			idx2x--;
			idx2y++;
		}

		System.out.println("result : " + sum);

	}

	public static void main(String[] args) {

		Problem28 problem = new Problem28();
		problem.solveProblemWithTimeMeasurement();

	}


}
