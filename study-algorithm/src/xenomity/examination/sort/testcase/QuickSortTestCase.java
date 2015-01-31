package xenomity.examination.sort.testcase;

import java.util.Arrays;

import org.junit.Test;

import xenomity.examination.sort.QuickSort;
import xenomity.examination.sort.Sortable;

public class QuickSortTestCase {
	
	private static final int[] INPUT_ARRAY = {5, 2, 6, 8, 1, 3, 4, 7, 9};
	private final Sortable sortable = new QuickSort();

	@Test
	public void test() {
		sortable.sort(INPUT_ARRAY);
		
		System.out.println(Arrays.toString(INPUT_ARRAY));
	}

}
