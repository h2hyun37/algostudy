package xenomity.study.sort.strategy;

/**
 * Quick Sorter
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 * @since 2014. 11. 24.
 *
 */
public class QuickSorter implements Sortable {

	@Override
	public void sort(int[] array, int... args) {
		int p = args[0];
		int r = args[1];
		
		if (p < r) {
			int pivotIndex = partition(array, p, r);
			
			sort(array, p, pivotIndex - 1);
			sort(array, pivotIndex + 1, r);
		}
	}
	
	private int partition(int[] array, int p, int r) {
		int x = array[r];
		int i = p - 1;
		
		for (int j = p; j < r; j++) {
			if (array[j] <= x) {
				array[++i] = array[j];
			}
		}
		
		array[i + 1] = array[r];
		
		return i + 1;
	}

}
