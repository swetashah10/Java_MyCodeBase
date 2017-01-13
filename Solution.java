import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            Scanner sc=new Scanner(System.in);
            int x=sc.nextInt();
        String[] userStrings = new String[x];
        for(int i=1; i<=x; i++){
        	userStrings[i-1] = sc.next();
        }
        
        for(int i=0; i<x; i++){
        	computeFunny(userStrings[i]);
        }
    }
    
    public static void computeFunny(String str){
        boolean isFunny = false;
      StringBuffer reverseStr = new StringBuffer();
        if(str.length() >= 2 && str.length() <= 10000){
            for(int i=str.length()-1; i>0; i--){
                reverseStr.append(str.charAt(i));
            }
            reverseStr.append(str.charAt(0));
            for(int i=1; i<=str.length()-1; i=i+1){
                if(Math.abs((int)str.charAt(i)-(int)str.charAt(i-1)) !=  Math.abs((int)reverseStr.charAt(i)-(int)reverseStr.charAt(i-1))){
                    isFunny = false;
                    break;
                }else{
                    isFunny = true;
                }
                    
            }
            
            if(isFunny)
                System.out.println("Funny");
            else
                System.out.println("Not Funny");
        }
    }
}