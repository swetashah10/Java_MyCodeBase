public class Add2LinkedLists {

	static class Node2 {

		int data;
		Node2 next;

		Node2(int d) {
			data = d;
			next = null;
		}
	}

	public static Node2 addTwoLinkedLists(Node2 first, Node2 second) {

		Node2 resultList = null;
		int carry = 0,
		sum = 0;
		Node2 temp = null;
		Node2 prev = null;

		while (first != null || second != null) {

			sum = carry + (first != null ? first.data: 0) + (second != null ? second.data: 0);

			carry = (sum >= 10) ? 1 : 0;
			sum = sum % 10;

			temp = new Node2(sum);

			if (resultList == null) {
				resultList = temp;
				//prev = resultList;
			} else {
				prev.next = temp;
			}

			prev = temp;

			if (first != null) first = first.next;

			if (second != null) second = second.next;

		}

		if (carry > 0) temp.next = new Node2(carry);

		return resultList;
	}

	public static void printList(Node2 node) {

		Node2 temp = node;

		if (node == null) {
			System.out.println("Nothing to print!");
			return;
		}

		while (temp != null) {

			if (temp.next == null) {
				System.out.print(temp.data);
				System.out.println();
				return;
			} else {
				System.out.print(temp.data + " -> ");

				temp = temp.next;
			}
		}

	}

	public static void main(String[] args) {

		Add2LinkedLists a = new Add2LinkedLists();

		Node2 first = new Node2(1);
		first.next = new Node2(2);
		first.next.next = new Node2(3);

		Node2 second = new Node2(5);
		second.next = new Node2(6);
		second.next.next = new Node2(7);

		printList(first);
		printList(second);

		Node2 result = addTwoLinkedLists(first, second);

		printList(result);

	}
}
