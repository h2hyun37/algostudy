package h2hyun37.euler;

public abstract class AbstractProblem {

	abstract public void solveProblem();


	public void solveProblemWithTimeMeasurement() {

		long startTime = System.currentTimeMillis();

		this.solveProblem();

		// display elapsed time
		System.out.println("Process Time: "
				+ (System.currentTimeMillis() - startTime) + "milli sec.");


	}

}
