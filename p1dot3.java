package ctci.ch01;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

// URLify replace spaces in a string with %20 
public class p1dot3 {

	void replaceSpaces(char[] str, int trueLength) {
		
		//count the spaces in the string
		int spaceCount = 0, index, i = 0;
		
		for(i=0;i<trueLength; i++) {
			if(str[i] == ' ') {
				spaceCount++;
			}
		}
		
		index = trueLength + spaceCount*2;
		
		for(i=trueLength-1; i>0; i--) {
			if(str[i] == ' ') {
				str[index - 1] = '0';
				str[index - 2] = '2';
				str[index - 3] = '%';
				index = index - 3;
			}else {
				str[index - 1] = str[i];
				index--;
			}
		}
		
	}
	
	@Test
	public void test1() {
		
		char[] actual = "This is a new string               ".toCharArray();
		char[] expected = "This%20is%20a%20new%20string       ".toCharArray();
		replaceSpaces(actual, 20);
		assertArrayEquals(expected, actual);
	}
}
