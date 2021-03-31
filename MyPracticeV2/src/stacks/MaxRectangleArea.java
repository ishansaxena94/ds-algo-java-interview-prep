package stacks;

import java.util.Stack;

public class MaxRectangleArea {

	static int getMaxArea(int hist[]) {

		// base checks
		if (hist.length == 0)
			return 0;

		int maxArea = 0, i = 0;
		int top, maxAreaWithTop;

		Stack<Integer> s = new Stack<Integer>();

		while (i < hist.length) {

			if (s.isEmpty() || hist[s.peek()] < hist[i])
				s.push(i++);
			else {
				top = s.pop();

				maxAreaWithTop = hist[top] * (s.isEmpty() ? i : i - s.peek() - 1);

				if (maxArea < maxAreaWithTop)
					maxArea = maxAreaWithTop;
			}
		}

		while (false == s.empty()) {
			top = s.pop();

			maxAreaWithTop = hist[top] * (s.isEmpty() ? i : i - s.peek() - 1);

			if (maxArea < maxAreaWithTop)
				maxArea = maxAreaWithTop;
		}

		return maxArea;
	}

	public static void main(String[] args) {

		int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
		System.out.println("Maximum maxArea is " + getMaxArea(hist));
	}

}
