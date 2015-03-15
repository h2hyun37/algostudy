package h2hyun37.euler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/*
 * 어떤 대상을 순서에 따라 배열한 것을 순열이라고 합니다.
 * 예를 들어 3124는 숫자 1, 2, 3, 4로 만들 수 있는 순열 중 하나입니다.
 *
 * 이렇게 만들 수 있는 모든 순열을 숫자나 문자 순으로 늘어놓은 것을 사전식(lexicographic) 순서라고 합니다.
 * 0, 1, 2로 만들 수 있는 사전식 순열은 다음과 같습니다.
 *
 * 012   021   102   120   201   210
 * 0, 1, 2, 3, 4, 5, 6, 7, 8, 9로 만들 수 있는 사전식 순열에서 1,000,000번째는 무엇입니까?
 *
 */

public class Problem24 extends AbstractProblem {



	@Override
	public void solveProblem() {

		/*
		 * 숫자 배열 초기화
		 */
		List<Integer> list = new ArrayList<Integer>();
		for (int i=0; i<= 9; i++) {
			list.add(i);
		}

		StringBuilder sb = new StringBuilder();

		/*
		 * 구하려는 순서
		 */
		int orderNumber = 362881;

		int quotient = 0; // 몫
		int remainder = 0; // 나머지
		int divisor = 0; // 나눔수


		/*
		 * n : n번째 자리수
		 * orderNumber : 구하려는 순서
		 */
		/*
		 * n번째 자리수를 구하기 위해, n-1번째에 올수있는 경우의 수를 구한다.
		 * 구하려는 순서를 경우의 수로 나누고,
		 *
		 * 1) 나머지가 0보다 크면 : list의 n번째 수가 n번째 자리수. (list 는 index 가 0부터 시작하므로.)
		 * 2) 나머지가 0이면 : list의 n-1번째 자리수가 n번째 자리수.
		 */
		for (int n = 10; n >= 2 && orderNumber > 0; n--) {

			System.out.printf("%d번째 자리수 : ", n);


			/*
			 * STEP 1: n-1번째 경우의 수(factorial)을 구하고, 구하려는 순서로 경우의 수를 나눈다.
			 */
			divisor = (int) CommonMath.factorialInteger(n - 1);
			quotient = orderNumber / divisor;
			remainder = orderNumber - divisor * quotient;


			/*
			 * 1) 나머지가 0보다 크면 : list의 n번째 수가 n번째 자리수. (list 는 index 가 0부터 시작하므로.)
			 * 2) 나머지가 0이면 : list의 n-1번째 자리수가 n번째 자리수.
			 */
			if (remainder > 0) {
				sb.append(list.get(quotient));
				list.remove(quotient);
			} else {
				sb.append(list.get(quotient - 1));
				list.remove(quotient - 1);
			}


			System.out
					.printf("경우의수(%d! == %d) <= 구하려는순서(%d) -> 몫: %d, 나머지: %d , result값 : %s, 남은숫자리스트 : %s\n",
							n - 1, divisor, orderNumber, quotient, remainder,
							sb.toString(), list.toString());

			orderNumber = remainder;


		}


		/*
		 * 나머지(orderNumber)가 남아 있다면 : 남은 숫자는 순서대로 출력 (사전시 순서)
		 *
		 * 나머지가 남아 있지 않다면 : 남은 숫자는 역순 출력 (나머지가 없다는 것은 n-1번째 경우의 수에서 딱 떨어졌다는 것이므로
		 * 가장 후순위 값을 출력해야함)
		 */
		if (orderNumber == 0) {
			Collections.reverse(list);
		}
		for (Integer n : list) {
			sb.append(n.toString());
		}



		System.out.println("result : " + sb.toString());


	}

	public static void main(String[] args) {

		Problem24 problem = new Problem24();
		problem.solveProblemWithTimeMeasurement();

	}


}
