import java.util.HashSet;
import java.util.Set;

/**
 * Set up an array of the following musical instruments:

cello
guitar
violin
double bass

Loop round and remove the vowels. Display the new words in a textbox, listbox or console.

 * @author swetashah
 *
 */
public class VowelProg {

	public static void main(String[] args){
		long startTime = System.currentTimeMillis();
		System.out.println("Start time: "+startTime);
		// load the array of strings with the musical instrument names.
		String[] arrayOfInstruments = new String[]{"cello","guitar","violin","double bass","drum","harmonium","piano","mouth organ",
				"selfie","postcard","rivulet","simmer","clash",
				"coal","canvas","carrom","prunes","liver","lavish","spain","egypt"};
		
		// have a set containing all vowels. 
		String vowels = "aeiou";
		
		
		for(int i=0; i< arrayOfInstruments.length; i++){
			
			String instrument = arrayOfInstruments[i];
			StringBuffer strBuf = new StringBuffer();
			for(int j=0; j<instrument.length(); j++){
				String str = String.valueOf(instrument.charAt(j));
				
				if(!vowels.contains(str)){
					strBuf.append(str);
				}
			}
		
			arrayOfInstruments[i] = strBuf.toString();
		}
		
		
		System.out.println("Array of instruments after removal of vowels: ");
		for(String str:arrayOfInstruments){
			System.out.println(str);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("End time: "+endTime);
		System.out.println("Time taken to run this program: "+(endTime - startTime));
	}
}
