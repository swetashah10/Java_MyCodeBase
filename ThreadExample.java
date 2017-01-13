import java.util.LinkedList;

/*
 * Problem Statement: There are 2 threads - Producer and Consumer. Producer adds data to a buffer, and Consumer
 * consumes data from the buffer. The constraint is: There is certain capacity of the buffer to hold data. If 
 * the buffer capacity is exceeded, producer should not be able to add items to it, and if the buffer is empty,
 * consumer should not try to remove an item from the buffer. 
 * 
 */
public class ThreadExample {

	LinkedList<Integer> listOfIntegers = new LinkedList<Integer>();
	
	public static void main(){
		
		// Instantiate Thread1 to start the Producer thread. 
		// Instantiate Thread2 to start the Consumer thread.
		
	}
	
}

class PC {
	
	LinkedList<Integer> linkedListWithData = new LinkedList<Integer>();
	int capacity = 2;
	
	// Producer adds the data in the buffer after checking whether the list is not full. 
	public void produce(Integer n)  throws InterruptedException{
		
		while(true){
			if(linkedListWithData.size() < capacity){
				linkedListWithData.add(n);
			}else{
				notify();
			}
		}
	}
	
	// Consumer removes the data from the buffer after checking if the list is not empty.
	public int consume()  throws InterruptedException{
		int x = 0;
		
		//while(true){
			if(linkedListWithData.size() != 0){
				x = linkedListWithData.removeFirst() ; 
			}else{
				wait();
			}
		//}
		return x;
	}
}