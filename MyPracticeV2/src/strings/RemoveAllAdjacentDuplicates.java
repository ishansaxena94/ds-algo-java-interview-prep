package strings;

public class RemoveAllAdjacentDuplicates {

	static char[] substring(char[] str, int startIncl, int endEx) {

		if (str.length == 0)
			return str;

		char[] res = new char[endEx - startIncl];
		int k = 0;

		for (int i = startIncl; i < endEx; i++) {
			res[k++] = str[i];
		}

		return res;
	}

	static char[] removeUtil(char[] arr, char lastRemoved) {

		// if empty string or string has single element
		if (arr.length <= 1) {
			return arr;
		}

		// Input: caaabbbaacdddd
		// Output: Empty String
		// Remove leftmost same characters and recur for the rest of the string
		if (arr[0] == arr[1]) {
			lastRemoved = arr[0];

			while (arr.length > 1 && arr[0] == arr[1])
				arr = substring(arr, 1, arr.length);

			arr = substring(arr, 1, arr.length);

			return removeUtil(arr, lastRemoved);
		}

		// At this point, the first character is definitely different from the adjacent
		// character character.
		// Ignore the first character and recursively remove the characters for the rest
		// of the string.
		char[] remStr = removeUtil(substring(arr, 1, arr.length), lastRemoved);

		System.out.print("remStr: ");
		for (char c : remStr)
			System.out.print(c);
		System.out.println();

		// Check if the first char of the remStr matches with the first char of the OG
		// string
		if (remStr.length != 0 && remStr[0] == arr[0]) {
			lastRemoved = arr[0];
			return substring(remStr, 1, remStr.length);
		}

		// If the remaining string empty and the last removed character is same as the
		// first character of the original string.
		// This is needed for string like: acbbcddc
		if (remStr.length == 0 && lastRemoved == arr[0]) {
			System.out.println("lastRemoved: " + lastRemoved);
			return remStr;
		}

		// create string
		char n[] = null;
		if (remStr.length != 0) {
			n = new char[remStr.length + 1];

			n[0] = arr[0];
			int idx = 1;
			for (int j = 0; j < remStr.length; j++)
				n[idx++] = remStr[j];
		} else {
			n = new char[1];
			n[0] = arr[0];
		}

		System.out.print("n: ");
		for (char c : n)
			System.out.print(c);
		System.out.println();

		return n;
	}

	public static String remove(String str) {

		char lastRemoved = '\0';
		String res = String.valueOf(removeUtil(str.toCharArray(), lastRemoved));

		return res.length() == 0 ? "Empty Str" : res;
	}

	public static void main(String[] args) {

		String str1 = "geeksforgeeg";
		System.out.println(remove(str1));

		String str2 = "azxxxzy";
		System.out.println(remove(str2));

		String str3 = "caaabbbaac";
		System.out.println(remove(str3));

		String str4 = "gghhg";
		System.out.println(remove(str4));

		String str5 = "aaaacddddcappp";
		System.out.println(remove(str5));

		String str6 = "aaaaaaaaaa";
		System.out.println(remove(str6));

		String str7 = "qpaaaaadaaaaadprq";
		System.out.println(remove(str7));

		String str8 = "acaaabbbacdddd";
		System.out.println(remove(str8));

		String str9 = "acbbcddc";
		System.out.println(remove(str9));
	}

}
