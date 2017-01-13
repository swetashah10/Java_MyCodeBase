import java.util.Arrays;
import java.util.Scanner;


public class CircularArrayRotation {

	public static void main(String[] args){
		
		// Read the input in this form: "Number of elements in array" "Number of rotations" "Number of queries"
		Scanner sn = new Scanner(System.in);
		
		String firstLine = sn.nextLine();
		String[] params = firstLine.split(" ");
		
		int n = Integer.parseInt(params[0]);
		int k = Integer.parseInt(params[1]);
		int q = Integer.parseInt(params[2]);
		
		int[] arrayOfNums = new int[n];
		
		String arrayContents = sn.nextLine();
		String[] arrayContentsInArray = arrayContents.split(" ");
		
		if(arrayContentsInArray.length == n){
		   for(int i=0; i<n; i++){
			   arrayOfNums[i] = Integer.parseInt(arrayContentsInArray[i]);
		   }
		}
		
		int[] indicesToPrint = new int[q];
		for(int m=0; m<q; m++){
			indicesToPrint[m] = sn.nextInt();
		}
		
		if(k > n){
			k = k-n;
		}
		
		// Rotate the array in right circular fashion by 'stepsToRotate'
		/*for(int i=0; i<indicesToPrint.length; i++){
			
			if(indicesToPrint[i]+(k-1) < n)
				System.out.println(arrayOfNums[indicesToPrint[i]+(k-1)]);
			else
				System.out.println(arrayOfNums[indicesToPrint[i]+(k-1)-n]);
		}*/
		for(int i=0; i<indicesToPrint.length; i++){
			
			System.out.println(arrayOfNums[(n-k+indicesToPrint[i])%n]);
		}
				
		sn.close();
	}
}
