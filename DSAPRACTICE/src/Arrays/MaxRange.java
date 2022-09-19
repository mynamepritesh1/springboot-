package Arrays;

public class MaxRange {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		System.out.println(max(arr));

	}

	// work on edge class here,like array being null 
	static int maxRange(int[] arr, int start, int end) {
        //base condition
		if (start > end) {
			return -1;

		}
		// base condition
		if (arr == null) {
			return -1;

		}
		int maxVal = arr[start];
		//loop traverse between start to end
		for (int i = start; i <= end; i++) {
			//condition index is maxValue 
			if (arr[i] > maxVal) {
				maxVal = arr[i];

			}
		}
		return maxVal;

	}

	static int max(int[] arr) {
		if (arr.length == 0) {
			return -1;
		}

		int maxVal = arr[0];
		for (int i = 1; i < arr.length; i++)

		{
			if (arr[i] > maxVal) {
				maxVal = arr[i];
			}
		}
		return maxVal;

	}

}
