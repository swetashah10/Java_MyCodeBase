package ctci.ch02;

public class LinkedListNode {

	int data;
	LinkedListNode next;

	public LinkedListNode(int x) {
		this.data = x;
		this.next = null;
	}

	public String printList() {
		StringBuilder sb = new StringBuilder();
		LinkedListNode temp = this;
		while (temp.next != null) {
			sb.append(temp.data);
			sb.append(" ->  ");
			temp = temp.next;
		}

		if (temp != null) {
			sb.append(temp.data);
			sb.append(" -> NULL");
		}

		return sb.toString();
	}
}
