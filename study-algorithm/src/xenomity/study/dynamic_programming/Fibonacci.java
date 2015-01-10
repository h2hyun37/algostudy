package xenomity.study.dynamic_programming;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class Fibonacci {
	
	private static final Map<Integer, Integer> CACHE_TABLE = new ConcurrentHashMap<>();
	
	// The Constructor
	private Fibonacci() {}

	/**
	 * 재귀 호출의 중복을 제거(dynamic programming)한 피보나치수 계산 버전
	 * 
	 * @param n number
	 * @return result value
	 */
	public static int fibonacci(int n) {
		if (CACHE_TABLE.containsKey(n)) {
			return CACHE_TABLE.get(n);
		} else {
			if (n <= 2) {
				CACHE_TABLE.put(n, 1);
			} else {
				CACHE_TABLE.put(n, (fibonacci(n - 1) + fibonacci(n - 2)));
			}
			
			return CACHE_TABLE.get(n);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(Fibonacci.fibonacci(8));
	}
	
}
