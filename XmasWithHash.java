import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class XmasWithHash {
	public static int n = 0;
	
    public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
         n = in.nextInt();
    
         char[][] hashTreeMatrix = new char [n][n];
   
    	 // For each line
    	 for(int i = 0; i < n; i++){

    	 // For each space in line, fill with either space or #.
    	 for(int j = 0; j < n; j++){
    		 if((i+j) >= (n-1))
    			hashTreeMatrix[i][j] = '#';
    		 else
    			 hashTreeMatrix[i][j] = ' ';
     }
    }
    	 for(int i=0; i<n; i++){
    		 for(int j=0; j<n; j++){
    			 
    			 System.out.print(hashTreeMatrix[i][j]);
    		 }
    		 System.out.println();
    	 }
    	
  }
}