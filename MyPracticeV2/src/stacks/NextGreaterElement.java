package stacks;

import java.util.Stack;

public class NextGreaterElement {

	static void findNGE(int arr[]) {

		if (arr.length == 0)
			return;

		if (arr.length == 1) {
			System.out.println("-1");
			return;
		}

		int len = arr.length;
		Stack<Integer> stack = new Stack<>();
		stack.push(arr[0]);
		int i = 1;

		while (i < len) {

			while (i < len && arr[i] < stack.peek()) {
				stack.push(arr[i]);
				i++;
			}

			if (i < len) {
				while (!stack.empty() && stack.peek() < arr[i]) {
					System.out.println(stack.pop() + "  --> " + arr[i]);
				}

				stack.push(arr[i++]);
			}
		}

		while (!stack.empty())
			System.out.println(stack.pop() + " --> " + "-1");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = { 11, 13, 21, 3 };
		int arr2[] = { 4, 5, 2, 25 };
		int arr3[] = { 5, 3, 2, 10, 6, 8, 1, 4, 12, 7, 4 };

		findNGE(arr);
		System.out.println();

		findNGE(arr2);
		System.out.println();

		findNGE(arr3);
		System.out.println();
	}

}
