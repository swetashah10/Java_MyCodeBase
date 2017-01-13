
public class ReverseString {
	
	public static void main(String args[]){
		reverseString("Sweta");
		reverseString("");
		reverseString("A");
	}
	public static void reverseString(String actualString){

		 // actualString size = 0 or 1:
		 if(actualString.length() == 0 || actualString.length() == 1)
		   System.out.println("Invalid length to reverse a string: "+actualString);
		 
		 StringBuilder sb = new StringBuilder();
		 for(int i=actualString.length()-1; i>=0; i--){
		   sb.append(actualString.charAt(i));
		 }
		 
		 System.out.println("Reverse: "+sb.toString());
		}
}
