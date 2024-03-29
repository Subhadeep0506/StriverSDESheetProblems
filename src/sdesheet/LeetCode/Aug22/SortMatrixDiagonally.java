/*
	A matrix diagonal is a diagonal line of cells starting from some cell in either 
    the topmost row or leftmost column and going in the bottom-right direction 
	until reaching the matrix's end. For example, the matrix diagonal starting from 
	mat[2][0], where mat is a 6 x 3 matrix, includes cells mat[2][0], mat[3][1], 
	and mat[4][2].

	Given an m x n matrix mat of integers, sort each matrix diagonal in ascending 
	order and return the resulting matrix.
*/

package sdesheet.LeetCode.Aug22;

import java.util.*;

public class SortMatrixDiagonally {
	public int[][] diagonalSort(int[][] mat) {
        int row = mat.length, col = mat[0].length;
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                map.putIfAbsent(i - j, new PriorityQueue<>());
                map.get(i - j).add(mat[i][j]);
            }
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                mat[i][j] = map.get(i - j).poll();
            }
        }
        
        return mat;
    }
}