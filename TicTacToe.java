package practice.sort;

import java.util.Scanner;

public class TicTacToe {
	// Implement a tic tac toe game.
	public static char[][] boardArray = new char[3][3];
	public static boolean gameOver = false;

	public static void initBoard() {

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				boardArray[i][j] = '-';
			}
		}
	}

	public static void printBoard() {

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(boardArray[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void getUserMove() {

		System.out
				.println("Enter your move, by entering x value within 0 - 2 and y value within 0 - 2");
		final Scanner sn = new Scanner(System.in);
		final int x = sn.nextInt();
		final int y = sn.nextInt();
		if (x >= 0 && x < 3 && y >= 0 && y < 3) {
			placeMove(x, y);
		} else {
			System.out.println("Your move is invalid, please choose values between 0 and 2");
			getUserMove();
		}
	}

	public static void placeMove(int x, int y) {

		// Validate the place is empty.
		if (boardArray[x][y] == '-') {
			boardArray[x][y] = 'X';
		} else {
			System.out.println("This place is already filled, please choose some other place.");
			getUserMove();
		}
		checkIfUserWin();
	}

	public static void checkIfUserWin() {
		final char c = 'X';
		if (checkIfAnyRowEqual(c) || checkIfAnyColEqual(c)
				|| checkIfAnyDiagonalEqual(c)) {
			System.out.println("Game over: " + c + " user wins!!");
			gameOver = true;
		}
	}

	public static void checkIfSystemWin() {
		final char c = 'O';
		if (checkIfAnyRowEqual(c) || checkIfAnyColEqual(c)
				|| checkIfAnyDiagonalEqual(c)) {
			System.out.println("Game over: " + c + " system wins!!");
			gameOver = true;
		}
	}

	public static boolean checkIfAnyRowEqual(char c) {

		boolean result = false;
		for (int i = 0; i < 3; i++) {
			int counter = 0;
			for (int j = 0; j < 3; j++) {
				if (boardArray[i][j] == c) {
					counter++;
					if (counter == 3) {
						result = true;
						break;
					}
				}
			}
		}
		return result;
	}

	public static boolean checkIfAnyColEqual(char c) {

		boolean result = false;
		for (int i = 0; i < 3; i++) {
			int counter = 0;
			for (int j = 0; j < 3; j++) {
				if (boardArray[j][i] == c) {
					counter++;
					if (counter == 3) {
						result = true;
						break;
					}
				}
			}
		}
		return result;
	}

	public static boolean checkIfAnyDiagonalEqual(char c) {

		boolean result = false;
		for (int i = 0; i < 3; i++) {
			int counter = 0;
			if (boardArray[i][i] == c) {
				counter++;
				if (counter == 3) {
					result = true;
					break;
				}
			}
		}
		if (boardArray[0][2] == boardArray[1][1]
				&& boardArray[2][0] == boardArray[1][1]
				&& boardArray[1][1] == c) {
			result = true;
		}
		return result;
	}

	public static void placeSystemMove() {

		int flag = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (boardArray[i][j] == '-') {
					boardArray[i][j] = 'O';
					flag = 1;
					break;
				}
			}
			if (flag == 1) {
				break;
			}
		}
		checkIfSystemWin();
	}

	public static void main(String args[]) {

		initBoard();
		printBoard();
		while (gameOver != true) {
			getUserMove();
			printBoard();
			System.out.println();
			placeSystemMove();
			System.out.println();
			printBoard();
		}
		gameOver = false;
		System.out.println("Do you wish to play another game?");
		final Scanner sn2 = new Scanner(System.in);
		if (sn2.next().equalsIgnoreCase("y")) {
			final String[] n = new String[] {};
			main(n);
		} else {
			System.out.println("See you next time!!! ");
			System.exit(1);
		}
	}

}
