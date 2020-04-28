package ctci.ch02;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// delete a node from the middle of the linked list given access only to that node.
public class p2dot3 {

	void deleteNodeFromMiddle(LinkedListNode node) {
		
		if(node != null && node.next != null) {
			node.data = node.next.data;
			node.next = node.next.next;
		}
	}
	
	@Test
	public void test1() {
		
		LinkedListNode n1 = new LinkedListNode(1);
		LinkedListNode n2 = new LinkedListNode(2);
		LinkedListNode n3 = new LinkedListNode(3);
		LinkedListNode n4 = new LinkedListNode(4);
		LinkedListNode n5 = new LinkedListNode(5);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4; 
		n4.next = n5;
		
		assertEquals("1 ->  2 ->  3 ->  4 ->  5 -> NULL",n1.printList());
		
		deleteNodeFromMiddle(n3);
		
		assertEquals("1 ->  2 ->  4 ->  5 -> NULL",n1.printList());
		
	}
}
