package ctci.ch02;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// Intersection of 2 linked lists
public class p2dot7 {

	LinkedListNode findIntersection(LinkedListNode l1, LinkedListNode l2) {
		
		if(l1 == null || l2 == null) {
			return null;
		}
		
		// Determine the tail node and sizes for both the lists. 
		ResultNode result1 = getTailAndSize(l1);
		ResultNode result2 = getTailAndSize(l2);
		
		if(result1.tail != result2.tail) {
			return null;
		}
		
		// chop off the longer list by longer size - shorter size. 
		LinkedListNode longerList = result1.size >= result2.size ? l1 : l2;
		LinkedListNode shorterList = result1.size < result2.size ? l1 : l2;
		
		int sizeDiff = Math.abs(result1.size - result2.size);
		for(int i=0; i<sizeDiff; i++) {
			longerList = longerList.next;
		}
		
		// navigate both lists to check point of intersection
		while(shorterList != longerList) {
			shorterList = shorterList.next;
			longerList = longerList.next;
		}
		
		return shorterList;
	}
	
	class ResultNode {
		LinkedListNode tail;
		int size;
		
		ResultNode(LinkedListNode node, int size){
			this.tail = node;
			this.size = size;
		}
	}
	
	ResultNode getTailAndSize(LinkedListNode node) {
		LinkedListNode lastNode = node;
		if(node == null) return null;
		
		int size = 0;
		while(node != null) {
			
			size++;
			lastNode = node;
			node = node.next;
		}
		
		ResultNode result = new ResultNode(lastNode, size);
		return result;
	}
	
	@Test
	public void test1() {
		
		LinkedListNode l1 = new LinkedListNode(1);
		l1.next = new LinkedListNode(2);
		l1.next.next = new LinkedListNode(3);
		LinkedListNode common = new LinkedListNode(4);
		l1.next.next.next = common;
		
		LinkedListNode l2 = new LinkedListNode(2);
		l2.next = new LinkedListNode(3);
		l2.next.next = common;
		
		common.next = new LinkedListNode(5);
		common.next.next = new LinkedListNode(6);
		
		assertEquals(4,findIntersection(l1, l2).data);
		
	}
}
