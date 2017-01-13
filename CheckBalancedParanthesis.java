import java.util.Scanner;
import java.util.Stack;


public class CheckBalancedParanthesis {

	public static boolean isBalanced(char[] arr){
		
		if(arr.length == 0)
			return false;
		
		int count = 0;
		Stack<Character> stackOfChars = new Stack<Character>();
		for(int i=0; i<arr.length; i++){
			
			if(arr[i] == '(' || arr[i] == '{' || arr[i] == '['){
			
			stackOfChars.push(arr[i]);
			count++;
		}else if(arr[i] == ')'){
			
			if(stackOfChars.peek() == '('){
				stackOfChars.pop();
				count -- ;
			}else 
				return false;
		}else if(arr[i] == '}'){
			
			if(stackOfChars.peek() == '{'){
				stackOfChars.pop();
				count -- ;
			}else 
				return false;
		}else if(arr[i] == ']'){
			
			if(stackOfChars.peek() == '['){
					stackOfChars.pop();
					count -- ;
				}else 
					return false;
			}
	}
		
		if(count > 0)
			return false;
		else
			return true;
   }
	
	public static void main(String[] args){
		
		Scanner sn = new Scanner(System.in);
		String N = sn.next();
		char[] arr = new char[N.length()];
		for(int i=0; i<N.length(); i++){
			arr[i] = N.charAt(i);
			
		}
		
		System.out.println(isBalanced(arr)? "YES" : "NO");
		
	}
}