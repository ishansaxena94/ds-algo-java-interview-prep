package arrays;

public class SubarrayWithGivenSum {

	public static void subArraySum(int arr[], int sum) {

		int curSum = 0, start = 0, end = 0;

		while (end < arr.length) {

			if (curSum > sum) {
				while (curSum > sum && start < end)
					curSum -= arr[start++];
			}

			if (curSum == sum) {
				System.out.println("Sum found between indexes " + start + " and " + (end - 1));
				return;
			}

			curSum += arr[end++];
		}

	}

	public static void main(String[] args) {

		int arr[] = { 15, 2, 4, 8, 9, 5, 10, 23 };
		int sum = 23;
		subArraySum(arr, sum);
	}

}
