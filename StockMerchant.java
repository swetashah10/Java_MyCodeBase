import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class StockMerchant {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numOfMatchingPairs = 0;
        int n = in.nextInt();
        int c[] = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        
        Map<Integer, Integer> mapOfColorsAndNumberOfSocks = new HashMap<Integer, Integer>();
        if(n >= 1 && n <= 100){
           for(int i=0; i<n; i++){
               
               if(mapOfColorsAndNumberOfSocks.containsKey(c[i])){
                   
                   int count = mapOfColorsAndNumberOfSocks.get(c[i]);
                   mapOfColorsAndNumberOfSocks.put(c[i], ++count);
               }else{
                   
                   mapOfColorsAndNumberOfSocks.put(c[i], 1);
               }
           }
            
            for(Integer i : mapOfColorsAndNumberOfSocks.keySet()){
                
                numOfMatchingPairs += (mapOfColorsAndNumberOfSocks.get(i) / 2);
            }
            
        }
        
        System.out.println(numOfMatchingPairs);
    }
}
