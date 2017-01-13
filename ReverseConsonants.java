import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ReverseConsonants {
	public static Set<Character> vowels = new HashSet<Character>();

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		System.out
				.println("Enter the number of words and the word in new line: ");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String[] words = new String[n];
		for (int i = 0; i < n; i++) {
			words[i] = in.next();
		}

		
		in.close();

		// reserve the space for the vowels and print out the indexes of the
		// consonants.

		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');
		for (int m = 0; m < words.length; m++) {
			String str = words[m];
			char[] result = new char[str.length()];
			char[] consArr = new char[str.length()];
			int j = 0;
			for (int i = 0; i < str.length(); i++) {
				if (vowels.contains(str.charAt(i))) {
					result[i] = str.charAt(i);
				} else {
					consArr[j] = str.charAt(i);
					j++;
				}
			}
			for (int i = 0; i < result.length; i++) {
				System.out.println("Index: " + i + "  Value: " + result[i]);
			}
			for (int k = j - 1; k >= 0; k--) {
				for (int i = 0; i < str.length(); i++) {
					if (result[i] == 0) {
						result[i] = consArr[k];
						
						break;

					}
				}
			}
			
			System.out.println(result);
		}
	}
}