
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RepeatedString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        long n = in.nextLong();
        long numOfAsInOriginal = 0;
        long numOfAsInString = 0;
        long numOfRemainingElems = 0;
        Map<Long, Long> mapOfIndexAndNumOfAs = new HashMap<Long, Long>();
        int lenOfStr = s.length();
        
        if(lenOfStr >= 1 && lenOfStr <= 100){
            
            for(int i=0; i<lenOfStr; i++){
                if(s.charAt(i) == 'a'){
                   numOfAsInOriginal++; 
                }
                mapOfIndexAndNumOfAs.put(new Long(i), numOfAsInOriginal);
            }
            if(lenOfStr < n){
                
                numOfAsInString = (n / (lenOfStr)) * numOfAsInOriginal;
                numOfRemainingElems = n % (lenOfStr);
                if(numOfRemainingElems > 0)
                   numOfAsInString += mapOfIndexAndNumOfAs.get(numOfRemainingElems-1);
            }
        }
        
        System.out.println(numOfAsInString);
    }
}
