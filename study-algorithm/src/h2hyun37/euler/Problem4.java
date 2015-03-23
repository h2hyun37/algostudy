package h2hyun37.euler;




/*
 * 앞에서부터 읽을 때나 뒤에서부터 읽을 때나 모양이 같은 수를 대칭수(palindrome)라고 부릅니다.
 *
 * 두 자리 수를 곱해 만들 수 있는 대칭수 중 가장 큰 수는 9009 (= 91 × 99) 입니다.
 *
 * 세 자리 수를 곱해 만들 수 있는 가장 큰 대칭수는 얼마입니까?
 *
 */

public class Problem4 extends AbstractProblem {

	long beginNum = 1000000;
	long endNum = 9999999;


	/*
	 * 튜닝 포인트

	 * 1) a*b = b*a 이므로 b*a 는 제외. 2번째 for문의 시작값을 매번 줄여서 시작. -> ok 효과있음
	 * 2) 끝자리 0 인것 skip -> ok 효과있음 (% 연산자 적용 : fail , 별도 변수를 체크해서 skip)
	 * 3) 끝자리가 2&5, 4&5, 6&5, 8&5 제외 (순서 반대로 한 것도 제외) -> fail 일것 같음 (나눗셈 연산자...)
	 * 4) 대칭수 판별 메소드를 튜닝한다. string 객체 생성 등은 너무 느릴 것 같음
	 */

	/*
	 * 대칭수인지 여부 판별하는 메소드
	 */
	public boolean isPalindrome2(long number) {

		char[] cArr = Long.toString(number).toCharArray();

		int idx = cArr.length;

		/*
		 * 숫자 갯수가 홀수개/짝수개인 것에 따라,
		 * 비교를 하는 index 값을 다르게 설정
		 * (idx 는 0부터 시작하므로 +1한 값으로 홀짝 판단)
		 */
		int endIdx;
		if ((idx + 1) % 2 == 0) {
			endIdx = idx / 2;
		} else {
			endIdx = (idx / 2) - 1;
		}

		for (int forwardIdx = 0, backwardIdx = idx - 1; forwardIdx <= endIdx; forwardIdx++, backwardIdx--) {

			if (cArr[forwardIdx] != cArr[backwardIdx]) {
				return false;
			}
		}

		return true;
	}


	@Override
	public void solveProblem() {

		long palindrome = 0; // 가장 큰 대칭수

		int methodCallCount = 0; // 대칭수 비교 메소드 호출횟수

		int digit = 9; // 첫번째 숫자의 첫번째 자리. 첫번째 자리가 0 일때는 skip하도록 한다.


		for (long num1 = endNum; num1 >= beginNum; num1--) {

			for (long num2 = num1; num2 >= beginNum; num2--) {

				long thisNum = num1 * num2;

				/*
				 * for debugging : 이 구문을 활성화 시키면 아래 if~else 문은 주석처리해야함
				 * 
				 * if (isPalindrome2(thisNum)) {
				 * System.out.printf("%d * %d == %d\n", num1, num2, thisNum);
				 * 
				 * if (thisNum > palindrome) { palindrome = thisNum; } }
				 */

				if (thisNum > palindrome) {

					methodCallCount++;
					boolean b2;

					b2 = isPalindrome2(thisNum);

					if (b2)
						palindrome = thisNum;

				} else {
					break;
				}

			}

			/*
			 * 첫번째 자리수 계산. 만약 첫번째 자리수가 0이면 계산을 skip하고 9로 넘긴다.
			 */
			digit--;
			if (digit == 0) {
				num1--;
				digit = 9;
			}
		}

		System.out.println("method call count : " + methodCallCount);
		System.out.println("palindrome : " + palindrome);

	}

	public static void main(String[] args) {

		Problem4 problem = new Problem4();
		problem.solveProblemWithTimeMeasurement();

	}


}
