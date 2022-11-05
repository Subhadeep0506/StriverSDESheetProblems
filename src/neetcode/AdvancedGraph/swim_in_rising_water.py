import heapq
from typing import List


class SwimInRisingWater:
    def swimInWater(self, grid: List[List[int]]) -> int:
        size = len(grid)
        visited = set()
        minheap = [[grid[0][0], 0, 0]] # (maxheight upto this point, curr row, curr col)
        direc = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        while minheap:
            t, r, c = heapq.heappop(minheap)
            if r == size - 1 and c == size - 1:
                return t
            for dr, dc in direc:
                row, col = r + dr, c + dc
                if (row < 0 or col < 0 or 
                    row == size or col == size or 
                    (row, col) in visited):
                    continue
                visited.add((row, col))
                heapq.heappush(minheap, [max(t, grid[row][col]), row, col])
        return -1