package xenomity.study.sort;

import java.util.Arrays;

import xenomity.study.sort.strategy.QuickSorter;
import xenomity.study.sort.strategy.Sortable;

/**
 * Sort Test
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 * @since 2014. 11. 24
 *
 */
public final class SortTest {
	
	private static final int[] SRC = new int[] { 3, 10, 1, 2, 7, 9, 5, 3, 8, 6, 4 };

	// The Constructor
	private SortTest() {}
	
	/**
	 * Sort
	 * 
	 * @param src data list
	 * @param sorting strategy
	 * @param args arguments
	 */
	public static void sort(final int[] src, Sortable sortStrategy, int... args) {
		sortStrategy.sort(src, args);
	}
	
	public static void main(String[] args) {
		//SortTest.sort(SRC, new HeapSorter());
		//SortTest.sort(SRC, new MergeSorter(), 0, SRC.length - 1);
		SortTest.sort(SRC, new QuickSorter(), 0, SRC.length - 1);
		//SortTest.sort(SRC, new InsertionSorter());
		//SortTest.sort(SRC, new BubbleSorter());
		//SortTest.sort(SRC, new SelectionSorter());
		
		System.out.println(Arrays.toString(SRC));
	}
	
}
