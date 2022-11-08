import collections
from typing import List


class WallsAndGates:
    def walls_and_gates(self, rooms: List[List[int]]):
        rows, cols = len(rooms),len(rooms[0])
        visited = set()
        queue = collections.deque()

        def addRoom(row, col):
            if (row < 0 or col < 0 or row == rows or col == cols or
                rooms[row][col] == -1 or (row, col) in visited):
                return
            
            visited.add((row, col))
            queue.append([row, col])
        
        for row in range(rows):
            for col in range(cols):
                # If room is a gate, add it to queue, and mark it visited
                if rooms[row][col] == 0:
                    queue.append([row, col])
                    visited.add((row, col))
        
        distance = 0
        while queue:
            for _ in range(len(queue)):
                row, col = queue.popleft()
                rooms[row][col] = distance
                addRoom(row + 1, col)
                addRoom(row - 1, col)
                addRoom(row, col + 1)
                addRoom(row, col - 1)

            distance += 1