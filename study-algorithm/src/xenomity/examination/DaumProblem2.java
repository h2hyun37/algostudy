package xenomity.examination;

/**
 * “1”,”2”,”?”의 조합으로 이루어진 문자열을 입력받아 주어진 판단 조건에 따라 {right word, wrong word,
 * unknown word} 여부를 출력하는 프로그램을 작성하시오
 * ￼가정
 * ￼￼￼￼1. 문자열은 1,2,? 로만 구성된다. 이외의 문자는 오지 않는다 (오류처리 필요 없음) 2. 1은자음,2는모음,?는자음/모음여부를판단할수없는문자이다
 * 3. 편의상 문자의 길이는 10을 넘지 않는다고 가정한다. (오류처리 필요 없음)
 * ￼￼단어 판단 조건
 * ￼￼￼￼1. 자음과 모음이 각각 연속해서 2번 이상 나오면 “wrong word” 이다
 * 2. 그 외의 경우는 “right word”이다.
 * 3. ?는자음도될수있고모음도될수있으므로아래해설을참고
 * ￼￼입력 형식 예 (반드시 변수로 Hard coding 하시오. 표준 입력 받으면 오답 처리)
 * ￼￼￼￼불필요하게 입력 처리하지 마시오.
 * 변수로 선언해서 프로그래밍 하면 아래 값을 변경 후 컴파일 & 테스트 할 것임.
 * Ex) Java의 경우 아래 선언 처럼 변수로 처리할 것.
 * String inputs[] = {“11”, “22”, “12”, “1?2”, “??1”, “1??1”, “1???1”, “1???2”};
 * ￼￼해설
 * ￼￼￼￼“?” : ?가 자음인 경우 “right word”, 모음인 경우 역시 “right word”이므로 “right word”
 * “22” : 모음이 연속해서 두 번 나왔으므로 “wrong word”
 * “12” : 단어 판단 조건에 따라 “right word”이다
 * “1?2” : ?자리에 모음이 오든 자음이 오든 연속해서 모음 혹은 자음이 두 번 오기 때문에 “wrong word”
 * “??1” : 첫 번째 ?가 자음이 되고 두 번째 ?가 모음이 되는 경우는 right word이지만 그 외의 경우도 존재하므로 판 단할 수 없다. 따라서 “unknown word”
 * 이하 케이스 생략
 * ￼(위 inputs 값에 대한)
 * ￼출력 형식
 * ￼￼￼￼? : right word
 * 22 : wrong word
 * 12 : right word
 * 1?2 : wrong word
 * ??1 : unknown word 
 * 1??1 : wrong word 
 * 1???1 : unknown word 
 * 1???2 : wrong word
 *
 */
public final class DaumProblem2 {
	
	public static final String[] INPUT_DATA = {"?", "22", "12", "1?2", "??1", "1??1", "1??2", "1???1", "1???2"};
	
	enum WORD_CASE {
		RIGHT_WORD, WRONG_WORD, UNKNOWN_WORD
	}
	
	private static final String[] WRONG_WORD_CASE = {"11", "22", "1?2", "1??1", "1???2"};
	private static final String[] UNKNOWN_WORD_CASE = {"??1", "1??2"};
	
	private DaumProblem2() {}
	
	public static void validate(String[] inputData) {
		for (String currentWord : inputData) {
			WORD_CASE result = WORD_CASE.RIGHT_WORD;
			
			// validate wrong word
			for (String wrongPattern : WRONG_WORD_CASE) {
				if (currentWord.contains(wrongPattern)) {
					result = WORD_CASE.WRONG_WORD;
					
					break;
				}
			}
			
			// validate unknown word
			if (result == WORD_CASE.RIGHT_WORD) {
				for (String wrongPattern : UNKNOWN_WORD_CASE) {
					if (currentWord.contains(wrongPattern)) {
						result = WORD_CASE.UNKNOWN_WORD;
						
						break;
					}
				}
			}
			
			System.out.println("Current Word: " + currentWord + " [" + result + "]");
		}
	}
	
	public static void main(String[] args) {
		DaumProblem2.validate(INPUT_DATA);
	}

}
