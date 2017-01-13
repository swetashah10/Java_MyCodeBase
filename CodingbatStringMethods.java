
public class CodingbatStringMethods {

	public static void main(String args[]){
		CodingbatStringMethods codeClass = new CodingbatStringMethods();
		String str = codeClass.withouEnd2("Hello");
		System.out.println(str);
	}
	
	
	public String withouEnd2(String str) {
		  
		  if(str.length() == 0)
		   return "";
		   
		  if(str.length() == 1 &&  str.length() == 2)
		   return "";
		   
		   String strBuf = new String();
		  if(str.length() > 2){
		  
		  int end = str.length()-1;
		  System.out.println(str + "   --- end: " + end+"  ---- length: "+str.length());
		  System.out.println();
		    strBuf.substring(1,end);
		    System.out.println("strBuf: "+strBuf);
		  
		  }
		  
		  return strBuf;
		}
}
