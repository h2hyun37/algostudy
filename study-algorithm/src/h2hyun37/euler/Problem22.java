package h2hyun37.euler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


/*
 * 여기 5천개 이상의 영문 이름들이 들어있는 46KB짜리 텍스트 파일 names.txt 이 있습니다 (우클릭해서 다운로드 받으세요).
 * 이제 각 이름에 대해서 아래와 같은 방법으로 점수를 매기고자 합니다.
 *
 * 먼저 모든 이름을 알파벳 순으로 정렬합니다.
 * 각 이름에 대해서, 그 이름을 이루는 알파벳에 해당하는 숫자(A=1, B=2, ..., Z=26)를 모두 더합니다.
 * 여기에 이 이름의 순번을 곱합니다.
 * 예를 들어 "COLIN"의 경우, 알파벳에 해당하는 숫자는 3, 15, 12, 9, 14이므로 합이 53,
 * 그리고 정렬했을 때 938번째에 오므로 최종 점수는 938 × 53 = 49714가 됩니다.
 *
 *
 * names.txt에 들어있는 모든 이름의 점수를 계산해서 더하면 얼마입니까?
 *
 *
 *
 */

public class Problem22 extends AbstractProblem {


	String[] inputData = null;


	/*
	 * 파일을 읽어서 데이터 배열에 저장
	 */
	private void readDataFile(String fileName) {

		String inputString;
		StringBuilder sb = new StringBuilder();


		FileReader fr = null;
		BufferedReader br = null;


		try {

			fr = new FileReader(fileName);
			br = new BufferedReader(fr);

			while ((inputString = br.readLine()) != null) {
				sb.append(inputString);
			}

			inputData = sb.toString().replaceAll("\"", "").split(",");

		} catch (IOException e) {
			e.printStackTrace();

		} finally {

			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
				}
			}

			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
				}
			}

		}


	}

	@Override
	public void solveProblem() {

		int nameScoreTemp;
		int lineIndex = 0;
		long cumulativeScore = 0L; // 이름을 점수로 계산한 누적값

		/*
		 * STEP 1 : 이름 파일을 읽어서 배열에 저장
		 * names.txt 위치 : /Users/1001065/dev/workspace/algostudy (프로젝트 최상단)
		 */
		readDataFile("names.txt");


		/*
		 * STEP 2 : 정렬 후 이름에 대한 누적값을 계산
		 */
		Arrays.sort(inputData);

		for (String name : inputData) {

			lineIndex++;
			nameScoreTemp = 0;

			// A=1, B=2 ... Z=26 으로 이름의 스코어 계산
			for (byte c : name.getBytes()) {
				nameScoreTemp += c - 64;
			}

			cumulativeScore += (nameScoreTemp * lineIndex);

		}

		System.out.println(cumulativeScore);

	}

	public static void main(String[] args) {

		Problem22 problem = new Problem22();
		problem.solveProblemWithTimeMeasurement();

	}

}
