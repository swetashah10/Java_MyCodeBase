import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DynamicArray {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sn = new Scanner(System.in);
        int N = sn.nextInt();
        
        //List<Integer> seq = new ArrayList<Integer>();
        //List<List<Integer>> seqList = new ArrayList<List<Integer>>(); 
        
        ArrayList<Integer>[] seqList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
           seqList[i] = new ArrayList<Integer>();
        }
        
        int lastAns = 0;
        
        int Q = sn.nextInt();
        
        if(N >= 1 && N <= 100000 && Q >= 1 && Q <= 100000){
        while(Q != 0){
            
            int type = sn.nextInt();
            int x = sn.nextInt();
            int y = sn.nextInt();
            //List<Integer> seq;
            
            if((type == 1 || type == 2) && (x >= 0 && x <= Math.pow(10, 9)) && (y >= 0 && y <= Math.pow(10, 9))){
               if(type == 1){
                
                   List<Integer> seq = seqList[(x ^ lastAns) % N];
                   seq.add(y);
                   
               }else if(type == 2){
              
                   List<Integer> seq = seqList[(x ^ lastAns) % N];
                   lastAns = seq.get(y % seq.size());
                   
                  //if(lastAns != 0)
                   System.out.println(lastAns);
               }
            }

            Q--;
        }
      }
    }
}