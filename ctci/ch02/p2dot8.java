package ctci.ch02;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// loop detection
public class p2dot8 {

	LinkedListNode findBeginningOfLoop(LinkedListNode node) {
		
		LinkedListNode slowRunner = node;
		LinkedListNode fastRunner = node;
		
		while(fastRunner != null && fastRunner.next != null) {
			
			slowRunner = slowRunner.next;
			fastRunner = fastRunner.next.next;
			
			if(slowRunner == fastRunner) {
				break;
			}
		}
		
		if(fastRunner == null || fastRunner.next == null) {
			return null;
		}
		
		slowRunner = node;
		
		while(slowRunner != fastRunner) {
			slowRunner = slowRunner.next;
			fastRunner = fastRunner.next;
		}
		return fastRunner;
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
		n5.next = n3;
		
		System.out.println(findBeginningOfLoop(n1).data);
		assertEquals(n3,findBeginningOfLoop(n1));
		
	}
}
