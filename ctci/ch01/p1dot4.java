package ctci.ch01;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

// Palindrome permutation
public class p1dot4 {

	boolean isPalindromePermutation(String phrase) {
		
		Map<Character, Integer> mapOfFreq = new HashMap<Character, Integer>();
		for (char ch : phrase.toCharArray()) {
			int c = (int) ch;
			if ((c >= (int) 'a' && c <= (int) 'z') || (c >= (int) 'A' && c <= (int) 'Z')) {
				if (mapOfFreq.containsKey(ch)) {
					mapOfFreq.put(ch, mapOfFreq.get(ch) + 1);
				} else {
					mapOfFreq.put(ch, 1);
				}
			}
		}
		
		boolean oddFreq = false;
		for(int i: mapOfFreq.values()) {
			if(i % 2 == 1) {
				if(oddFreq) {
					return false;
				}
				oddFreq = true;
			}
		}
		return true;
	}
	@Test
	public void test1() {
		
		String phrase = "taCo Cat";
		
		assertTrue(isPalindromePermutation(phrase));
	}
	
	@Test
	public void test2() {
		String phrase = "some string here and there";
		assertFalse(isPalindromePermutation(phrase));
	}
}
