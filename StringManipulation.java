import java.util.HashMap;
import java.util.Map;

//peaks , geeks => editDistance = 2
//peaks, geek => editDistance = 3

public class StringManipulation {

	public static void main(String args[]) {

		StringManipulation strManipObj = new StringManipulation();
		int editDistance = strManipObj.findEditDistance("peaks", "fleaks");
		System.out.println("The edit distance between 2 strings is: "
				+ editDistance);
	}

	public static void printMap(Map<String, Integer> map){
		System.out.println("Printing the map contents: ");
		for(Map.Entry<String, Integer> elem : map.entrySet()){
			System.out.println(elem.getKey()+"   ==>  "+ elem.getValue());
		}
	}
	public int findEditDistance(String firstString, String secondString) {
		int editDistance = 0;

		// if lengths are equal and the strings are equal , edit distance =0
		if (firstString.length() == secondString.length()
				&& firstString.equalsIgnoreCase(secondString)) {
			System.out.println("Inside and before first return statement");

			return editDistance;
		}

		System.out.println("After first return statement");
		// if lengths are equal and strings are unequal, then compute
		// editDistance using Map
		if (!firstString.equalsIgnoreCase(secondString)) {
			// add the difference between the lengths to editDistance.
			editDistance = Math.abs(firstString.length()
					- secondString.length());

			// Add the elements and number of occurrences in the Map
			Map<String, Integer> mapOfElements = new HashMap<String, Integer>();
			int i = 0;
			while (i != firstString.length()) {
				char c = firstString.charAt(i);
				if (mapOfElements.containsKey(String.valueOf(c))) {
					int count = mapOfElements.get(String.valueOf(c));
					mapOfElements.put(String.valueOf(c), ++count);
					i++;
				} else {
					mapOfElements.put(String.valueOf(c), 1);
					i++;
				}
			}

			printMap(mapOfElements);
			// Check for all elements in secondString, if there are any
			// non-matching characters.
			for (int j = 0; j < secondString.length(); j++) {
				if (mapOfElements.containsKey(String.valueOf(secondString
						.charAt(j)))) {
					int count = mapOfElements.get(String.valueOf(secondString
							.charAt(j)));
					mapOfElements.put(String.valueOf(secondString.charAt(j)),
							--count);
				} else {
					mapOfElements
							.put(String.valueOf(secondString.charAt(j)), 1);
				}
			}

			printMap(mapOfElements);
			for (Map.Entry<String, Integer> element : mapOfElements.entrySet()) {

				editDistance += element.getValue();
			}
		}

		return editDistance;
	}

}
