package stacks;

import java.util.Stack;

public class MinStack {

	Stack<Integer> s = new Stack<>();
	int minEle;

	public void push(int data) {

		if (s.isEmpty()) {
			s.push(data);
			minEle = data;
			return;
		}

		if (data < minEle) {
			int x = 2 * data - minEle;
			s.push(x);
			minEle = data;
		} else
			s.push(data);
	}

	public int pop() throws Exception {

		if (s.isEmpty())
			throw new Exception("Stack is empty");

		int ele = s.pop();
		if (ele < minEle) {
			int y = minEle;
			minEle = 2 * minEle - ele;
			return y;
		} else {
			return ele;
		}
	}

	public int getMin() {
		return minEle;
	}

	public int peek() throws Exception {

		if (s.isEmpty()) {
			throw new Exception("Stack is empty");
		}

		if (s.peek() > minEle)
			return s.peek();
		else {
			return minEle;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack s = new MinStack();

		try {
			s.push(3);
			s.push(5);
			System.out.println("Min: " + s.getMin());
			s.push(2);
			s.push(1);
			System.out.println("Min: " + s.getMin());
			System.out.println("Popped: " + s.pop());
			System.out.println("Min: " + s.getMin());
			System.out.println("Popped: " + s.pop());
			System.out.println("Top: " + s.peek());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
