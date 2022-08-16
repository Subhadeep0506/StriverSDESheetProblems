/*
	The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

	Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

	Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

	Input: n = 4
	Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
*/

package com.example.sdesheet.Day10;

import java.util.*;

public class NQueensI {
	public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        
        List<List<String>> res = new ArrayList<>();
        helper(0, board, res);
        return res;
    }
    
    public void helper(int col, char[][] board, List<List<String>> res) {
        int len = board.length;
        if (col == len) {
            res.add(construct(board));
            return;
        }
        
        for (int row = 0; row < board.length; row++) {
            if (validateBoard(board, row, col)) {
                board[row][col] = 'Q';
                helper(col + 1, board, res);
                board[row][col] = '.';
            }
        }
    }
    
    public boolean validateBoard(char[][] board, int row, int col) {
        int r = row, c = col;
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q')
                return false;
            row--;
            col--;
        }
        
        row = r; col = c;
        while (col >= 0) {
            if (board[row][col] == 'Q')
                return false;
            col--;
        }
        
        row = r; col = c;
        while (col >= 0 && row < board.length) {
            if (board[row][col] == 'Q')
                return false;
            row++;
            col--;
        }
        return true;
    }
    
    public List<String> construct(char[][] board) {
        List<String> ds = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            ds.add(s);
        }
        
        return ds;
    }
}