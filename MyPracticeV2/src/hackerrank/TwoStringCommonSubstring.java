package hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;;

public class TwoStringCommonSubstring {

	static String twoStrings(String s1, String s2) {

		char a1[] = s1.toCharArray();
		char a2[] = s2.toCharArray();

		int hm[] = new int[26];

		for (char c : a1) {
			hm[c - 'a']++;
		}

		for (char c2 : a2) {
			if (hm[c2 - 'a'] > 0) {
				return "YES";
			}
		}

		return "NO";

	}

	static void checkMagazine(String[] magazine, String[] note) {

		if (magazine == null && note == null)
			System.out.println("Yes");

		if (magazine == null || note == null)
			System.out.println("No");

		int mhm[] = new int[255];
		int nhm[] = new int[255];

		char arr[];

		for (String s : magazine) {
			arr = s.toCharArray();

			for (char c : arr)
				mhm[c - 'A']++;
		}

		// System.out.println("Here 1");
		for (String s : note) {
			arr = s.toCharArray();

			for (char c : arr)
				nhm[c - 'A']++;
		}

		for (int i = 0; i < nhm.length; i++) {
			if (nhm[i] > 0 && nhm[i] > mhm[i]) {
				System.out.println("No");
				return;
			}

		}

		System.out.println("Yes");
	}

	static void checkMagazine2(String[] magazine, String[] note) {
		if (magazine == null && note == null)
			System.out.println("Yes");

		if (magazine == null || note == null)
			System.out.println("No");

		int c = 0;
		HashMap<String, Integer> mhm = new HashMap<>();
		HashMap<String, Integer> nhm = new HashMap<>();

		for (String s : magazine) {

			if (null == mhm.get(s))
				mhm.put(s, 1);
			else {
				c = mhm.get(s);
				c++;
				mhm.put(s, c);
			}
		}

		for (String s : note) {

			if (null == nhm.get(s))
				nhm.put(s, 1);
			else {
				c = nhm.get(s);
				c++;
				nhm.put(s, c);
			}
		}

		for (Map.Entry<String, Integer> entry : nhm.entrySet()) {
			if (mhm.get(entry.getKey()) == null || nhm.get(entry.getKey()) > mhm.get(entry.getKey())) {
				System.out.println("No");
				return;
			}
		}

		System.out.println("Yes");

	}

	static String isValid(String s) {

		char arr[] = s.toCharArray();
		int c = 0;

		int[] hm = new int[26];
		HashMap<Integer, Integer> ihm = new HashMap<>();

		for (char ch : arr)
			hm[ch - 'a']++;

		for (int freq : hm) {

			if (freq == 0)
				continue;

			if (ihm.get(freq) == null)
				ihm.put(freq, 1);
			else {
				c = ihm.get(freq);
				c++;
				ihm.put(freq, c);
			}
		}

		if (ihm.size() == 1)
			return "YES";
		else if (ihm.size() == 2) {

			int v1, v2, k1, k2;

			List<Integer> values = new ArrayList<>(ihm.values());
			List<Integer> keys = new ArrayList<>(ihm.keySet());

			v1 = values.get(0);
			v2 = values.get(1);
			k1 = keys.get(0);
			k2 = keys.get(1);

			// -------------------

			if ((k1 == 1 && v1 == 1) || (k2 == 1 && v2 == 1))
				return "YES";
			else if (Math.abs(k2 - k1) == 1 && (v1 == 1 || v2 == 1))
				return "YES";
			else
				return "NO";

			// -------------------

		} else
			return "NO";
	}

	static List<Integer> freqQuery(List<int[]> queries) {
		List<Integer> list = new ArrayList<Integer>();
		int[] tmp = new int[2];

		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();

		int num;

		Iterator<int[]> i = queries.iterator();

		while (i.hasNext()) {
			tmp = i.next();

			num = tmp[1];

			switch (tmp[0]) {
			case 1:
				if (hm.containsKey(num)) {
					hm.put(num, hm.get(num) + 1);
				} else {
					hm.put(num, 1);
				}
				break;

			case 2:
				if (hm.containsKey(num)) {

					if (hm.get(num) == 0) {
						hm.remove(num);
					} else {
						hm.put(num, hm.get(num) - 1);
					}

				}
				break;

			case 3:

				List<Integer> values = new ArrayList<>(hm.values());

				for (Integer v : values) {
					if (v == num)
						list.add(1);
					else
						list.add(0);
				}

//				Set<Integer> set = new TreeSet<Integer>(hm.values());
//
//				if (set.contains(num))
//					list.add(1);
//				else
//					list.add(0);

				break;

			default:
				return null;
			}
		}

		return list;
	}

	static String isBalanced(String s) {

		char arr[] = s.toCharArray();
		Stack<Character> st = new Stack<>();

		for (int i = 0; i < arr.length; i++) {

			switch (arr[i]) {
			case '(':
			case '[':
			case '{':
				st.push(arr[i]);

			case ')':
				if (st.peek() == '(') {
					st.pop();
				} else {
					return "NO";
				}
				break;

			case ']':
				if (st.peek() == '[') {
					st.pop();
				} else {
					return "NO";
				}
				break;

			case '}':
				if (st.peek() == '}') {
					st.pop();
				} else {
					return "NO";
				}
				break;

			}
		}

		if (st.isEmpty())
			return "YES";
		else
			return "NO";

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid("abcdefghgfedcba"));
//		System.out.println(isValid("aabbccddeefghi"));
		System.out.println(isValid("aabbcccc"));
		System.out.println(isValid("bcdbcd"));
		System.out.println(isValid("iiijjjkk"));
		System.out.println(isValid("abcdefghhgfedecba"));
	}

}
