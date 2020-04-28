package ctci.ch02;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// return kth to last element in singly linked list
public class p2dot2 {

	int findKthToLastElement(LinkedListNode head, int k) {
		
		if(head == null) {
			return 0;
		}
		LinkedListNode temp = head;
		int index = 0;
		LinkedListNode runner = head;
		while(temp.next != null) {
			if(index >= k) {
				runner = runner.next;
			}
			temp = temp.next;
			index++;
		}
		return (k>index)?-1:runner.data;
	}
	
	@Test
	public void test1() {
		LinkedListNode n1 = new LinkedListNode(1);
		n1.next = new LinkedListNode(2);
		n1.next.next = new LinkedListNode(2);
		n1.next.next.next = new LinkedListNode(3);
		n1.next.next.next.next = new LinkedListNode(4);

		assertEquals("1 ->  2 ->  2 ->  3 ->  4 -> NULL", n1.printList());
		assertEquals(1,findKthToLastElement(n1, 4));
		assertEquals(2,findKthToLastElement(n1, 2));
		assertEquals(4,findKthToLastElement(n1, 0));
		
	}
}
