/*
	Write a program to solve a Sudoku puzzle by filling the empty cells.

	A sudoku solution must satisfy all of the following rules:

	1. Each of the digits 1-9 must occur exactly once in each row.
	2. Each of the digits 1-9 must occur exactly once in each column.
	3. Each of the digits 1-9 must occur exactly once in each of the 9 
	   3x3 sub-boxes of the grid.
	The '.' character indicates empty cells.
*/

package Day10;

import java.util.*;

public class SolveSudoku {
	public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0)
            return;
        solve(board);
    }
    
    public boolean solve(char[][] board) {
        // Traversing each cell
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                // If we find a cell empty...
                if (board[row][col] == '.') {
                    // ... we will try to fill it with values fro 1 to 9
                    for (char c = '1'; c <= '9'; c++) {
                        // Then check if filling it with the value is 
                        // valid or not
                        if (isValid(board, row, col, c)) {
                            // If it is valid we put the value
                            // in that cell, and solve the rest of the 
                            // sudoku.
                            board[row][col] = c;
                            
                            // If the rest of the sudoku is solvable
                            // we return true
                            if (solve(board))
                                return true;
                            // else we remove the element that was added 
                            // there and continue with other values.
                            else 
                                board[row][col] = '.';
                        }
                    }
                    // We return false if no value was solving the puzzle
                    return false;
                }
            }
        }
        
        // We return true if we reach the end of the sudoku
        // as we were able to solve it
        return true;
    }
    
    public boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c)
                return false;
            if (board[i][col] == c)
                return false;
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
                return false;
        }
        
        return true;
    }
}