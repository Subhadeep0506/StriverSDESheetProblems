/*
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise)
 * 
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly
 * 
 * DO NOT allocate another 2D matrix and do the rotation.
 */

package com.example.sdesheet.Day02;

public class RotateMatrix {
    int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
    public static void main(String[] args) {
        RotateMatrix obj = new RotateMatrix();
        rotate(obj.matrix);

        for (int row[] : obj.matrix) {
            for (int num: row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void rotate(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        // 1st transpose the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = i; j < cols; j++) {
                swap(matrix, i, j, j, i);
            }
        }
        // 2nd reverse each row 
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols / 2; j++) {
                swap(matrix, i, j, i, rows - 1 - j);
            }
        }
    }
    
    public static void swap(int[][] matrix, int i, int j, int p, int m) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[p][m];
        matrix[p][m] = temp;
    }
}
