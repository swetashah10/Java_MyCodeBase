package ctci.ch01;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

// return true if one or zero edit away.
public class p1dot5 {

	boolean oneEditAway(String first, String second) {
		if(first.length() == second.length()) {
			return oneEditReplace(first,second);
		}else if(first.length()+1 == second.length()) {
			return oneEditInsert(first,second);
		}else if(second.length() + 1 == first.length()){
			return oneEditInsert(second,first);
		}
		
		return false;
	}
	
	boolean oneEditReplace(String first, String second) {
		int index1 = 0;
		int index2 = 0;
		boolean diffFound = false;
		while(index1 < first.length() && index2 < second.length()) {
			if(first.charAt(index1) != second.charAt(index2)) {
				
				if(diffFound) {
					return false;
				}
				diffFound = true;
			}
			index1++;
			index2++;
		}
		return true;
	}
	
	boolean oneEditInsert(String first, String second) {
		
		int index1 = 0, index2 = 0;
		
		while(index1 < first.length() && index2 < second.length()) {
			if(first.charAt(index1) != second.charAt(index2)) {
				if(index1 != index2) {
					return false;
				}
				// have a doubt here, why index2 is considered specifically? Can we not consider index1?
				index1++;
			}else {
				index1++;
				index2++;
			}
		}
		return true;
	}
	@Test
	public void test1() {
		
		String first = "cat";
		String second = "bat";
		
		assertTrue(oneEditAway(first, second));
	}
	
	@Test
	public void test2() {
		
		String first = "cate";
		String second = "cat";
		
		assertTrue(oneEditAway(first, second));
	}
	
	@Test
	public void test3() {
		
		String first = "cat";
		String second = "cate";
		
		assertTrue(oneEditAway(first, second));
	}
	@Test
	public void test4() {
		
		String first = "cater";
		String second = "cat";
		
		assertFalse(oneEditAway(first, second));
	}
}
