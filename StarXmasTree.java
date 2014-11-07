package practice.sort;

import java.util.Scanner;

public class StarXmasTree {

	public static void main(String[] args) {
		System.out.println("Enter the number of lines in the tree: ");
		final Scanner sn = new Scanner(System.in);
		final int num = sn.nextInt();
		printStarTree(num);
	}

	public static void printStarTree(int num) {
		for (int i = 1; i <= num; i++) {

			int space = num - i;

			int numOfStars = i;
			while (space != 0) {
				System.out.print(" ");
				space--;
			}
			while (numOfStars != 0) {
				System.out.print("*");

				System.out.print(" ");
				numOfStars--;
			}

			System.out.println("");

		}
	}

}
