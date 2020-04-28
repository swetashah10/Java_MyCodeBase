package ctci.ch03;

import java.util.EmptyStackException;

// implement 3 stacks in one array
public class p3dot1 {

	class FixedMultiStack {
		private int stackCapacity;
		private int numOfStacks = 3;
		private int[] values;
		private int[] sizes;

		public FixedMultiStack(int stackSize) {
			stackCapacity = stackSize;
			values = new int[numOfStacks * stackCapacity];
			sizes = new int[numOfStacks];
		}
		
		public void push(int stackNum, int value) {

			if(isFull(stackNum)) throw new RuntimeException("Stack is full.");
			sizes[stackNum]++;
			values[indexOfTop(stackNum)] = value;
		}

		public int pop(int stackNum) {
			if(isEmpty(stackNum)) throw new EmptyStackException();
			int topIndex = indexOfTop(stackNum);
			int value = values[topIndex];
			values[topIndex] = 0;
			sizes[stackNum]--;
			return value;
		}

		public int peek(int stackNum) {
			if(isEmpty(stackNum)) throw new EmptyStackException();
			
			return values[indexOfTop(stackNum)];
		}

		public boolean isEmpty(int stackNum) {
			return sizes[stackNum] == 0;
		}

		public boolean isFull(int stackNum) {
			return sizes[stackNum] == stackCapacity;
		}

		public int indexOfTop(int stackNum) {
			int offset = stackNum * stackCapacity;
			int size = sizes[stackNum];
			return offset + size - 1; 
		}
	}
}
