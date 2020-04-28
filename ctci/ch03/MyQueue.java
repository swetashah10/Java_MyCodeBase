package ctci.ch03.basics;

import java.util.NoSuchElementException;

public class MyQueue<T> {

	private static class MyQueueNode<T> {

		private T item;
		private MyQueueNode<T> next;

		public MyQueueNode(T data) {

			this.item = data;
		}
	}

	private MyQueueNode<T> first;
	private MyQueueNode<T> last;
	private int size;

	public MyQueue() {
		first = null;
		last = null;
		size = 0;
	}

	public void add(T item) {
		MyQueueNode<T> myQueueNode = new MyQueueNode<T>(item);
		if (last != null) {
			last.next = myQueueNode;
		}

		last = myQueueNode;
		if (first == null) {
			first = last;
		}

		size++;
	}

	public T remove() {

		if(first == null) throw new NoSuchElementException();
		
		T data = first.item;
		first = first.next;
		
		if(first == null) {
			last = null;
		}
		
		size--;
		return data;
	}

	public T peek() {

		if(first == null) throw new NoSuchElementException();
		return first.item;
	}

	public boolean isEmpty() {

		return first == null;
	}
}
