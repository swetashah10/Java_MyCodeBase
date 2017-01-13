
public class GetNthNodeFromLinkedList {

	LListNode head;
	
	GetNthNodeFromLinkedList(int n){
		LListNode node = new LListNode(n);
		head = node;
	}
	
	void addNode(int d){
		if(head == null)
			head = new LListNode(d);
		else{
		LListNode temp = head;
		LListNode node = new LListNode(d);
		while(temp.next != null){
			temp = temp.next;
		}
		
		temp.next = node;
		}
	}
	
	void printNodes(){
		
		if(head == null)
			System.out.println("No nodes to print. ");
		LListNode temp = head;
		
		while(temp != null){

			if(temp.next == null)
				System.out.println(temp.data);
			else
				System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
	}
	
	int getLength(){
	
		if(head == null)
			return 0;
		
		int length = 1;
		
		LListNode temp = head;
		
		while(temp != null){

			length++;
			temp = temp.next;
		}
		
		return length;
	}
	
	// find and print the k-th node
	void printKnode(int k){
		
		int len = this.getLength();
		
		if(head == null || len == 0 || k > len)
			System.out.println("No nodes to navigate.");
		else if(k <= len){
			
			LListNode temp = head;
			
			int nodeNum = len - k;
			
			LListNode first = temp;
			LListNode second = temp;
			
			while(first != null){
				first = first.next;
				
			}
		}
	}
	
	public static void main(String args[]){
		
		GetNthNodeFromLinkedList g = new GetNthNodeFromLinkedList(1);
		g.addNode(2);
		g.addNode(3);
		g.addNode(4);
		g.addNode(5);
		
		g.printNodes();
	}
	
	
}


class LListNode{
	
	int data;
	LListNode next;
	
	public LListNode(int d){
		data = d;
		next = null;
	}
}
