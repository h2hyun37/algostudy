package h2hyun37.study.sort;

public class BubbleSort {

	/*
	 * 버블 소트
	 *
	 */


	int[] data;

	public BubbleSort(int size) {

		data = new int[size];
		this.makeRandomArray();

	}

	public BubbleSort(int[] array) {

		data = array;

	}

	private void makeRandomArray() {

		/*
		 * 0 ~ 1000000 사이의 임의의 랜덤 배열을 생성
		 */
		for (int idx = 0; idx < data.length; idx++) {
			data[idx] = (int) (Math.random() * 1000000);
		}

	}


	public void printData() {

		StringBuffer sb = new StringBuffer();

		for (int idx = 0; idx < data.length; idx++) {

			if (idx == 0) {
				sb.append("[");
			}

			sb.append(data[idx]);


			if (idx >= 0 && idx < data.length - 1) {
				sb.append(",");
			}

			if (idx == data.length - 1) {
				sb.append("]");
			}

		}

		System.out.println(sb);
	}

	public void sort() {

		for (int i = 0; i < data.length - 1; i++) {
			for (int j = i + 1; j < data.length; j++) {

				if (data[i] > data[j]) {
					int temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}

			}
		}

	}

	public static void main(String[] args) {

		/*
		 * array init.
		 */
		BubbleSort bs = new BubbleSort(100000);
		bs.printData();


		/*
		 * bubble sort
		 */
		long startTime = System.nanoTime();

		long startTime2 = System.currentTimeMillis();

		bs.sort();

		long endTime = System.nanoTime();

		long endTime2 = System.currentTimeMillis();

		bs.printData();

		// display elapsed time
		System.out.println("Process Time: " + (endTime - startTime)
				* 1000.0 + " micro sec.");

		// display elapsed time
		System.out.println("Process Time: " + (endTime2 - startTime2)
				+ " milli sec.");

	}

}
