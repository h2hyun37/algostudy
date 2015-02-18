package h2hyun37.study.sort;

/*
 * AbstractSort
 *
 * 	- 소트 연습문제 풀이를 위한 공통의 메소드를 제공하는 추상 클래스
 *
 *
 *
 */
public abstract class AbstractSort {


	// 데이터 배열
	int[] dataArray;

	// 데이터 배열에 랜덤 값 생성시 max limit
	int randomNumLimit = 1000000;

	// 시간 측정을 위한 변수
	long startTimeNano = -1;
	long startTimeMillis = -1;
	long stopTimeNano = -1;
	long stopTimeMillis = -1;


	/*
	 * dataSize 와 randomNumberLimit 지정하여 데이터 생성하는 경우 사용
	 */
	public AbstractSort(int dataSize, int randomNumLimit) {

		this.randomNumLimit = randomNumLimit;
		dataArray = new int[dataSize];
		this.randomizeDataArray();
	}

	/*
	 * 테스트 등을 위해서 배열을 직접 생성하는 경우에 사용
	 */
	public AbstractSort(int[] dataArray) {
		this.dataArray = dataArray;
	}


	/*
	 * 0 ~ randomNumLimit 사이의 임의의 랜덤 배열을 생성
	 */
	private void randomizeDataArray() {

		for (int idx = 0; idx < dataArray.length; idx++) {
			dataArray[idx] = (int) (Math.random() * randomNumLimit);
		}

	}


	@Override
	public String toString() {

		StringBuffer sb = new StringBuffer();

		for (int idx = 0; idx < dataArray.length; idx++) {

			if (idx == 0) {
				sb.append("[");
			}

			sb.append(dataArray[idx]);


			if (idx >= 0 && idx < dataArray.length - 1) {
				sb.append(", ");
			}

			if (idx == dataArray.length - 1) {
				sb.append("]");
			}

		}

		return sb.toString();

	}


	/*
	 * 시간 측정 시작
	 */
	public void startTimeCheck() {
		this.startTimeMillis = System.currentTimeMillis();
		this.startTimeNano = System.nanoTime();
	}

	/*
	 * 시간 측정 종료
	 */
	public void stopTimeCheck() {
		this.stopTimeMillis = System.currentTimeMillis();
		this.stopTimeNano = System.nanoTime();
	}

	/*
	 * 걸린 시간을 milli sec. 단위의 결과 스트링으로 리턴
	 */
	public String getElapsedTimeMillis() {

		return new String("Process Time : "
				+ (this.stopTimeMillis - this.startTimeMillis)
				+ " milli second(s)");
	}

	/*
	 * 걸린 시간을 nano sec. 단위의 결과 스트링으로 리턴
	 */
	public String getElapsedTimeNano() {

		return new String("Process Time : "
				+ (this.stopTimeNano - this.startTimeNano) + " nano second(s)");
	}

	/*
	 * 소트 메소드. 각 소트 알고리즘에 맞게 적절하게 overriding
	 */
	public abstract void sort();


}
