package h2hyun37.study;

public class InsertionSortExam {

	public static void main(String[] args) {

		// sorted : 3,8,11,15,20,29,31,48,65,73
		// sorted : 3,3,8,11,15,20,29,31,31,48,65,73
		int[] array1 = { 3, 31, 48, 73, 8, 11, 20, 29, 65, 15 };
		int[] array2 = { 3, 31, 48, 73, 8, 11, 20, 31, 29, 65, 3, 15 };

		int[] sortedArray1 = InsertionSort(array1, true);
		int[] sortedArray2 = InsertionSort(array2, true);
		int[] sortedArray3 = InsertionSort(array1, false);
		int[] sortedArray4 = InsertionSort(array2, false);

		printArrayValue(array1);
		printArrayValue(array2);
		printArrayValue(sortedArray1);
		printArrayValue(sortedArray2);
		printArrayValue(sortedArray3);
		printArrayValue(sortedArray4);

	}


	/*
	 * InsertionSort : int[] 배열을 받아서 삽입정렬 수행
	 * 
	 * 	- int[] array : 정렬할 배열
	 * 	- boolean isAscending : true 면 오름차순 정렬 , false 면 내림차순 정렬 
	 * 
	 * return : 
	 * 	int[] : 정렬된 배열 
	 */
	public static int[] InsertionSort(int[] array, boolean isAscending) {

		int[] sortedArray = new int[array.length];

		sortedArray[0] = array[0];

		for (int i = 1; i < array.length; i++) {

			int data = array[i];


			// 오름차순으로 정렬할때에 insert할 위치를 찾는다
			int insertIndex = i;
			for (int j = 0; j < i; j++) {

				int difference = Integer.MIN_VALUE;

				// 오름차순 : "이미 정렬된 값 > 정렬할 값" 인 경우 insert
				// 내림차순 : "이미 정렬된 값 < 정렬할 값" 인 경우 insert
				if (isAscending == true) { 
					difference = sortedArray[j] - data;
				} else {
					difference = data - sortedArray[j];
				}
				
				if (difference >= 0) {
					insertIndex = j;
					break;
				}
			}


			// 정렬할 데이터를 넣기 위해, 이미 정렬된 배열을 뒤로 한칸씩 이동
			for (int k = i; k > insertIndex; k--) {
				sortedArray[k] = sortedArray[k - 1];
			}
			sortedArray[insertIndex] = data;
		}

		return sortedArray;

	}

	/*
	 * 배열값을 stdout 으로 출력
	 */
	public static void printArrayValue(int[] array) {

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		for (int i = 0; i < array.length; i++) {
			sb.append(array[i]);
			if (i < array.length - 1) {
				sb.append(",");
			}
		}

		sb.append("}");

		System.out.println(sb);
	}

}
