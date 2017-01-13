import java.util.Scanner;


public class Consecutive3s {

	public static void main(String[] args){
		Scanner sn = new Scanner(System.in);
		
		int n = sn.nextInt();
		int[] arr = new int[n];
		for(int i=0 ; i<n ; i++){
			arr[i] = sn.nextInt();
		}
		
		if(returnTrueIf3(arr)){
			System.out.println("true");
		}else{
			System.out.println("false");
		}
	}
	
	public static boolean returnTrueIf3(int[] arrayOfInts){
		
		int counter = 0;
		for(int i=1;i<arrayOfInts.length; i++){			
			if(arrayOfInts[i] == arrayOfInts[i-1] && arrayOfInts[i] == 3){
				return false;
			}else if(arrayOfInts[i-1] == 3 || counter > 3){
				counter ++;
			}
		}
		
		if(counter == 3)
			return true;
		else
			return false;
		
	}
}
