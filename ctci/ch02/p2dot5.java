package ctci.ch02;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// Sum lists
public class p2dot5 {

	LinkedListNode sumList(LinkedListNode l1, LinkedListNode l2) {
		
		LinkedListNode result = null;
		LinkedListNode resultHead = null;
		int carry = 0;
		
		while(l1 != null && l2 != null) {
			
			int value = l1.data + l2.data + carry;
			if(result == null) {
				result = new LinkedListNode(value % 10);
				resultHead = result;
			}else {
				result.next = new LinkedListNode(value % 10);
				result = result.next;
			}
			
			if(value >= 10) {
				carry = 1;
			}else {
				carry = 0;
			}
			
			l1 = l1.next;
			l2 = l2.next;
		}
		
		while(l1 != null) {
			int value = l1.data + carry;
			
			result.next = new LinkedListNode(value % 10);
			result = result.next;
			if(value >= 10) {
				carry = 1;
			}else {
				carry = 0;
			}
			
			l1 = l1.next;
		}
		
		while(l2 != null) {
			int value = l2.data + carry;
			
			result.next = new LinkedListNode(value % 10);
			result = result.next;
			if(value >= 10) {
				carry = 1;
			}else {
				carry = 0;
			}
			
			l2 = l2.next;
		}
		return resultHead;
	}
	
	@Test
	public void test1() {
		
		LinkedListNode n1 = new LinkedListNode(7);
		n1.next = new LinkedListNode(1);
		n1.next.next = new LinkedListNode(6);
		
		LinkedListNode n2 = new LinkedListNode(5);
		n2.next = new LinkedListNode(9);
		n2.next.next = new LinkedListNode(2);
		
		LinkedListNode result = sumList(n1,n2);
		assertEquals("2 ->  1 ->  9 -> NULL",result.printList());
	}
}
