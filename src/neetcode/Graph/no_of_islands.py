import collections
from typing import List

class NoOfIslands:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0
        
        count = 0
        rows, cols = len(grid), len(grid[0])
        self.visited = set()


        def bfs(row, col):
            queue = collections.deque()
            self.visited.add((row, col))
            queue.append((row, col))

            while queue:
                r, c = queue.pop()
                directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]

                for dr, dc in directions:
                    row, col = r + dr, c + dc
                    if ((row) in range(rows) and (col) in range(cols) and
                        grid[row][col] == '1' and (row, col) not in self.visited):
                        queue.append((row, col))
                        self.visited.add((row, col)) 


        for row in range(rows):
            for col in range(cols):
                if grid[row][col] == '1' and (row, col) not in self.visited:
                    bfs(row, col)
                    count += 1
        
        return count