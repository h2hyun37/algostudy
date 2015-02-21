package xenomity.euler;

import xenomity.euler.problem.*;

/**
 * Problem Resolver
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 *
 */
public final class ProblemResolver {
	
	// The Constructor
	private ProblemResolver() {}

	/**
	 * Resolve
	 * 
	 * @param problemClass problem implements class
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static void resolve(Class<? extends AbstractProblem<?>> problemClass) throws InstantiationException, IllegalAccessException {
		((AbstractProblem<?>) problemClass.newInstance()).solve();
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		ProblemResolver.resolve(Problem18.class);
	}
	
}
