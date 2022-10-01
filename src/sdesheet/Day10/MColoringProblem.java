/*
 * Given an undirected graph and a number m, determine if the graph can be colored with at most m 
 * colors such that no two adjacent vertices of the graph are colored with the same color.
 * 
 * Input: 
 * N = 4
 * M = 3
 * E = 5
 * Edges[] = { (0, 1), (1, 2), (2, 3), (3, 0), (0, 2)}
 * Output: true
 */

package sdesheet.Day10;

import java.util.*;

public class MColoringProblem {
	public static boolean graphColoring(List<Integer>[] graph, int[] color, int i, int C) {
        int n = graph.length;

        if (solve(i, graph, color, n, C)) 
            return true;
        
        return false;
    }
    private static boolean isSafe(int node, List<Integer>[] graph, int[] color, int n, int col) {
        for (int i: graph[node]) {
            if (color[i] == col) 
                return false;
        }
        return true;
    }
    private static boolean solve(int node, List<Integer>[] graph, int[] color, int n, int m) {
        if (node == n) 
            return true;

        for (int i = 1; i <= m; i++) {
            if (isSafe(node, graph, color, n, i)) {
                color[node] = i;
                if (solve(node + 1, graph, color, n, m)) 
                    return true;
                color[node] = 0;
            }
        }
        return false;
    }
}