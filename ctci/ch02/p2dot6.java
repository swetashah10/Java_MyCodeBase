package ctci.ch02;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

// LinkedList is palindrome?
public class p2dot6 {

	boolean isPalindrome(LinkedListNode node) {
		
		LinkedListNode fastRunner = node;
		LinkedListNode slowRunner = node;
		Stack<Integer> stackOfInts = new Stack<Integer>();
		
		while(fastRunner != null && fastRunner.next != null) {
			stackOfInts.push(slowRunner.data);
			fastRunner = fastRunner.next.next;
			slowRunner = slowRunner.next;
		}
		
		if(fastRunner != null) {
			slowRunner = slowRunner.next;
		}
		
		while(slowRunner != null) {
			int top = stackOfInts.pop().intValue();
			if(top != slowRunner.data) {
				return false;
			}
			slowRunner = slowRunner.next;
		}
		return true;
	}
	
	@Test
	public void test1() {
		LinkedListNode n1 = new LinkedListNode(1);
		LinkedListNode n2 = new LinkedListNode(2);
		LinkedListNode n3 = new LinkedListNode(3);
		LinkedListNode n4 = new LinkedListNode(2);
		LinkedListNode n5 = new LinkedListNode(1);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4; 
		n4.next = n5;
		
		assertTrue(isPalindrome(n1));
		
		LinkedListNode n6 = new LinkedListNode(4);
		n5.next = n6;
		
		assertFalse(isPalindrome(n1));
	}
}
