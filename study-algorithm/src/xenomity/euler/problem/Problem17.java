package xenomity.euler.problem;

import xenomity.euler.AbstractProblem;

/**
 * Problem 17
 * 
 * <pre>
 * 1부터 5까지의 숫자를 영어로 쓰면 one, two, three, four, five 이고,
 * 각 단어의 길이를 더하면 3 + 3 + 5 + 4 + 4 = 19 이므로 사용된 글자는 모두 19개입니다.
 * 
 * 1부터 1,000까지 영어로 썼을 때는 모두 몇 개의 글자를 사용해야 할까요?
 * 
 * 참고: 빈 칸이나 하이픈('-')은 셈에서 제외하며, 단어 사이의 and 는 셈에 넣습니다.
 *      예를 들어 342를 영어로 쓰면 three hundred and forty-two 가 되어서 23 글자,
 *      115 = one hundred and fifteen 의 경우에는 20 글자가 됩니다.
 * </pre>
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 * @since 2015. 2. 11.
 *
 */
public class Problem17 extends AbstractProblem<Long> {
	
	private static final String[] WORD_POOL = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
	private static final String[] TENABLE_POOL = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
	private static final String[] TENUNIT_POOL = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	private static final String HUNDRED = "hundred";
	private static final String THOUSAND = "thousand";
	private static final String AND = "and";
	private long value;

	@Override
	public void problem() {
		for (int i = 1; i < 1000; i++) {
			StringBuffer buff = new StringBuffer();
			String number = String.valueOf(i);
			
			if (number.length() == 3) {
				buff.append(WORD_POOL[Integer.valueOf(String.valueOf(number.charAt(0))) - 1]);
				buff.append(HUNDRED);
				
				if (i % 100 != 0) {
					buff.append(AND);
				}
				
				number = number.substring(1);
			}
			
			if (number.length() == 2) {
				int lastNumber = Integer.valueOf(number);
				
				if (lastNumber >= 10 && lastNumber < 20) {
					buff.append(TENABLE_POOL[Integer.valueOf(String.valueOf(number.charAt(1)))]);
				} else if (lastNumber >= 20) {
					buff.append(TENUNIT_POOL[Integer.valueOf(String.valueOf(number.charAt(0))) - 2]);
					
					if (lastNumber % 10 != 0) {
						buff.append(WORD_POOL[Integer.valueOf(String.valueOf(number.charAt(1))) - 1]);
					}
				} else if (lastNumber > 0 && lastNumber < 10) {
					buff.append(WORD_POOL[Integer.valueOf(String.valueOf(number.charAt(1))) - 1]);
				}
			}
			
			if (i < 10) {
				buff.append(WORD_POOL[Integer.valueOf(String.valueOf(number.charAt(0))) - 1]);
			}

			value += buff.length();
		}
		
		value += WORD_POOL[0].length() + THOUSAND.length();
	}
	
	@Override
	public Long getResult() {
		return value;
	}

}