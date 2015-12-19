package TopCoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/* Problem statement: 
*/
public class EmoticonsDiv2 {

	public static void main(String args[]) {
		final EmoticonsDiv2 myClass = new EmoticonsDiv2();
		System.out.println("Enter the number of emoticons: ");
		final Scanner sn = new Scanner(System.in);
		final int smiles = sn.nextInt();
		System.out.println("Least time to display " + smiles + " emoticons is "
				+ myClass.printSmiles(smiles));
	}

	public int printSmiles(int smiles) {
		int time = 0;
		final List<Integer> primeFactors = new ArrayList<Integer>();
		// Include only number range from 2 to 1000.
		if (smiles > 1 && smiles <= 1000) {
			for (int i = 2; i <= smiles; i++) {
				if (smiles % i == 0) {
					primeFactors.add(i);
					smiles = smiles / i;
					i--;
				}
			}
		}
		// The prime factors of the number represents the number of copy paste
		// operations to be carried out.
		// Hence the summation is done to realize number of seconds taken to
		// paste the emoticons.
		for (final Integer i : primeFactors) {
			time = time + i;
		}
		return time;
	}
}
