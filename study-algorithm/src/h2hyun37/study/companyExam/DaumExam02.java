package h2hyun37.study.companyExam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DaumExam02 {

	String inputs[] = { "?", "11", "22", "12", "1?2", "??1", "1??1", "1???1",
			"1???2" };

	/*
	 * "?" 가 들어간 스트링을 "1","2" 각각의 케이스로 나눠서 큐에 저장
	 */
	public Queue<String> extract(String input) {

		Queue<String> queue = new LinkedList<String>();
		Queue<String> nextQueue = new LinkedList<String>();

		for (char c : input.toCharArray()) {

			String s = Character.toString(c);
			String element = null;

			if (queue.isEmpty()) {

				if (c == '?') {
					nextQueue.add("1");
					nextQueue.add("2");
				} else {
					nextQueue.add(s);
				}

			} else {

				while ((element = queue.poll()) != null) {

					if (c == '?') {
						nextQueue.add(element + "1");
						nextQueue.add(element + "2");
					} else {
						nextQueue.add(element + s);
					}
				}
			}

			/* Queue Copy : nextQueue -> queue */
			element = null;
			while ((element = nextQueue.poll()) != null) {
				queue.add(element);
			}
		}

		return queue;
	}

	/*
	 * String 1개를 받아 이것이 right word 인지 wrong word 인지 확인
	 *
	 * 리턴
	 * 	- true : right word
	 *  - false : wrong word
	 */
	public boolean estimate(String input) {

		char prevChar = 0;
		boolean judge = true;

		for (int idx = 0 ;idx < input.length(); idx++) {
			char c = input.charAt(idx);

			if (idx == 0) {
				prevChar = c;

			} else {

				if (prevChar == c) {
					judge = false;
					break;
				} else {
					prevChar = c;
				}

			}

		}
		return judge;

	}

	public void solveProblem() {

		for (String input : inputs) {

			System.out.println("\ninput : " + input);

			/*
			 * STEP 1 : ? -> 1 또는 2 로 extract 하여 큐에 저장
			 */
			Queue<String> queue = extract(input);
			List<Boolean> list = new ArrayList<Boolean>(queue.size());


			/*
			 * STEP 2 : extract 한 모든 String을 판단
			 */
			int idx = 0;
			int rightCount = 0;
			int wrongCount = 0;
			Iterator<String> iter = queue.iterator();
			while (iter.hasNext()) {

				String element = iter.next();
				boolean judge = estimate(element);
				list.add(idx, judge);

				if (judge == true) {
					rightCount++;
				} else {
					wrongCount++;
				}

				// for debugging
				System.out.print(element + ":" + list.get(idx) + "\t");

				idx++;
			}
			System.out.print("\n");


			/*
			 * STEP 3 : 모든 판단 결과를 바탕으로 right / wrong / unknown 판단
			 */
			System.out.print("input : " + input);
			if (rightCount > 0 && wrongCount > 0) {
				System.out.println(" --> unknown word");
			} else if (rightCount > 0) {
				System.out.println(" --> right word");
			} else if (wrongCount > 0) {
				System.out.println(" --> wrong word");
			}

		}

	}


	public static void main(String[] args) {

		DaumExam02 exam = new DaumExam02();
		exam.solveProblem();

	}

}
