package arrays;

import java.util.Arrays;

public class MinimumPlatforms {

	// arr: arrival
	static int findNumOfPlatform(int arr[], int dep[]) {

		int count = 0, maxCount = 0;

		// Sort arrival and departure arrays
		Arrays.sort(arr);
		Arrays.parallelSort(dep);

		int i = 0, j = 0;
		while (i < arr.length && j < dep.length) {

			while (i < arr.length && arr[i] <= dep[j]) {
				count++;
				if (count > maxCount) // use Math.max instead
					maxCount = count;
				i++;
			}

			if (i >= arr.length)
				break;

			while (j < dep.length && arr[i] > dep[j]) {
				count--;
				j++;
			}
		}

		return maxCount;
	}

	// Returns minimum number of platforms required - GFG
	static int findPlatform(int arr[], int dep[], int n) {
		// Sort arrival and departure arrays
		Arrays.sort(arr);
		Arrays.sort(dep);

		// plat_needed indicates number of platforms
		// needed at a time
		int plat_needed = 1, result = 1;
		int i = 1, j = 0;

		// Similar to merge in merge sort to process
		// all events in sorted order
		while (i < n && j < n) {
			// If next event in sorted order is arrival,
			// increment count of platforms needed
			if (arr[i] <= dep[j]) {
				plat_needed++;
				i++;
			}

			// Else decrement count of platforms needed
			else if (arr[i] > dep[j]) {
				plat_needed--;
				j++;
			}

			// Update result if needed
			if (plat_needed > result)
				result = plat_needed;
		}

		return result;
	}

	public static void main(String[] args) {

		int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
		int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };

		System.out.println(findNumOfPlatform(arr, dep));

	}

}
