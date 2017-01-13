import java.util.Scanner;


public class InsertNthNode {

	static class Node{
		int data;
		Node next;
	}
	
	static Node head = null;
	
	public static void main(String[] args){
		
		//Scanner sn = new Scanner(System.in);
		//int T = sn.nextInt();
		
		//while(T != 0){
			//head = InsertNth(head, sn.nextInt(), sn.nextInt());
			//T--;
			//printList(head);
		//}
		
		Node headA = new Node();
		headA.data = 1;
		headA.next = null;
		headA = InsertNth(headA, 3, 1);
		headA = InsertNth(headA, 5, 2);
		headA = InsertNth(headA, 6, 3);
		printList(headA);
		
		Node headB = new Node();
		headB.data = 2;
		headB.next = null;
		headB = InsertNth(headB, 4, 1);
		headB = InsertNth(headB, 7, 2);
		printList(headB);
		
		Node mergedList = MergeLists(headA, headB);
		printList(mergedList);
		
		//sn.close();
	}
	static void printList(Node head){
		
		Node temp = head;
		while(temp != null){
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	static Node InsertNth(Node head, int data, int position) {
		   // This is a "method-only" submission. 
		    // You only need to complete this method. 
		 
		    if(position == 0){
		        
		        Node newNode = new Node();
		        newNode.data = data;
		        newNode.next = head;
		        head = newNode;
		    }else {
		        
		        int count = 0;
		        Node temp = head; Node prev = head;
		        while(temp != null || count < position){
		            
		            prev = temp;
		            temp = temp.next;
		            count++;
		        }
		        if(count == position){
		            Node newNode = new Node();
		            newNode.data = data;
		            newNode.next = temp;
		            prev.next = newNode;
		        }
		    }
		    return head;
		}
	
	static Node MergeLists(Node headA, Node headB) {
	     // This is a "method-only" submission. 
	     // You only need to complete this method 

	    if(headA == null && headB == null)
	        return null;
	    
	    if(headA == null && headB != null)
	        return headB;
	    
	    if(headB == null && headA != null)
	        return headA;
	    
	    if(headA != null && headB != null){
	        
	        Node tempA = headA, tempB = headB;
	        Node resultHead = (tempA.data <= tempB.data) ? tempA : tempB;
	        if(tempA.data <= tempB.data){
	            tempA = tempA.next;
	        }else{
	            tempB = tempB.next;
	        }
	        
	        Node result = resultHead;
	        
	        while(tempA != null && tempB != null){
	            
	            if(tempA.data < tempB.data){
	              result.next = tempA;
	              tempA = tempA.next;
	            }else{
	              result.next = tempB;
	              tempB = tempB.next;
	            }
	            result = result.next;
	        }
	        
	        if(tempA != null){
	            while(tempA != null){
	              result.next = tempA;
	              tempA = tempA.next;
	              result = result.next;
	            }
	        }
	        
	        if(tempB != null){
	            while(tempB != null){
	              result.next = tempB;
	              tempB = tempB.next;
	              result = result.next;
	            }
	        }
	        
	        return resultHead;
	    }
	       
	    return null;
	}
}
