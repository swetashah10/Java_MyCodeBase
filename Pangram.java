import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Pangram {

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        String str = sn.nextLine();
        str = str.toLowerCase();
        Map<Character, Boolean> mapOfChars = new HashMap<Character, Boolean>();
        for(int i=97; i<123; i++){
            mapOfChars.put((char)i, false);
        }
        
        System.out.println(mapOfChars);
        for(int i=0; i<str.length(); i++){
            if(mapOfChars.containsKey(str.charAt(i)) && mapOfChars.get(str.charAt(i)) == false){
                mapOfChars.put(str.charAt(i), true);
            }
        }
        System.out.println(mapOfChars);
        if(mapOfChars.containsValue(false))
            System.out.println("not pangram");
        else
            System.out.println("pangram");
        
        sn.close();
    }
}