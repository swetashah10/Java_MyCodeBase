
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PrimeFactors {

	public final static BigInteger TWO = new BigInteger("2");
	 public final static  BigInteger THREE = new BigInteger("3");
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner sn = new Scanner(System.in);
        int q = sn.nextInt();
        
        if(q >= 1 && q <= 100000){
          for(int i=0; i<q; i++){
            BigInteger n = sn.nextBigInteger();
            if(n.compareTo(BigInteger.TEN.pow(18)) == -1)
               System.out.println(numOfPrimeFactors(n));
          }
          
          sn.close();
        }
    }
    
    public static BigInteger sqrt(BigInteger x) {
        BigInteger div = BigInteger.ZERO.setBit(x.bitLength()/2);
        BigInteger div2 = div;
        // Loop until we hit the same value twice in a row, or wind
        // up alternating.
        for(;;) {
            BigInteger y = div.add(x.divide(div)).shiftRight(1);
            if (y.equals(div) || y.equals(div2))
                return y;
            div2 = div;
            div = y;
        }
    }
    
    public static int numOfPrimeFactors(BigInteger n){
        Set<BigInteger> primefactors = new HashSet<BigInteger>(); 
      
      
       /* for (BigInteger i = TWO; (i.compareTo(n) == -1 || i.compareTo(n) == 0); i=i.add(BigInteger.ONE)) { 
            if ((n.remainder(i)).compareTo(BigInteger.ZERO) == 0) { 
                primefactors.add(i); 
                n = n.divide(i); 
                i = i.subtract(BigInteger.ONE); 
            } 
        } */
        
        // Print the number of 2s that divide n
        while ((n.remainder(TWO)).compareTo(BigInteger.ZERO) == 0)
        {
        	primefactors.add(TWO); 
            n = n.divide(TWO);
        }
     
       
        // n must be odd at this point.  So we can skip one element (Note i = i +2)
        for (BigInteger i = THREE; (i.compareTo(sqrt(n)) == 0 || i.compareTo(sqrt(n)) == -1); i = i.add(TWO))
        {
            // While i divides n, print i and divide n
            while (n.remainder(i).compareTo(BigInteger.ZERO) == 0)
            {
            	primefactors.add(i); 
                n = n.divide(i);
            }
        }
     
        // This condition is to handle the case whien n is a prime number
        // greater than 2
        if (n.compareTo(TWO) == 1)
        	primefactors.add(n);
        
        return primefactors.size(); 
    } 
}