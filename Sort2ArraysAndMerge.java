
public class Sort2ArraysAndMerge {

	
	public static void main(String args[]){
		Sort2ArraysAndMerge sortAndMerge = new Sort2ArraysAndMerge();
		
		int[] firstUnsortedArray = new int[]{5,3,7,2};
		int[] secondUnsortedArray = new int[]{6,8,1,4};
		
		System.out.println("Printing first array");
		sortAndMerge.printArray(firstUnsortedArray);
		System.out.println("Printing second array");
		sortAndMerge.printArray(secondUnsortedArray);
		int[] result = sortAndMerge.combineSortArrays(firstUnsortedArray, secondUnsortedArray);
	    
		System.out.println("Printing the result array:");
		sortAndMerge.printArray(result);
		
		
	}
	
	public void printArray(int[] A){
		
		for(int i=0; i<A.length; i++){
			System.out.println(A[i]);
		}
	}
	// Create a sorted array out of 2 unsorted arrays. 

	// A = {8,4,6,5} B = {2,9,3,1}
	// Result = {1,2,3,4,5,6,8}

	public int[] combineSortArrays(int[] A, int[] B){

	  int[] resultArray = new int[A.length+B.length];
	  
	  // Sort both the arrays using a sort algorithm. 
	  A = sortArray(A);
	  B = sortArray(B);

	  // Merge the sorted arrays.
	  // A = {4,5,6,8} B={1,2,3,9}
	  int k=0, j=0, i=0;
	  
	  while(i<A.length && j<B.length){
		  if(A[i] <= B[j]){
			  resultArray[k] = A[i];i++; k++;
		  }else if(B[j] < A[i]){
			  resultArray[k] = B[j]; j++; k++;
		  }
	  }
	  
	  if(i < A.length){
		 for(int m=i; m<A.length; m++){
			 resultArray[k++] = A[m];
		 }
	  }
	  
	  if(j < B.length){
		  for(int m=j; m<B.length; m++){
				 resultArray[k++] = B[m];
			 }  
	  }
	  
	  return resultArray;
	}

	public int[] sortArray(int[] unsortedArray){
	 
	  for(int i=0; i<unsortedArray.length; i++){
	  
	    for(int j=i; j<unsortedArray.length; j++){
	       
	       if(unsortedArray[i] > unsortedArray[j]){
	        // Swap the integers. 
	        int temp = unsortedArray[i];
	        unsortedArray[i] = unsortedArray[j];
	        unsortedArray[j] = temp;
	       }
	    }  
	  }
	  
	 return unsortedArray;
	}
}
