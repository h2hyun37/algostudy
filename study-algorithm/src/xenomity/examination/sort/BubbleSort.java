package xenomity.examination.sort;

public class BubbleSort implements Sortable {

	@Override
	public void sort(int[] array, int... args) {
		for (int i = 0; i < array.length - 2; i++) {
			for (int j = i + 1; j < array.length - 1; j++) {
				if (array[i] > array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
	}

}
