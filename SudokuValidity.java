package practice.sort;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SudokuValidity {
	// Check the validity of a given sudoku.
	// Input - 9x9 array with all filled values
	// Output - boolean true if sudoku is valid, else false
	
	public static void main(String args[]) {

		final int[][] sudokuFilled = new int[9][9];
		System.out.println("Please enter the filled sudoku");
		final Scanner sn = new Scanner(System.in);
		while (sn.hasNextInt()) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sudokuFilled[i][j] = sn.nextInt();
				}
			}
		}

		checkIfSudokuValid(sudokuFilled);
	}

	public static void checkIfSudokuValid(int[][] sudokuFilled) {

		boolean isSudokuRowColValid = false;
		boolean isSudokuGridsValid = false;
		final Set<Integer> grid1Set = new HashSet<Integer>();
		final Set<Integer> grid2Set = new HashSet<Integer>();
		final Set<Integer> grid3Set = new HashSet<Integer>();
		final Set<Integer> grid4Set = new HashSet<Integer>();
		final Set<Integer> grid5Set = new HashSet<Integer>();
		final Set<Integer> grid6Set = new HashSet<Integer>();
		final Set<Integer> grid7Set = new HashSet<Integer>();
		final Set<Integer> grid8Set = new HashSet<Integer>();
		final Set<Integer> grid9Set = new HashSet<Integer>();
		for (int i = 0; i < 9; i++) {
			final Set<Integer> rowSet = new HashSet<Integer>();
			final Set<Integer> colSet = new HashSet<Integer>();

			for (int j = 0; j < 9; j++) {
				if (sudokuFilled[i][j] <= 9 && sudokuFilled[i][j] > 0) {
					rowSet.add(sudokuFilled[i][j]);
				}
				if (sudokuFilled[j][i] <= 9 && sudokuFilled[j][i] > 0) {
					colSet.add(sudokuFilled[j][i]);
				}
				if ((i >= 0 && i < 3) && (j >= 0 && j < 3)) {
					grid1Set.add(sudokuFilled[i][j]);
				}
				if ((i >= 3 && i < 6) && (j >= 3 && j < 6)) {
					grid5Set.add(sudokuFilled[i][j]);
				}
				if ((i >= 6 && i < 9) && (j >= 6 && j < 9)) {
					grid9Set.add(sudokuFilled[i][j]);
				}
				if ((i >= 0 && i < 3) && (j >= 3 && j < 6)) {
					grid4Set.add(sudokuFilled[i][j]);
					grid2Set.add(sudokuFilled[j][i]);
				}
				if ((i >= 6 && i < 9) && (j >= 0 && j < 3)) {
					grid3Set.add(sudokuFilled[i][j]);
					grid7Set.add(sudokuFilled[j][i]);
				}
				if ((i >= 6 && i < 9) && (j >= 3 && j < 6)) {
					grid6Set.add(sudokuFilled[i][j]);
					grid8Set.add(sudokuFilled[j][i]);
				}
			}
			if (rowSet.size() != 9 || colSet.size() != 9) {
				isSudokuRowColValid = false;
				break;
			} else {
				isSudokuRowColValid = true;
			}
		}

		if (grid1Set.size() == 9 && grid2Set.size() == 9
				&& grid3Set.size() == 9 && grid4Set.size() == 9
				&& grid5Set.size() == 9 && grid6Set.size() == 9
				&& grid7Set.size() == 9 && grid8Set.size() == 9
				&& grid9Set.size() == 9) {
			isSudokuGridsValid = true;
		}
		if (isSudokuRowColValid && isSudokuGridsValid) {
			System.out.println("This Sudoku is valid.");
		} else {
			System.out.println("This Sudoku is invalid.");
		}
	}
}
