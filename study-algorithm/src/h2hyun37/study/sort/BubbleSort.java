package h2hyun37.study.sort;



/*
 * Bubble Sort
 *
 * 공통 추상 클래스인 AbstractSort 를 확장
 *
 */
public class BubbleSort extends AbstractSort {

	private int temp = 0;

	public BubbleSort(int dataSize, int randomNumLimit) {
		super(dataSize, randomNumLimit);
	}

	public BubbleSort(int[] dataArray) {
		super(dataArray);
	}

	/*
	 * BubbleSort 부분 구현
	 *
	 * - last Sorted Element 제외하고 그 앞 부분까지만 비교하여 정렬
	 *
	 * - element를 비교하여 swap이 발생시
	 * boolean 값을 true로 놓고, 이 값을 가지고 무한루프를 돌도록 한다
	 *
	 */
	@Override
	public void sort() {

		int lastSortedIndex = this.dataArray.length;

		boolean isSwapped = false;

		do {

			isSwapped = false;

			for (int i = 0; i < lastSortedIndex - 1; i++) {

				// swap data
				if (dataArray[i] > dataArray[i + 1]) {
					temp = dataArray[i + 1];
					dataArray[i + 1] = dataArray[i];
					dataArray[i] = temp;
					isSwapped = true;
				}

			}
			// loop 1회 실행시마다 1개씩 정렬되므로, 루프도는 횟수를 줄이기 위해 index--
			lastSortedIndex--;

		} while (isSwapped);

	}

	public static void main(String[] args) {

		BubbleSort bubbleSort = new BubbleSort(100000, 10000000);

		String unsortedData = bubbleSort.toString();
		System.out.println(unsortedData);

		bubbleSort.startTimeCheck();
		bubbleSort.sort();
		bubbleSort.stopTimeCheck();

		String sortedData = bubbleSort.toString();
		System.out.println(sortedData);

		String timeResult = bubbleSort.getElapsedTimeMillis();
		System.out.println(timeResult);

	}

}
