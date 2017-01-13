
public class DeleteNthNodeFromList {

	Node3 head;
	
	DeleteNthNodeFromList(int d){
		head = new Node3(d);
	}
	
	static class Node3{
		int data;
		Node3 next;
		
		Node3(int d){
			data = d;
			next = null;
		}
	}
	
	public static void main(String[] args){
		
		DeleteNthNodeFromList delNodeClassObj = new DeleteNthNodeFromList(1);
		delNodeClassObj.head.next = new Node3(2);
		delNodeClassObj.head.next.next = new Node3(3);
		delNodeClassObj.head.next.next.next = new Node3(4);
		delNodeClassObj.head.next.next.next.next = new Node3(5);
		
		delNodeClassObj.printList(delNodeClassObj.head);
		
		delNodeClassObj.deleteNodeFromEnd(5);
		//delNodeClassObj.deleteNodeFromEndInLessTime(1);
		
		delNodeClassObj.printList(delNodeClassObj.head);
	}

	public void deleteNodeFromEndInLessTime(int i){
		
		Node3 first = this.head;
		Node3 second = this.head;
		Node3 prev = null;
		
		int pos = 0;
		while(first != null){
		
			first = first.next;
			pos++;
			if(pos > i){
				prev = second;
				second = second.next;
			}
		}
		
		if(second != null && second.next != null && prev != null){
			prev.next = second.next;
		}else if(prev != null){
			prev.next = null;
		}else if(prev == null && second != null){
			
			// This means we need to adjust the head pointer
			
			second = second.next;
			this.head = second;
			
		}
	}
	
	public void deleteNodeFromEnd(int i) {
		// TODO Auto-generated method stub
		int size = 0;
		Node3 temp = this.head;
		
		// While loop = O(n)
		while(temp != null){
			temp = temp.next;
			size++;
		}
		
		int indexToDelete = size >= i? (size - i) : -1;
		Node3 temp1 = this.head;
		Node3 prev = null;
		if(indexToDelete >= 0){
			int count = 0;
			
			// while loop = O(n - k) = O(n)
			while(count != indexToDelete && temp1 != null){
				prev = temp1;
				temp1 = temp1.next;
				count ++;
			}
			
			if(temp1 != null && temp1.next != null && prev != null)
			   prev.next = temp1.next;
			else if(prev != null)
				prev.next = null;
			else if(prev == null && temp1 != null){
				// This means we need to adjust the head pointer
				temp1 = temp1.next;
				this.head = temp1;
			}
		}
	}
	
	public void printList(Node3 node){
		
		Node3 temp = node;
		if(temp == null)
			System.out.println("No nodes to print.");
		while(temp != null){
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		
		System.out.println();
	}
}
