package xenomity.study.sort.strategy;

/**
 * Bubble Sorter
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 * @since 2014. 11. 24.
 *
 */
public class BubbleSorter implements Sortable {

	@Override
	public void sort(int[] array, int... args) {
		int arrayLength = array.length;
		
		for (int i = arrayLength - 1; i > 0; i--) {
			boolean isSorted = true;
			
			for (int j = 0; j < i; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					
					isSorted = false;
				}
			}
			
			if (isSorted) {
				break;
			}
		}
	}

}
