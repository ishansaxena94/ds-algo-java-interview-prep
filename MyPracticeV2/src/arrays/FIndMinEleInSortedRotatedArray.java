package arrays;

public class FIndMinEleInSortedRotatedArray {

	public static int findMin(int arr[]) {

		if (arr.length == 1)
			return arr[0];

		int low = 0, high = arr.length - 1;
		int mid = (high + low) / 2;

		while (low < high) {

			if (arr[mid] > arr[mid + 1])
				return arr[mid + 1];

			if (mid != 0 && arr[mid] < arr[mid - 1])
				return arr[mid];

			if (arr[mid] < arr[high])
				high = mid;
			else
				low = mid;

			mid = (low + high) / 2;
		}

		return arr[0];
	}

	public static void main(String[] args) {
		int arr1[] = { 5, 6, 1, 2, 3, 4 };
		System.out.println("The minimum element is " + findMin(arr1));

		int arr2[] = { 1, 2, 3, 4 };
		System.out.println("The minimum element is " + findMin(arr2));

		int arr3[] = { 1 };
		System.out.println("The minimum element is " + findMin(arr3));

		int arr4[] = { 1, 2 };
		System.out.println("The minimum element is " + findMin(arr4));

		int arr5[] = { 2, 1 };
		System.out.println("The minimum element is " + findMin(arr5));

		int arr6[] = { 5, 6, 7, 1, 2, 3, 4 };
		System.out.println("The minimum element is " + findMin(arr6));

		int arr7[] = { 1, 2, 3, 4, 5, 6, 7 };
		System.out.println("The minimum element is " + findMin(arr7));

		int arr8[] = { 2, 3, 4, 5, 6, 7, 8, 1 };
		System.out.println("The minimum element is " + findMin(arr8));

		int arr9[] = { 3, 4, 5, 1, 2 };
		System.out.println("The minimum element is " + findMin(arr9));

		int arr10[] = { 8, 1, 2, 3, 4, 5, 6, 7 };
		System.out.println("The minimum element is " + findMin(arr10));
	}

}
