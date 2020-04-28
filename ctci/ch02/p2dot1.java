package ctci.ch02;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;

import org.junit.Test;

// remove duplicates from a linked list
public class p2dot1 {

	void removeDups(LinkedListNode node) {

		HashSet<Integer> set = new HashSet<Integer>();
		LinkedListNode previous = node;
		while (node != null) {
			if (set.contains(node.data)) {
				previous.next = node.next;
			} else {
				set.add(node.data);
				previous = node;
			}
			node = node.next;
		}

	}

	void removeDupsWithoutBuffer(LinkedListNode node) {

		LinkedListNode temp = node;

		while (temp != null) {
			LinkedListNode runner = temp;
			while (runner.next != null) {
				if (temp.data == runner.next.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}

			temp = temp.next;
		}
	}

	@Test
	public void test1() {
		LinkedListNode n1 = new LinkedListNode(1);
		LinkedListNode n2 = new LinkedListNode(2);
		LinkedListNode n3 = new LinkedListNode(2);
		LinkedListNode n4 = new LinkedListNode(3);
		LinkedListNode n5 = new LinkedListNode(4);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		removeDups(n1);
		assertEquals("1 ->  2 ->  3 ->  4 -> NULL", n1.printList());
	}

	@Test
	public void test2() {
		LinkedListNode n1 = new LinkedListNode(1);
		LinkedListNode n2 = new LinkedListNode(2);
		LinkedListNode n3 = new LinkedListNode(2);
		LinkedListNode n4 = new LinkedListNode(3);
		LinkedListNode n5 = new LinkedListNode(4);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		removeDupsWithoutBuffer(n1);
		assertEquals("1 ->  2 ->  3 ->  4 -> NULL", n1.printList());
	}
}
