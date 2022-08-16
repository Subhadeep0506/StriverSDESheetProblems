package com.example.sdesheet.Day10;

import java.util.*;

public class RatInMaze {
    private static void solve(int row, int col, int a[][], int n, ArrayList<String> ans, String move, int visited[][], int di[], int dj[]) {
        if (row == n - 1 && col == n - 1) {
            ans.add(move);
            return;
        }
        String dir = "DLRU";
        for (int ind = 0; ind < 4; ind++) {
            int nextRow = row + di[ind];
            int nextCol = col + dj[ind];
            if (nextRow >= 0 && nextCol >= 0 && nextRow < n && nextCol < n &&
                    visited[nextRow][nextCol] == 0 && a[nextRow][nextCol] == 1) {

                visited[row][col] = 1;
                solve(nextRow, nextCol, a, n, ans, move + dir.charAt(ind), visited, di, dj);
                visited[row][col] = 0;

            }
        }
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        int visited[][] = new int[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                visited[row][col] = 0;
            }
        }
        int di[] = {1, 0, 0, -1};
        int dj[] = {0, -1, 1, 0};
        ArrayList<String> ans = new ArrayList<>();
        if (m[0][0] == 1)
            solve(0, 0, m, n, ans, "", visited, di, dj);
        return ans;
    }

}
