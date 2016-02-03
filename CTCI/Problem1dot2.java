package CrackingTheCodingInterview;

import java.util.Stack;

public class Problem1dot2 {

	public static void main(String[] args){
		Problem1dot2 problem1Dot2Obj = new Problem1dot2();
		
		String str = new String("test string"+(null));
		System.out.println("Actual String: "+str+"   Reverse: " +problem1Dot2Obj.reverseString(str));
	}

	private String reverseString(String str) {
		String reverseStr = new String();
		Stack<Character> stackOfChars = new Stack<Character>();
		for(int i=0; i<str.length(); i++){
			stackOfChars.push(str.charAt(i));
		}
		
		for(int i=0; i<str.length(); i++){
			reverseStr+= stackOfChars.pop();
		}
		return reverseStr;
	}
}
