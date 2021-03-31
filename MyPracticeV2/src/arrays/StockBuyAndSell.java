package arrays;

public class StockBuyAndSell {

	static void maximizeProfit(int arr[]) {

		int len = arr.length;
		int min, max, i = 0;

		while (i < len) {

			// find minima
			while (i + 1 < len && arr[i + 1] < arr[i])
				i++;
			min = i;

			// find maxima
			while (i + 1 < len && arr[i + 1] > arr[i])
				i++;
			max = i;

			System.out.println("Buy: " + min + "\tSell: " + max);
			i++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int price[] = { 100, 180, 260, 310, 40, 535, 695 };
		maximizeProfit(price);
	}
}
