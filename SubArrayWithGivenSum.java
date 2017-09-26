import java.util.*;
import java.lang.*;
import java.io.*;


/** 
 * Given an unsorted array of non-negative integers, find a continuous sub-array which adds to a given number.
 */
class SubArrayWithGivenSum
 {
	public static void main (String[] args)
	 {
	    // Write your code here. 
	    Scanner sn = new Scanner(System.in);
	    
	    int T = sn.nextInt();
	    
	    while(T!=0){
	        
	        int arrSize = sn.nextInt();
	        int sum = sn.nextInt();
	        
	        int[] arr = new int[arrSize];
	        for(int i=0; i<arrSize; i++){
	            arr[i] = sn.nextInt();
	        }
	        
	        findSubArrayWithSum(arr, sum);
	        T--;
	    }
	    sn.close();
	 }
	 
	 public static void findSubArrayWithSum(int[] arr, int sum){
	     
	     int startIndex = 0, endIndex = 0;
	     int currSum = 0;
	     boolean sumFound = false;
	     
	     for(int i=0; i<arr.length; i++){
	         
	         currSum += arr[i];
	         if(currSum < sum){
	             endIndex++;
	            continue;
	         } else if(currSum > sum){
	             // reset current sum to remove the prev value from the sum and consider next sum. 
	             currSum = currSum - arr[startIndex];
	             //shift the startIndex to next position and start the loop again. 
	             startIndex = startIndex + 1;
	         }
	         
	         if(currSum == sum) {
	             
	            // we got the positions of the integers whose sum matches with sum. Print them out. 
	            System.out.println((startIndex + 1) + " " + (endIndex+1));
	            sumFound = true;
	            break;
	         }
	     }
	     
	     if(!sumFound)
	        System.out.println("-1");
	 }
}
