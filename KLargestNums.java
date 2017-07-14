import java.util.*;
import java.lang.*;
import java.io.*;

class KLargestNums {
	public static void main (String[] args) {
		//code
		Scanner sn = new Scanner(System.in);
		
		int T = sn.nextInt();
		
		while(T!=0){
		    
		    int N = sn.nextInt();
		    int K = sn.nextInt();
		    int[] arr = new int[N];
		    
		    for(int i=0; i<N; i++){
		        
		        arr[i] = sn.nextInt();
		        
		    }
		    
		    printKLargest(arr, K);
		    
		    T--;
		}
		
		sn.close();
	}
	
	public static void printKLargest(int[] arr, int K){
	    
	    PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
	    
	    for(int i=0; i<arr.length; i++){
	        heap.offer(arr[i]);
	        
	        if(heap.size() > K){
	            heap.poll();
	        }
	    }
	    
	    int[] resArr = new int[K];
	    for(int j=K-1; j >= 0; j--){
	        resArr[j] = heap.poll();
	        //System.out.print(heap.poll() + " ");
	    }
	    
	    //System.out.println(heap.poll());
	    for(int i=0; i < resArr.length-1; i++){
	        
	        System.out.print(resArr[i] + " ");
	    }
	    System.out.println(resArr[resArr.length-1]);
	   }
	}
