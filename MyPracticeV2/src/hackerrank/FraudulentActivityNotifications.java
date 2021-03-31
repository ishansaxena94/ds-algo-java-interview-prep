package hackerrank;

import java.util.Arrays;

public class FraudulentActivityNotifications {

	public static double findMedian(int a[], int start, int endEx) {
		// First we sort the array
		int n = endEx - start;
		// System.out.println("n=" + n + "\tstart=" + start + "\tend=" + endEx);

		Arrays.sort(a, start, endEx);

		// check for even case
		if (n % 2 != 0)
			return (double) a[start + (n / 2)];

		return (double) (a[start + ((n - 1) / 2)] + a[start + (n / 2)]) / 2.0;
	}

	static int activityNotifications2(int[] expenditure, int d) {
		int notif = 0, i, j, k = 0;
		int base[] = new int[d];

		double median = 0;

		if (expenditure.length < d)
			return 0;

		for (i = d; i < expenditure.length; i++) {

			k = 0;
//			for (j = i - d; j < d; j++) {
//
//				base[k++] = expenditure[j];
//			}

			median = findMedian(expenditure, i - d, i);

			if (((double) expenditure[i]) >= (2 * median)) {
				// System.out.println("at d=" + i + "\tmedian=" + median + "\texp=" +
				// expenditure[i]);
				notif++;
			}

		}

		return notif;
	}

	static int activityNotifications(int[] expenditure, int d) {
		int notif = 0, i = 0;

		int len = expenditure.length;
		double[] median = new double[len];

		for (i = d; i < expenditure.length; i++) {
			median[i] = 2 * findMedian(expenditure, i - d, i);
		}

		for (i = d; i < expenditure.length; i++) {

			if (expenditure[i] >= median[i]) {
				notif++;
			}
		}

		return notif;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 2, 3, 4, 2, 3, 6, 8, 4, 5 };
		int arr2[] = { 1, 2, 3, 4, 4 };
		int d = 5;

		activityNotifications(arr, d);
		System.out.println("-------");
		activityNotifications(arr2, 4);

	}

}
