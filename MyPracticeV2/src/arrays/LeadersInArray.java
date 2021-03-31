package arrays;

public class LeadersInArray {

	public static void findLeader(int arr[]) {

		int len = arr.length - 1;
		int curMax = arr[len];

		System.out.println(curMax);

		for (int i = len - 1; i >= 0; i--) {

			if (arr[i] > curMax) {
				System.out.println(arr[i]);
				curMax = arr[i];
			}
		}
	}

	public static void main(String[] args) {

		int arr[] = new int[] { 16, 17, 4, 3, 5, 2 };
		findLeader(arr);

	}

}
