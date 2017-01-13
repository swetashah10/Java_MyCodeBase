import java.util.HashMap;
import java.util.Map;


public class AnagramPractice {

	
	public static void main(String[] args){
		
		boolean x = isAnagram("sweta shah","helo");
		System.out.println(x);
	}
	public static Map<Character, Integer> mapTheWord(String str){

		  Map<Character, Integer> mapOfCharsInWord = new HashMap<Character, Integer>();
		    
		    for(int i=0; i<str.length(); i++){
		      
		      if(mapOfCharsInWord.containsKey(str.charAt(i)))
		         mapOfCharsInWord.put(str.charAt(i), mapOfCharsInWord.get(str.charAt(i))+1);
		      else{
		         mapOfCharsInWord.put(str.charAt(i), 1);
		      }
		    }
 return mapOfCharsInWord;
		}
		public static boolean isAnagram(String str1, String str2){
		  
		  // first check the lengths of strings are equal? 
		  if(str1.length() != str2.length())
		    return false;
		  
		  else{
		    
		    Map<Character, Integer> m1 = mapTheWord(str1);
		    Map<Character, Integer> m2 = mapTheWord(str2);
		    
		    for(int i=0; i<str1.length(); i++){
		    
		      if(m1.get(str1.charAt(i)) != m2.get(str1.charAt(i)))
		         return false;
		      
		    }
		    
		    return true;
		    
		  }

		}
}
