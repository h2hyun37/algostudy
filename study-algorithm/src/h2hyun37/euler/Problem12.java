package h2hyun37.euler;

import java.util.HashMap;
import java.util.TreeMap;

public class Problem12 {
	

	/* 
	 * 루프 횟수를 줄일 수 있는 방법
	 * 1. 루프 돌 때에 소수가 아닌 수는 패스
	 *     -> 처음에 충분한 만큼의 소수 list 를 가지고 있어야 함 
	 * 2. 2와 홀수만 가지고 루프를 돈다
	 * 3. 이전 인수분해 결과를 별도로 가지고 있으면서, 인수분해시 비교 
	 * 
	 * 실제로 적용한 것은 2번만... 귀찮다 ... 
	 */

	// 인수분해한 밑수(?)와 인수를 저장할 map 생성
	// key : 밑수 , value : 인수
	private TreeMap<Integer, Integer> treemap = new TreeMap<Integer, Integer>();

	// 소수리스트를 저장할 map 생성
	private static HashMap<Integer, Integer> primeNumbers = new HashMap<Integer, Integer>(
			100);

	/*
	 * 정수를 받아, 해당 정수의 약수 갯수를 받는다
	 * 
	 * 소인수분해 공식 : a^m * b^n 이고 약수의 갯수는 (m+1)(n+1)
	 */
	public int getSubmultipleCount(long num) {
		
		// 인수분해한 결과를 저장할 map 초기화
		treemap.clear();

		/*
		 * 2부터 인수분해를 하되, 2와 홀수만 시도한다
		 */
		for (int i = 2; i <= num; i++) {

			// 2보다 큰 짝수는 skip 한다
			if (i % 2 == 0 && i > 2) {
				continue;
			}

			if (num % i == 0) {

				int square = treemap.getOrDefault(i, 0);
				square++;
				treemap.put(i, square);
				
				num /= i;
				i = 1; // 처음부터 다시 인수분해를 해야하므로 i=1 로 세팅한다 
			}

		}
		
		/*
		 * 약수의 각 인수+1 한 값들을 곱하여 리턴
		 * 
		 * (a^m)(b^n) -> (m+1)(n+1) 을 구한다
		 */
		int countOfSubmultiple = 1;
		for (Integer value : treemap.values()) { 
			countOfSubmultiple *= (value+1);
		}
		
		return countOfSubmultiple;
	}



	public static void main(String[] args) {

		Problem12 p12 = new Problem12();

		long triangularNumber = 0;



		long totalTimeStart = System.currentTimeMillis();

		for (int i = 1; i <= 1000000; i++) {

			triangularNumber += i;

			long methodTimeStart = System.currentTimeMillis();

			int submultipleCount = p12.getSubmultipleCount(triangularNumber);

			long methodTimeFinish = System.currentTimeMillis();


			// System.out.println("i : " + i + ", " + "triangularNumber : "
			// + triangularNumber + ", "
			// + "count : " + submultipleCount + ", "
			// + "time : " + (methodTimeFinish - methodTimeStart) / 1000.0);

			if (submultipleCount > 500) {
				System.out.println(triangularNumber);
				break;
			}


		}

		long totalTimeFinish = System.currentTimeMillis();

		System.out.println("전체 실행 시간 : " + (totalTimeFinish - totalTimeStart) / 1000.0);

	}


}
