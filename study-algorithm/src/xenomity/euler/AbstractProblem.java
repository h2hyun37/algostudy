package xenomity.euler;

/**
 * Abstract Problem
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 *
 */
public abstract class AbstractProblem<T> implements IProblem<T> {

	/**
	 * Solve Problem
	 */
	public void solve() {
		long startTime = System.currentTimeMillis();
		
		problem();
		
		// display logs
		System.out.println("Result: " + getResult());
		System.out.println("Process Time: " + (System.currentTimeMillis() - startTime) + " ms.");
	}
	
}
