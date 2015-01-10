package xenomity.study.sort.strategy;

/**
 * Insertion Sorter
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 * @since 2014. 11. 24.
 *
 */
public class InsertionSorter implements Sortable {

	@Override
	public void sort(int[] array, int... args) {
		int arrayLength = array.length;
		int innerCounter;
		
		for (int i = 1; i < arrayLength; i++) {
			int tempMin = array[i];
			
			for (innerCounter = i; innerCounter > 0; innerCounter--) {
				if (array[innerCounter - 1] > tempMin) {
					array[innerCounter] = array[innerCounter - 1];
				} else {
					break;
				}
			}
			
			array[innerCounter] = tempMin;
		}
	}

}
