package numbers;

public class MaxNumFromKSwaps {

	static String max = "";

	static void swap(char[] str, int i, int j) {

		char tmp = str[i];
		str[i] = str[j];
		str[j] = tmp;
	}

	static void findMaxNum(char[] num, int k, int ctr) {

		// base check .. return if no swaps left
		if (k == 0 || num.length == 0)
			return;

		int len = num.length;
		char maxCh = num[ctr];

		// find max number character
		for (int j = ctr + 1; j < len; j++) {
			if (maxCh < num[j])
				maxCh = num[j];
		}

		// if max is not equal to k, decrement k
		// It means that we have a new max element and we have to swap
		if (maxCh != num[ctr]) {
			System.out.print("-> k= " + k + ", for " + String.valueOf(num) + " ");
			k--;
		}

		boolean flag = false; // for Output

		// search this maximum among the rest
		for (int j = ctr; j < len; j++) {

			if (num[j] == maxCh) {

				String b4swap = String.valueOf(num);

				swap(num, ctr, j);

				if (String.valueOf(num).compareTo(String.valueOf(max)) > 0) {
					System.out.println(
							"\t | ctr, j= " + ctr + ", " + j + "\t|| From:" + b4swap + "\tTo: " + String.valueOf(num));

					max = String.valueOf(num);
					flag = true; // for Output
				}

				findMaxNum(num, k, ctr + 1);

				swap(num, ctr, j);

			}
		}

		if (flag)
			System.out.println("-");
	}

	public static void main(String[] args) {

		String str = "129814999";
		int k = 4;
		max = str;

		findMaxNum(str.toCharArray(), k, 0);

		System.out.println(max);
	}

}
