package arrays;

public class Sort012 {

	public static void sort(int arr[]) {

		int zIdx = 0, oIdx = 0, tIdx = arr.length - 1;
		int tmp;

		while (zIdx <= oIdx && oIdx <= tIdx) {

			switch (arr[oIdx]) {

			case 0:
				tmp = arr[zIdx];
				arr[zIdx++] = arr[oIdx];
				arr[oIdx++] = tmp;
				break;

			case 1:
				oIdx++;
				break;

			case 2:
				tmp = arr[tIdx];
				arr[tIdx--] = arr[oIdx];
				arr[oIdx] = tmp;
				break;

			default:
				return;

			}
		}

		for (int ele : arr)
			System.out.print(ele + " ");
	}

	public static void main(String[] args) {

		int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
		int arr2[] = { 1, 2, 0, 2, 1, 0 };

		sort(arr);
		System.out.println();
		sort(arr2);
	}

}
