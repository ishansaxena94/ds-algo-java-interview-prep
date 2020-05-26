package arrays;

public class EquilibriumPoint {

	public static void findEquilibrium(int arr[]) {

		int rightSum = 0, leftSum = 0;

		for (int ele : arr) {
			rightSum += ele;
		}

		for (int ele : arr) {
			rightSum -= ele;

			if (leftSum == rightSum) {
				System.out.println("FOUND!");
				return;
			}

			leftSum += ele;
		}

		System.out.println("NOT FOUND");
	}

	public static void main(String[] args) {

		int arr[] = { -7, 1, 5, 2, -4, 3, 0 };

		findEquilibrium(arr);

	}

}
