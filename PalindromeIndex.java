import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PalindromeIndex {

     public static Map<String, Integer> mapOfRemovableIndex = new HashMap<String, Integer>();
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sn = new Scanner(System.in);
        
        int T = sn.nextInt();
        String[] arrayOfStrings = new String[T];
        
        if(T >= 1 && T <= 20){
          for(int i=0; i<T; i++){
            arrayOfStrings[i] = sn.next();
              if(arrayOfStrings[i].length() >= 1 && arrayOfStrings[i].length() <= 100005){
                  arrayOfStrings[i] = arrayOfStrings[i].toLowerCase();
                  
                 System.out.println(findRemovableIndex(arrayOfStrings[i]));
              }
          }
        }
        sn.close();
    }
    
    public static boolean isPalindrome(String str){
        
        for(int i=0; i<=str.length()/2; i++){
            if(str.charAt(i) != str.charAt(str.length()-i-1)){
                return false;
            }
        }
        return true;
    }
    
    public static int findRemovableIndex(String str){
        int indexToBeRemoved = -1;
        
        if(isPalindrome(str)){
                mapOfRemovableIndex.put(str,indexToBeRemoved);
                return indexToBeRemoved;
        }
       
        for(int i=0; i<=str.length()/2; i++){
            
        	if(indexToBeRemoved != -1 && isPalindrome(str.substring(0,indexToBeRemoved) + str.substring(indexToBeRemoved+1))){
        		 mapOfRemovableIndex.put(str,indexToBeRemoved);
                 return indexToBeRemoved;
        	}
          if(str.charAt(i) != str.charAt(str.length()-i-1)){
        	  
            if(i==0 && isPalindrome(str.substring(i+1,str.length()))){
                indexToBeRemoved = i;
                mapOfRemovableIndex.put(str,indexToBeRemoved);
                return indexToBeRemoved;
            }else if(i==str.length()-1 && isPalindrome(str.substring(0,str.length()-1))){
                indexToBeRemoved = i;
                mapOfRemovableIndex.put(str,indexToBeRemoved);
                return indexToBeRemoved;
            }else if( i>0 && i<str.length()-1 && isPalindrome(str.substring(0,i) + str.substring(i+1))){
                indexToBeRemoved = i;
                mapOfRemovableIndex.put(str,indexToBeRemoved);
                return indexToBeRemoved;
            }else{
                indexToBeRemoved = str.length()-i-1;
            }
          }
        }
        mapOfRemovableIndex.put(str,indexToBeRemoved);
        return indexToBeRemoved;
    }
}
