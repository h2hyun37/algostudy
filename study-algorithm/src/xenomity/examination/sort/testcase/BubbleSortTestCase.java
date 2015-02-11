package xenomity.examination.sort.testcase;

import java.util.Arrays;

import org.junit.Test;

import xenomity.examination.sort.BubbleSort;
import xenomity.examination.sort.Sortable;

public class BubbleSortTestCase {
	
	private static final int[] INPUT_ARRAY = {5, 2, 6, 8, 1, 3, 4, 7, 9};
	private final Sortable sortable = new BubbleSort();

	@Test
	public void test() {
		sortable.sort(INPUT_ARRAY);
		
		System.out.println(Arrays.toString(INPUT_ARRAY));
	}

}
