package h2hyun37.euler;

import java.util.ArrayList;
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



	public void solveProblem2() {

		int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		List<Integer> list = new ArrayList<Integer>(1000000);

		int count = 0;


	}

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
		 * 구하려는 순서 번호
		 */
		int orderNumber = 1000000;

		int quotient = 0; // 몫
		int remainder = 0; // 나머지
		int divisor = 0; // 나눔수


		for (int i = 10; i >= 2 && orderNumber > 0; i--) {

			divisor = (int) CommonMath.factorialInteger(i);

			if (divisor > orderNumber) {
				System.out.printf(
"divisor %d > orderNumber %d -> get first number of remaining numbers %d\n",
						divisor, orderNumber, list.get(0));
				sb.append(list.get(0));
				list.remove(list.get(0));
				continue;
			}

			System.out.println(i);

			/*
			 * 몫 quotient , 나머지 orderNumber
			 */
			quotient = orderNumber / divisor;
			remainder = orderNumber - divisor * quotient;

			if (quotient >= list.size()) {
				sb.append(list.get(0));
				list.remove(0);
			} else {
				sb.append(list.get(quotient));
				list.remove(quotient);
			}

			System.out
					.printf("orderNumber : %d, divisor : %d (%d!),  몫: %d, 나머지: %d , sb : %s, list : %s\n",
							orderNumber, divisor, i, quotient, remainder,
							sb.toString(),
							list.toString());

			orderNumber = remainder;
		}

		for (Integer i : list) {
			sb.append(i.toString());
		}

		System.out.println(sb.toString());

		// /*
		// * STEP 1 : 맨 처음 자리수를 뺀 나머지 9자리로 만들 수 있는 순열의 갯수를 구한다 (factorial 9 =
		// 362,880)
		// */
		// divisor = (int) CommonMath.factorialInteger(9);
		//
		// quotient = orderNumber / divisor;
		// orderNumber = orderNumber - divisor * quotient;
		//
		// sb.append(list.get(quotient - 1));
		// list.remove(quotient - 1);
		//
		// System.out.println(sb.toString());
		//
		//
		// // 8! = 40,320
		// divisor = (int) CommonMath.factorialInteger(8);
		//
		// quotient = orderNumber / divisor;
		// orderNumber = orderNumber - divisor * quotient;
		//
		// sb.append(list.get(quotient - 1));
		// list.remove(quotient - 1);
		//
		// System.out.println(sb.toString());
		//
		// // /*
		// // * STEP 2: 맨 처음 자리수가 0->1->2로 증가할 때에 가능한 순열의 갯수를 구하고, 구하려는 순서번호가
		// 어디에
		// // 속하는지 계산한다
		// // */
		// // for (int mul = 1; mul <= 10; mul++) {
		// // if (factorial9 * mul > orderNumber) {
		// // System.out.println(numberArr[mul - 2]);
		// // break;
		// // }
		// // }


	}

	public static void main(String[] args) {

		Problem24 problem = new Problem24();
		problem.solveProblemWithTimeMeasurement();

	}


}
