package practice.sort;

import java.util.ArrayList;
import java.util.HashMap;

/* Add the problem statement here */
public class IsomorphicWords {

	public static void main(String args[]) {
		final String s1 = new String("for");
		final String s2 = new String("app");

		final boolean isIsomorphic = checkIfIsomorphic(s1, s2);
		System.out.println("Isomorphic results for: " + s1 + " and " + s2
				+ " : " + isIsomorphic);
	}

	public static boolean checkIfIsomorphic(String s1, String s2) {

		if (null == s1 || null == s2) {
			return false;
		} else if (s1.length() == 0 && s2.length() == 0) {
			return true;
		}

		if (encode(s1).equalsIgnoreCase(encode(s2))) {
			return true;
		} else {
			return false;
		}

	}

	public static String encode(String s) {
		// create a map, and insert the char and its first occurence index.
		final HashMap<Character, String> map = new HashMap<Character, String>();
		final ArrayList<String> listOfIndices = new ArrayList<String>();

		for (int i = 0; i < s.length(); i++) {
			final char c = s.charAt(i);
			if (!map.containsKey(c)) {
				map.put(c, String.valueOf(i));
				listOfIndices.add(String.valueOf(i));
			} else {
				final String index = map.get(c);
				listOfIndices.add(index);
			}
		}

		return listOfIndices;
	}
}
