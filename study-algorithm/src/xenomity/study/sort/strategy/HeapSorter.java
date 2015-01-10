package xenomity.study.sort.strategy;

/**
 * Heap Sorter
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 * @since 2014. 11. 25.
 *
 */
public class HeapSorter implements Sortable {

	@Override
	public void sort(int[] array, int... args) {
		buildHeap(array, array.length - 1);
		
		for (int i = array.length - 1; i > 1; i--) {
			array[0] = array[i];
			
			heapify(array, 0, i - 1);
		}
	}
	
	private void buildHeap(int[] array, int n) {
		for (int i = n / 2; i > 0; i--) {
			heapify(array, i, n);
		}
	}
	
	private void heapify(int[] array, int k, int n) {
		int left = 2 * k;
		int right = 2 * k + 1;
		int smaller;
		
		if (right <= n) {
			if (array[left] < array[right]) {
				smaller = left;
			} else {
				smaller = right;
			}
		} else if (left <= n) {
			smaller = left;
		} else {
			return;
		}
		
		if (array[smaller] < array[k]) {
			array[k] = array[smaller];
			
			heapify(array, smaller, n);
		}
	}

}
