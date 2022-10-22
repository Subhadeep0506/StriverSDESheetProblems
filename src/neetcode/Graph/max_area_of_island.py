from typing import List

class MaxAreaOfIsland:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        ROW, COL = len(grid), len(grid[0])
        visited = set()

        def dfs(row, col):
            if (row < 0 or row == ROW or col < 0 or col == COL or
                grid[row][col] == 0 or (row, col) in visited):
                return 0

            visited.add((row, col))
            return (1 + dfs(row + 1, col) +
                        dfs(row - 1, col) +
                        dfs(row, col + 1) +
                        dfs(row, col - 1))
        
        area = 0
        for row in range(ROW):
            for col in range(COL):
                area = max(area, dfs(row, col))
        
        return area