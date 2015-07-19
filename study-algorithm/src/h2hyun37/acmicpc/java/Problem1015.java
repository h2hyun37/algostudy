package h2hyun37.acmicpc.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 문제
 * P[0], P[1], ...., P[N-1]은 0부터 N-1까지(포함)의 수를 한 번씩 포함하고 있는 수열이다.
 * 수열 P를 길이가 N인 배열 A에 적용하면 길이가 N인 배열 B가 된다. 적용하는 방법은 B[P[i]] = A[i]이다.
 *
 * 배열 A가 주어졌을 때, 수열 P를 적용한 결과가 비내림차순이 되는 수열을 찾는 프로그램을 작성하시오.
 * 비내림차순이란, 각각의 원소가 바로 앞에 있는 원소보다 크거나 같을 경우를 말한다.
 * 만약 그러한 수열이 여러개라면 사전순으로 앞서는 것을 출력한다.
 *
 * 입력
 * 첫째 줄에 배열 A의 크기 N이 주어진다.
 * 둘째 줄에는 배열 A의 원소가 0번부터 차례대로 주어진다.
 * N은 50보다 작거나 같은 자연수이고, 배열의 원소는 1,000보다 작거나 같은 자연수이다.
 *
 * 출력
 * 첫째 줄에 배열 A를 비내림차순으로 만드는 수열 P를 출력한다.
 *
 */

public class Problem1015 {

	public static int N = 50;

	int[] arrA;

	HashMap<Integer, Integer> reverseMapB;
	HashMap<Integer, Integer> mapP;

	public void ascendSort(int[] arrA, HashMap<Integer, Integer> reverseMapP, HashMap<Integer, Integer> reverseMapB) {

		HashMap<Integer, Integer> returnMap = new HashMap<>();

		for (int idx = 0; idx < arrA.length; idx++) {

			// P[i] 값을 세팅. 단 value를 알 수 없으므로 tempKey 로 지정하고, idx 값을 value로.
			int tempKey = (int) (Math.random() * 1000000);
			reverseMapP.put(tempKey, idx);

			// B[P[i]] = A[i] 관계에서 P[i]를 알 수 없으므로 reverse해서 일단 value에 넣는다
			reverseMapB.put(arrA[idx], tempKey);

			System.out.printf("arrA[%s] : %s --> reverseMapP.get(%s) : %s\n", idx, arrA[idx], tempKey,
					reverseMapP.get(tempKey));
		}

		// 배열 B 의 index들을 sort
		List<Integer> indexOfB = new ArrayList<Integer>(reverseMapB.keySet());
		Collections.sort(indexOfB);

		for (int i = 0; i < indexOfB.size(); i++) {

			int tempKey = reverseMapB.get(indexOfB.get(i));

			int idx = reverseMapP.get(tempKey);

			returnMap.put(idx, i);

		}

		List<Integer> indexOfP = new ArrayList<Integer>(returnMap.keySet());
		Collections.sort(indexOfP);

		for (int i = 0; i < indexOfP.size(); i++) {

			System.out.printf("P[%s] --> %s\n", i, returnMap.get(i));
		}


	}

	public static void main(String[] args) {

		Problem1015 p15 = new Problem1015();

		p15.reverseMapB = new HashMap<Integer, Integer>();
		p15.mapP = new HashMap<Integer, Integer>();


		/* test data1 --> result : 1 2 0 */
		int maxSize = 3;
		p15.arrA = new int[maxSize];

		p15.arrA[0] = 2;
		p15.arrA[1] = 3;
		p15.arrA[2] = 1;
		p15.ascendSort(p15.arrA, p15.mapP, p15.reverseMapB);

		/* test data2 --> result : 4 2 3 0 1 */
		maxSize = 5;
		p15.arrA = new int[maxSize];

		p15.arrA[0] = 5;
		p15.arrA[1] = 3;
		p15.arrA[2] = 4;
		p15.arrA[3] = 1;
		p15.arrA[4] = 2;
		p15.ascendSort(p15.arrA, p15.mapP, p15.reverseMapB);


	}
}
