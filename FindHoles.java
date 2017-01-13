import java.util.HashMap;
import java.util.Map;


public class FindHoles {

	public static void main(String[] args){
		
	   
  
	}
	
	public static int solvePuzzle(int num){
		int count = 0;
		
		Map<Character, Integer> mapOfNums = new HashMap<Character, Integer>();
		   
		   mapOfNums.put('1', 0);
		   mapOfNums.put('2', 0);
		   mapOfNums.put('3', 0);
		   mapOfNums.put('5', 0);
		   mapOfNums.put('7', 0);
		   mapOfNums.put('0', 1);
		   mapOfNums.put('4', 1);
		   mapOfNums.put('6', 1);
		   mapOfNums.put('9', 1);
		   mapOfNums.put('8', 2);
		   
		char[] chars = ("" + num).toCharArray();
		
		for(char c: chars){
			if(mapOfNums.containsKey(c)){
				count = count+mapOfNums.get(c);
			}
		}
		return count;
	}
}
