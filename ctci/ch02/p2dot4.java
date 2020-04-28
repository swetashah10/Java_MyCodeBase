package ctci.ch02;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// Partition the linkedlist given a pivot element. 
public class p2dot4 {

	LinkedListNode partition(LinkedListNode head, int x) {

		LinkedListNode leftstart = null;
		LinkedListNode leftend = null;
		LinkedListNode rightstart = null;
		LinkedListNode rightend = null;
		LinkedListNode node = head;

		while (node != null) {
			LinkedListNode nextNode = node.next;
			if (node.data < x) {
				if (leftstart == null) {
					leftstart = node;
					leftend = leftstart;
				} else {
					leftend.next = node;
					leftend = node;
				}
			} else {
				if (rightstart == null) {
					rightstart = node;
					rightend = rightstart;
				} else {
					rightend.next = node;
					rightend = node;
					rightend.next = null;
				}
			}

			node = nextNode;
		}

		if (leftstart == null) {
			return rightstart;
		}

		leftend.next = rightstart;
		return leftstart;

	}

	@Test
	public void test1() {

		LinkedListNode n1 = new LinkedListNode(3);
		LinkedListNode n2 = new LinkedListNode(5);
		LinkedListNode n3 = new LinkedListNode(8);
		LinkedListNode n4 = new LinkedListNode(5);
		LinkedListNode n5 = new LinkedListNode(10);
		LinkedListNode n6 = new LinkedListNode(2);
		LinkedListNode n7 = new LinkedListNode(1);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;

		assertEquals("3 ->  5 ->  8 ->  5 ->  10 ->  2 ->  1 -> NULL", n1.printList());
		assertEquals("3 ->  2 ->  1 ->  5 ->  8 ->  5 ->  10 -> NULL", partition(n1, 5).printList());
	}
}
