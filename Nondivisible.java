import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Nondivisible {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    
        Scanner sn = new Scanner(System.in);
        int n = sn.nextInt();
        int k = sn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sn.nextInt();
        }
        
        List<Integer> resultArr = new ArrayList<Integer>();
        boolean isDivisible = false;
        
        for(int i=0; i<n; i++){
            
            if(resultArr.size() == 0)
            	resultArr.add(arr[i]);
            else {
            for(int j : resultArr){
                if((j + arr[i]) % k == 0){
                	isDivisible = true;
                    break;
                }
            }
            
            if(!isDivisible){
            	resultArr.add(arr[i]);
            }else{
            	isDivisible = false;
            }
          }
        }
    
        System.out.println("\n"+resultArr.size());
    }
}