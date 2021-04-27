package arrays;

public class KadanesAlgorithm {

	public static int maxSubArraySum(int arr[]) {

		int maxSum = 0, curSum = 0;

		for (int i = 0; i < arr.length; i++) {

			curSum += arr[i];

			if (curSum < 0)
				curSum = 0;

			if (maxSum < curSum)
				maxSum = curSum;
		}

		return maxSum;
	}

	public static void main(String[] args) {

		int[] a = { -2, -3, 4, -1, -2, 1, 5, -3 };
		System.out.println("Maximum contiguous sum is " + maxSubArraySum(a));
	}

}
