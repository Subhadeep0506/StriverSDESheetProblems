from typing import List

class OceanWaterflow:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        rows, cols = len(heights), len(heights[0])
        
        pacific, atlantic = set(), set()

        def dfs(row, col, visited, prev_height):
            if ((row, col) in visited or 
                row < 0 or col < 0 or row == rows or col == cols
                or heights[row][col] < prev_height):
                return
            visited.add((row, col))
            curr_height = heights[row][col]
            dfs(row + 1, col, visited, curr_height)
            dfs(row - 1, col, visited, curr_height)
            dfs(row, col + 1, visited, curr_height)
            dfs(row, col - 1, visited, curr_height)

        for c in range(cols):
            dfs(0, c, pacific, heights[0][c])
            dfs(rows - 1, c, atlantic, heights[rows - 1][c])

        for r in range(rows):
            dfs(r, 0, pacific, heights[r][0])
            dfs(r, cols - 1, atlantic, heights[r][cols - 1])

        res = []

        for r in range(rows):
            for c in range(cols):
                if (r, c) in pacific and (r, c) in atlantic:
                    res.append([r, c])
        return res
