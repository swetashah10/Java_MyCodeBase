import java.util.Scanner;


public class DecimalToBinary {

	public static void main(String args[]){
		
		System.out.println("Enter the decimal number to be converted: ");
		Scanner sn = new Scanner(System.in);
		int n = sn.nextInt();
		
		if(n == 0 || n == 1)
			System.out.println("Binary: "+n);
		else{
			
			int remainder, quotient = n;
			StringBuilder sb = new StringBuilder();

			do{
			
			remainder = quotient % 2;
			quotient = quotient / 2;
			
			sb.append(remainder);
			
			}while(remainder != 0);
			
			if(remainder == 0){
				sb.append(quotient);
			}
			
			System.out.println("Binary of "+n+" = "+sb.toString());
		}
		
		
	}
}
