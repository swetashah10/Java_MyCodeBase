package CrackingTheCodingInterview;

import java.util.HashMap;
import java.util.Map;

/* Implement an algorithm to determine if a string has all unique characters. What if you cant use
 * any additional buffer. 
 */
public class Problem1dot1 {

	public boolean isUnique1(String str) {
		boolean isUnique = false;

		Map<Character, Integer> mapOfChars = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			if (mapOfChars.containsKey(str.charAt(i))) {
				isUnique = false;
				break;
			} else
				mapOfChars.put(str.charAt(i), new Integer(1));
		}

		if (mapOfChars.size() == str.length())
			return true;

		return isUnique;
	}

	public boolean isUnique2(String str) {
		boolean isUnique = true;

		for (int i = 0; i < str.length(); i++) {
			for (int j = i+1; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j)) {

						isUnique = false;
						break;
				}
			}
		}

		return isUnique;
	}

	public static void main(String[] args) {
		Problem1dot1 Problem1dot1Obj = new Problem1dot1();
		String str1 = "apple";
		String str2 = "shiny";
		System.out.println(""+str1+" = "
				+ Problem1dot1Obj.isUnique1(str1));
		System.out.println(""+str2+" = "
				+ Problem1dot1Obj.isUnique1(str2));

		System.out.println(""+str1+" = "
				+ Problem1dot1Obj.isUnique2(str1));
		System.out.println(""+str2+" = "
				+ Problem1dot1Obj.isUnique2(str2));
	}
}
