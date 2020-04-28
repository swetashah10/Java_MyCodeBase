package ctci.ch01;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

// Check if string is a permutation of other string
public class p1dot2 {

	static boolean isPermutation_sort(String s1, String s2) {

		if (s1.length() == s2.length()) {
			char[] content1 = s1.toCharArray();
			char[] content2 = s2.toCharArray();
			
			Arrays.sort(content1);
			Arrays.sort(content2);
			
			String ss1 = new String(content1);
			String ss2 = new String(content2);
			
			 if(ss1.equals(ss2)) {
				 return true;
			 }
		}
		return false;
	}

	static boolean isPermutation_charset(String s1, String s2) {
		
		
		if (s1.length() == s2.length()) {
			int[] char_set = new int[128]; // Assuming ASCII character set
			for(int i=0; i<s1.length(); i++) {
				
				char_set[s1.charAt(i)]++;
			}
			
			for(int j=0; j<s2.length(); j++) {
				char_set[s2.charAt(j)]--;
				if(char_set[s2.charAt(j)] < 0) {
					return false;
				}
			}
			
		}else {
			return false;
		}
		
		return true;
	}

	@Test
	public void test1() {
		String s1 = "god";
		String s2 = "dog";

		Assert.assertTrue(isPermutation_sort(s1, s2));
	}
	
	@Test
	public void test2() {
		String s2 = "dog";
		String s3 = "God ";
		Assert.assertFalse(isPermutation_sort(s3, s2));
	}

	@Test
	public void test3() {
		String s1 = "god";
		String s2 = "dog";
		Assert.assertTrue(isPermutation_charset(s1, s2));
				//Assert.assertFalse(isPermutation_charset(s3, s2));
	}
	
	@Test
	public void test4() {
		String s2 = "dog";
		String s3 = "God ";
		Assert.assertFalse(isPermutation_charset(s3, s2));
	}
}
