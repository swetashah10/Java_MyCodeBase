package ctci.ch01;

import org.junit.Assert;
import org.junit.Test;

// Check if string has all unique characters.
public class p1dot1 {
	
	static boolean isUniqueChars(String s) {
		
		// ASCII = 128 characters
		// Extended ASCII = 256 characters
		
		if(s.length() > 128) return false;
		
		boolean[] char_set = new boolean[128];
		
		for(int i=0; i<s.length(); i++) {
			if(char_set[s.charAt(i)]) {
				return false;
			}
			char_set[s.charAt(i)] = true;
		}
		return true;
	}
	
	
	@Test
	public void test1() {
		String str = "abc";
		Assert.assertTrue(isUniqueChars(str));
	}
	
	@Test
	public void test2() {
		String str = "aba";
		Assert.assertFalse(isUniqueChars(str));
	}
	
}
