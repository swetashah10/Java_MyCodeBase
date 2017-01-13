
public class DeleteNodeLinkedList {

	// Define the linked list structure
}

class MyOtherLinkedList{
	
	MyNode head;
	
	public MyOtherLinkedList(MyNode node){
		head = node;
	}
	
	public MyNode addNodeToLinkedList(MyNode node){
		
		return head;
	}
}

class MyNode{
	
	int data; 
	MyNode node;
	
	MyNode(int dataFromUser, MyNode myNodeFromUser){
		data = dataFromUser;
		node = myNodeFromUser;
	}
}