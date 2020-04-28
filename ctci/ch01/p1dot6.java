package ctci.ch01;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

//String compression
public class p1dot6 {

	String compress(String str) {
		StringBuilder resultStr = new StringBuilder();
		int countConsecutive = 0;
		char[] char_arr = str.toCharArray();
		for(int i=0; i<char_arr.length; i++) {
			countConsecutive++;
			if((i+1) >= char_arr.length || char_arr[i] != char_arr[i+1]) {
				resultStr.append(char_arr[i]);
				resultStr.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		return resultStr.length() > str.length()? str : resultStr.toString();
	}
	
	
	@Test
	public void test1() {
		String str = "aaabbccccccdddddddddeee";
		String expected = "a3b2c6d9e3";
		assertTrue(expected.equals(compress(str)));
	}
	
	@Test
	public void test2() {
		String str = "ab";
		String expected = "ab";
		assertTrue(expected.equals(compress(str)));
	}
}
