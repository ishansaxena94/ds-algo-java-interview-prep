package strings;

public class LongestPalindromeInAString {

	static int findLongestPalindrome(String str) {

		int maxLength = 0;
		char ch[] = str.toCharArray();

		int low = 0, high = 0;
		int len = ch.length;

		for (int i = 1; i < len; i++) {

			// even length palindrome
			low = i - 1;
			high = i;
			while (low >= 0 && high < len && ch[low] == ch[high]) {

				if (high - low + 1 > maxLength)
					maxLength = high - low + 1;

				low--;
				high++;
			}

			// odd length palindrome
			low = i - 1;
			high = i + 1;
			while (low >= 0 && high < len && ch[low] == ch[high]) {

				if (high - low + 1 > maxLength)
					maxLength = high - low + 1;

				low--;
				high++;
			}
		}

		return maxLength;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "forgeeksskeegfor";
		System.out.println("Length is: " + findLongestPalindrome(str));
	}

}