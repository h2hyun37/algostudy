package xenomity.euler;

/**
 * Problem Interface
 * 
 * <pre>
 * generic T defined output data type.
 * </pre>
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 *
 */
public interface IProblem<T> {
	
	/**
	 * Problem
	 */
	void problem();
	
	/**
	 * Get Result
	 * 
	 * @return output value
	 */
	T getResult();

}
