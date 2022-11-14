"""
Given an m x n integers matrix, return the length of the longest increasing path in matrix.

From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary

Input: matrix = [[9,9,4],
                 [6,6,8],
                 [2,1,1]]
Output: 4
Explanation: The longest increasing path is [1, 2, 6, 9].

Input: matrix = [[3,4,5],
                 [3,2,6],
                 [2,2,1]]
Output: 4
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
"""


from typing import List


class LongestIncreasingPathInMatrix:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        rows, cols = len(matrix), len(matrix[0])

        dp = {} # {(row, col): -> LIP}

        def dfs(row, col, prev):
            if (row < 0 or row >= rows or col < 0 or col >= cols or
                matrix[row][col] <= prev):
                return 0
            if (row, col) in dp:
                return dp[(row, col)]
            
            res = 1
            res = max(res, 1 + dfs(row + 1, col, matrix[row][col]))
            res = max(res, 1 + dfs(row - 1, col, matrix[row][col]))
            res = max(res, 1 + dfs(row, col + 1, matrix[row][col]))
            res = max(res, 1 + dfs(row, col - 1, matrix[row][col]))
            dp[(row, col)] = res
            return res

        for row in range(rows):
            for col in range(cols):
                dfs(row, col, -1)
        
        return max(dp.values())