import java.io.*;
import java.lang.Integer.*;
import java.util.*;

class NextGreaterInArray {
	public static void main (String[] args) {
		//code
		
		int[] arr = new int[]{13,7,6,12};
		/*int[] res = nextGreater(arr);
		
		for(int i=0; i<res.length; i++){
		    
		    System.out.println(res[i]);
		}*/
		
		nextGreaterOne(arr);
	}
	
	public static int[] nextGreater(int[] arr){
	    int[] resultArr = new int[arr.length];
	    
	    for(int i=0; i<arr.length-1; i++){
	        int jValue = -1;
	        for(int j=i+1; j < arr.length; j++){
	            
	            if(i != j && arr[j] > arr[i]){
	                jValue = arr[j];
	              break;  
	            }
	                 
	        }
	        resultArr[i] = jValue;
	    }
	    
	    resultArr[arr.length-1] = -1;
	    return resultArr;
	}
	
public static void nextGreaterOne(int[] arr){

   Stack<Integer> stackOfArr = new Stack<Integer>();
   stackOfArr.push(arr[0]);
   
   for(int i=1; i<arr.length; i++){
      
      if(stackOfArr.peek() < arr[i]){
         while(!stackOfArr.isEmpty() && arr[i] > stackOfArr.peek()){
            System.out.println("The next greater element for "+stackOfArr.pop()+" is "+arr[i]);
         }
         stackOfArr.push(arr[i]);
      } else {
         stackOfArr.push(arr[i]);
      }
   }
   
   if(!stackOfArr.isEmpty()){
       
       while(!stackOfArr.isEmpty()){
           System.out.println("The next greater element for "+stackOfArr.pop()+" is -1");
       }
   }
}
}
