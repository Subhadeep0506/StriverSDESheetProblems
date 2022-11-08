import collections
from typing import List


class RottenOranges:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        rows, cols = len(grid), len(grid[0])
        fresh, time = 0, 0
        que = collections.deque()

        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == 1:
                    fresh += 1
                if grid[r][c] == 2:
                    que.append([r, c])
        
        directions = [[0, -1], [0, 1], [1, 0], [-1, 0]]
        while que and fresh > 0:
            for i in range(len(que)):
                row, col = que.popleft()
                for dr, dc in directions:
                    r, c = row+ dr, col + dc
                    if (r < 0 or c < 0 or r == rows or c == cols or
                        grid[r][c] != 1):
                        continue
                    
                    grid[r][c] = 2
                    fresh -= 1
                    que.append([r, c])
            time += 1

        return time if fresh == 0 else -1