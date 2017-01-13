import java.math.BigDecimal;
import java.util.*;

public class DecimalPrecision {

	   public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int arr[] = new int[n];
	        int zero = 0;
	        BigDecimal inputSize = new BigDecimal(n);
	        BigDecimal numOfPos = new BigDecimal(zero);
	        BigDecimal numOfNeg = new BigDecimal(zero);
	        BigDecimal numOfZero = new BigDecimal(zero);
	        
	        for(int arr_i=0; arr_i < n; arr_i++){
	            arr[arr_i] = in.nextInt();
	           if(arr[arr_i] > 0)
	        	   numOfPos.add(new BigDecimal(1));
	           else if(arr[arr_i] < 0)
	        	   numOfNeg.add(new BigDecimal(1));
	           else if(arr[arr_i] == 0)
	        	   numOfZero.add(new BigDecimal(1));
	        }
	        
	        System.out.println(numOfPos.intValue() == 0? numOfPos: numOfPos.divide(inputSize, 6, BigDecimal.ROUND_UNNECESSARY));
	     
	        in.close();
	    }
}