package xenomity.study.sort.strategy;

/**
 * Selection Sorter
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 * @since 2014. 11. 24.
 *
 */
public class SelectionSorter implements Sortable {

	@Override
	public void sort(int[] array, int... args) {
		int arrayLength = array.length;
		
		for (int i = arrayLength - 1; i > 0; i--) {
			int temp = 0;
			int tempIndex = 0;
			
			for (int j = 0; j <= i; j++) {
				if (array[j] > temp) {
					temp = array[j];
					tempIndex = j;
				}
			}
			
			array[tempIndex] = array[i];
			array[i] = temp;
		}
	}

}
