import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CountGems {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sn = new Scanner(System.in);
        int N = sn.nextInt();
        String[] arrayOfStr = new String[N];
        Map<Character, Integer> mapOfChars = new HashMap<Character, Integer>();
        
        if(N >= 1 && N <= 100){
        for(int i=0; i<N; i++){
            arrayOfStr[i] = sn.next();
            
            if(arrayOfStr[i].length() >= 1 && arrayOfStr[i].length() <= 100){
                arrayOfStr[i] = removeDups(arrayOfStr[i]);
                System.out.println(arrayOfStr[i]);
            for(int j=0; j<arrayOfStr[i].length(); j++){
                if(i==0 && Character.isLowerCase(arrayOfStr[i].charAt(j)) && !mapOfChars.containsKey(arrayOfStr[i].charAt(j))){
                    mapOfChars.put(arrayOfStr[i].charAt(j), 1);
                }else if(i > 0 && Character.isLowerCase(arrayOfStr[i].charAt(j)) && mapOfChars.containsKey(arrayOfStr[i].charAt(j))){
                    int count = mapOfChars.get(arrayOfStr[i].charAt(j));
                    mapOfChars.put(arrayOfStr[i].charAt(j), ++count);
                }
             }
            }
         }
            int countOfGems = 0;
            System.out.println(mapOfChars);
            for(Character c: mapOfChars.keySet()){

                if(mapOfChars.get(c) == N)
                    countOfGems++;
            }
            
            System.out.println(countOfGems);
            
        }
        
        sn.close();
    }
    
    public static String removeDups(String str){
        Set<Character> setOfChars = new HashSet<Character>();
        for(int i=0; i<str.length(); i++){
            setOfChars.add(str.charAt(i));
        }
        return setOfChars.toString();
    }
}