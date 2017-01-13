/*class Node{
	int data;
	Node next;

	public Node(int d) {
		data = d;
		next = null;
	}
}
*/

public class MyLinkedList {

/*	Node head;

	public static void main(String args[]) {

		MyLinkedList linkedList = new MyLinkedList();
		linkedList.head = linkedList.addNode(new Node(1));
		System.out.println("The head node is: " + linkedList.head.data);

		Node node2 = new Node(2);
		 linkedList.addNode(node2);
		 
		 Node node3 = new Node(3);
		 linkedList.addNode(node3);
		
		linkedList.printList();
		
		System.out.println("Deleting the node 3...");
		linkedList.deleteNode(node3);
		
		linkedList.printList();

	}
	public void printList(){
		System.out.println("Printing the complete linked list: ");
		Node temp = this.head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	
	public Node addNode(Node node){
		if(this.head == null){
			this.head = node;
			return this.head;
		}
		
		Node temp = this.head;
		Node lastNode = null;
		while(temp!=null){
			lastNode = temp;
			temp=temp.next;
		}
		lastNode.next = node;
		return temp;
	}
	
	public Node deleteNode(Node node){
		Node deletedNode = node;
	    Node prevNode = head;
	    
	    Node temp = head;
	    while(temp != null){
	    	if(temp.data == node.data){
	    		prevNode.next = node.next;
	    	}
	    	
	    	prevNode = temp;
	    	temp = temp.next;
	    }
		
		return deletedNode;
	}
	*/
}
