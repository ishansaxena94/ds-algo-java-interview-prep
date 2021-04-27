package arrays;

import java.util.Arrays;

public class ChocolateDistributionProblem {

	static int findMinDiff(int arr[], int n) {

		int diff = Integer.MAX_VALUE, minDiff = Integer.MAX_VALUE;

		Arrays.parallelSort(arr);

		for (int i = 0; i <= arr.length - n; i++) {

			diff = arr[i + n - 1] - arr[i];

			if (diff < minDiff)
				minDiff = diff;
		}

		return minDiff;
	}

	public static void main(String[] args) {

		int arr[] = { 12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50 };
		int m = 7; // Number of students

		System.out.println("Minimum difference is " + findMinDiff(arr, m));
	}

}
