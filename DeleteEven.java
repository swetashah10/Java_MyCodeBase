package randomGFG;

import generic.Node;

public class DeleteEven {

    public static void main(String[] args) {

	Node a = new Node(2);
	Node b = new Node(1);
	Node c = new Node(6);
	Node d = new Node(7);
	Node e = new Node(9);
	Node f = new Node(3);
	Node g = new Node(4);
	Node h = new Node(6);

	a.next = b;
	b.next = c;
	c.next = d;
	d.next = e;
	e.next = f;
	f.next = g;
	g.next = h;
	h.next = null;

	Node temp = a;
	while (temp.next != null) {
	    System.out.print(temp.data + " -> ");
	    temp = temp.next;
	}
	System.out.println(temp.data);

	Node newNode = deleteEven(a);

	Node newTemp = newNode;
	while (newTemp.next != null) {
	    System.out.print(newTemp.data + " -> ");
	    newTemp = newTemp.next;
	}
	System.out.println(newTemp.data);

    }

    public static Node deleteEven(Node list) {

	if (list == null || (list.data % 2 == 0 && list.next == null))
	    return null;

	while (list.data % 2 == 0) {

	    list = list.next;
	}

	Node prev = list;
	Node curr = list.next;

	while (curr != null) {

	    if (curr.data % 2 == 0) {

		// remove references to this node
		prev.next = curr.next;
		curr.next = null;
		if (null != prev.next)
		    curr = prev.next.next;
	    }

	    curr = curr.next;
	    prev = curr;
	}

	return list;
    }
}
