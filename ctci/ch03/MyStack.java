package ctci.ch03.basics;

import java.util.EmptyStackException;

public class MyStack<T> {

	private static class MyStackNode<T> {
		private T data;
		private MyStackNode<T> next;
		
		public MyStackNode(T data) {
			this.data = data;
		}
	}
	
	private MyStackNode<T> top;
	private int size;
	
	public MyStack() {
		top = null;
		size = 0;
	}
	
	public T pop() {
		if(top == null) throw new EmptyStackException();
		T item = top.data;
		top = top.next;
		size--;
		return item;
	}
	
	public T peek() {
		if(top == null) throw new EmptyStackException();
		return top.data;
	}
	
	public void push(T item) {
		
		MyStackNode<T> newItem = new MyStackNode<T>(item);
		
		newItem.next = top;
		top = newItem;
		size++;
	}
	
	public boolean isEmpty() {
		return top == null ? true : false;
	}
}
