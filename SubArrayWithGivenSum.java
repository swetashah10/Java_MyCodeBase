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
	    
	    while(T != 0){
	        
	        int N = sn.nextInt();
	        int SUM = sn.nextInt();
	        int[] arr = new int[N];
	        
	        for(int  i = 0; i < N; i++){
	          arr[i] = sn.nextInt();
	        }
	        
	        findSumArray(arr, SUM);
	        T--;
	    }
	    sn.close();
	 }
	 
	 public static void findSumArray(int[] arr, int SUM){
	     
	     int startIndex = 0, endIndex = 1, currSum = arr[0];
	     boolean sumFound = false;
	     
	     if(currSum == SUM){
	         System.out.println("1 1");
	     }
	     
	     for(int i=1; i<arr.length; i++){
	         
	         if(currSum < SUM){
	             currSum += arr[i];
	             endIndex++;
	         }
	         
	         while(currSum > SUM){
	             
	             currSum = currSum - arr[startIndex];
	             startIndex++;
	         }
	         
	         if(currSum == SUM){
	             
	             System.out.println(startIndex+1 + " " + endIndex);
	             sumFound = true;
	             break;
	         }
	     }
	     
	     if(!sumFound && currSum > SUM){
	        while(currSum > SUM){
	             currSum = currSum - arr[startIndex];
	             startIndex++;
	         }
	         
	         if(currSum == SUM){
	             System.out.println(startIndex+1 + " " + endIndex);
	         }
	     }else if(!sumFound){
	         System.out.println("-1");
	     }
	 }
}
