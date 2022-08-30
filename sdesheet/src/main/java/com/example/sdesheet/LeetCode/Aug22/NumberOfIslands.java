/*
 * https://leetcode.com/problems/number-of-islands/
 * 
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and 
 * '0's (water), return the number of islands.
 * 
 * An island is surrounded by water and is formed by connecting adjacent lands 
 * horizontally or vertically. You may assume all four edges of the grid are all 
 * surrounded by water.
 */

package com.example.sdesheet.LeetCode.Aug22;

import java.util.*;

class Pair {
    int first;
    int second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        
        boolean[][] vis = new boolean[row][col];
        for (boolean[] r : vis)
            Arrays.fill(r, false);
        
        int di[] = {-1, 0, 1, 0};
        int dj[] = {0, 1, 0, -1};
        
        int count = 0;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!vis[i][j] && grid[i][j] == '1') {
                    count++;
                    bfs(i, j, grid, vis, di, dj);
                }
            }
        }
        
        return count;
    }
    
    private void bfs (int row, int col, char[][] grid, boolean[][] vis, int[] di, int[] dj) {
        int m = grid.length;
        int n = grid[0].length;
        
        // Mark cell as visited
        vis[row][col] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        
        while (!q.isEmpty()) {
            int i = q.peek().first;
            int j = q.peek().second;
            q.poll();
            
            for (int k = 0; k < 4; k++) {
                int nrow = i + di[k];
                int ncol = j + dj[k];
                    
                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n) {
                    if (grid[nrow][ncol] == '1' && !vis[nrow][ncol]) {
                        vis[nrow][ncol] = true;
                        q.add(new Pair(nrow, ncol));
                    }
                }
            }
        }
    }
}
