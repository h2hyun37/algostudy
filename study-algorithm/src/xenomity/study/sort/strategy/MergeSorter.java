package xenomity.study.sort.strategy;

/**
 * Merge Sorter
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 * @since 2014. 11. 24.
 *
 */
public class MergeSorter implements Sortable {

	@Override
	public void sort(int[] array, int... args) {
		int p = args[0];
		int r = args[1];
		
		if (p < r) {
			int q = (p + r) / 2;
			sort(array, p, q);
			sort(array, q + 1, r);
			merge(array, p, q, r);
		}
	}
	
	private void merge(int[] array, int p, int q, int r) {
		int i = p;
		int j = q + 1;
		int t = 0;
		int[] tmp = new int[r + 1];
		
		while (i <= q && j <= r) {
			if (array[i] <= array[j]) {
				tmp[t++] = array[i++];
			} else {
				tmp[t++] = array[j++];
			}
		}
		
		while (i <= q) {
			tmp[t++] = array[i++];
		}
		
		while (j <= r) {
			tmp[t++] = array[j++];
		}
		
		i = p;
		t = 0;
		while (i <= r) {
			array[i++] = tmp[t++];
		}
	}

}
