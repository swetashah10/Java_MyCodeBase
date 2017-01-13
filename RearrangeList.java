// 1 -> 2 -> 3 -> 4 -> 5 -> 6
// 1 -> 6 -> 2 -> 5 -> 3 -> 4
public class RearrangeList{

/*	ListNode head;
	public static int length;
	public RearrangeList(ListNode headNode){
		head = headNode;
		
		ListNode temp = headNode;
		while(temp != null){
			length++;
			temp = temp.next;
		}
	}
	
	public static void main(String[] args){
		ListNode initList = new ListNode(1);
		initList.next = new ListNode(2);
		initList.next.next = new ListNode(3);
		initList.next.next.next = new ListNode(4);
		initList.next.next.next.next = new ListNode(5);
		initList.next.next.next.next.next = new ListNode(6);
		
		RearrangeList list = new RearrangeList(initList);
		list.printList(initList);
		list.arrangeList(initList);
		//list.printList(initList);

	}
	
	public void printList(ListNode headNode){
		ListNode temp = headNode;
		System.out.println("The values of list are:");
		while(temp != null){
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.println("NULL");
	}
	
	public void arrangeList(ListNode headNode){
		ListNode tempHeadNode = headNode;

		int i=1;
		while(i != length/2){
			i++;
			ListNode lastButOneNode = getLastButOneNode(tempHeadNode);
			ListNode lastNode = lastButOneNode.next;
			lastNode.next = tempHeadNode.next;
			tempHeadNode.next = lastNode;
			lastButOneNode.next = null;
			tempHeadNode = tempHeadNode.next.next;
			printList(headNode);
		}
	}
	
	public ListNode getLastButOneNode(ListNode headNode){
		ListNode lastButOneNode = headNode;
		ListNode temp = headNode;
		while(temp != null){
			if(temp.next.next == null){
			   lastButOneNode = temp;
			   break;
			}
			temp = temp.next;
		}
		System.out.println("LastButOneNode: "+lastButOneNode.data);
		return lastButOneNode;
	}
	*/
}
