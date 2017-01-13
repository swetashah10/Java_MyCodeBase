import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MinimumDistance {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int A[] = new int[n];
        for(int A_i=0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
        }
        
        Map<Integer, Integer> mapOfValueAndMinIndexDistance = new HashMap<Integer, Integer>();
        
        if(n >= 1 && n <= 1000){
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(A[i] == A[j]){
                    
                    if(mapOfValueAndMinIndexDistance.containsKey(A[i]) && mapOfValueAndMinIndexDistance.get(A[i]) < (Math.abs(i-j))){
                        mapOfValueAndMinIndexDistance.put(A[i], Math.abs(i-j));
                    }else{
                        mapOfValueAndMinIndexDistance.put(A[i], Math.abs(i-j));
                    }
                }
            }
        }
        
        int minDistance = 1001;
        for(Integer k: mapOfValueAndMinIndexDistance.keySet()){
           
            if(mapOfValueAndMinIndexDistance.get(k) < minDistance){
                minDistance = mapOfValueAndMinIndexDistance.get(k);
            }
        }
        System.out.println(minDistance);
        in.close();
    }
    }
}