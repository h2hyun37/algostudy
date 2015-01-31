package xenomity.examination.sort;


/**
 * Quick Sort
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 * @since 2015. 1. 31.
 *
 */
public class QuickSort implements Sortable {

	@Override
	public void sort(int[] array, int... args) {
		// definition
		int startIndex = (args != null && args.length == 2) ? args[0] : 0;
		int endIndex = (args != null && args.length == 2) ? args[1] : array.length - 1;
		
		if (startIndex < endIndex) {
			// #1. pivot selection
			int pivot = partition(array, startIndex, endIndex);
			
			// #2. recursive sort
			sort(array, startIndex, pivot - 1);
			sort(array, pivot + 1, endIndex);
		}
	}
	
	private int partition(int[] array, int startIndex, int endIndex) {
		int criteriaValue = array[endIndex];
		int pivotIndex = startIndex;
		
		// 순회하면서 피봇 값보다 작은 위치가 나올 경우마다 피봇 인덱스를 증가시키며 현재 원소와 피봇 위치 원소 교환.
		for (int i = startIndex; i < endIndex; i++) {
			if (array[i] <= criteriaValue) {
				int temp = array[pivotIndex];
				array[pivotIndex] = array[i];
				array[i] = temp;
				
				pivotIndex++;
			}
		}
		
		// 최종적인 피봇 위치의 원소와 기준 원소를 교환.
		array[endIndex] = array[pivotIndex];
		array[pivotIndex] = criteriaValue;
		
		return pivotIndex;
	}
	
}
