import java.util.*;
import java.lang.*;
import java.io.*;

class CheckPerfectSquare {
	public static void main (String[] args) {
		//code
		Scanner in = new Scanner(System.in);
		int count = in.nextInt();
		for(int i=1; i<=count; i++){
		    int numToCheck = in.nextInt();
		    long sqrt = (long)Math.sqrt(numToCheck);
		    System.out.println(((sqrt*sqrt) == numToCheck?1:0));
		}
		in.close();
	}
}
