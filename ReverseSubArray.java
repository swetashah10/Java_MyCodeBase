import java.util.Scanner;

/*
 * For e.g.: 
 * TestArray = {1,2,3,6,9,32,45,56,33,43,51} left index = 5, right index = 7.
 * ResultArray = {1,2,3,6,45,32,9,33,43,51} 
 */
public class ReverseSubArray {

	public static void main (String[] args) {
		//code
		boolean isInput = true;
		if(isInput){
		Scanner in = new Scanner(System.in);
		int numOfTestCases = in.nextInt();
		int numOfLines = (3*numOfTestCases);
		
		int i = 0;
		while(i!=3){
		    // Process the lines
		    // when i = 0, that line will be size of array
		    if(i==0){
		        int sizeOfArray = in.nextInt();
		        
		        String[] strArray = in.nextLine().split(" ");
		        String[] indices = in.nextLine().split(" ");
		        int leftIndex = Integer.parseInt((indices[0]));
		        int rightIndex = Integer.parseInt((indices[1]));

		        if(leftIndex < rightIndex && rightIndex < sizeOfArray){
		        	//reverseSubArray(strArray, leftIndex, rightIndex);
		        }
		    }
		    i++;
		}
	  }	else {
		  
		  int[] testArray = new int[]{1,2,3,4,5,6,7,8,9,10,11,12};
		  int leftindex = 5, rightindex = 7;
		  reverseSubArray(testArray, leftindex, rightindex);
	  }
	}

	private static void reverseSubArray(int[] strArray, int leftIndex,
			int rightIndex) {

		int[] intArray = new int[strArray.length];
		int[] subArray = new int[rightIndex - leftIndex +1];
		int j=leftIndex;
		for(int i=0; i<strArray.length; i++){
			intArray[i] = strArray[i];
			if(i >= leftIndex && j < (rightIndex+1)){
				subArray[j] = intArray[i];
				j++;
			}
		}
		
		
	}
}
