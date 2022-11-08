import heapq
from typing import List


class MinCostToConnectPoints:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        size = len(points)
        adj = {i:[] for i in range(size)}

        # Forming an adjacency list for each point and 
        # its distance from it's neighbors
        for i in range(size):
            x1, y1 = points[i]
            # For all other points except current point
            for j in range(i + 1, size):
                x2, y2 = points[j]
                # Get the manhatten detance
                dist = abs(x1 - x2) + abs(y1 - y2)
                # Add the poinnts and their distances
                adj[i].append([dist, j])
                adj[j].append([dist, i])
        
        # Prim's Algo
        res = 0
        visited = set()
        minheap = [[0, 0]] # [cost, point]
        while len(visited) < size:
            # Get the cost and index of closest point
            cost, index = heapq.heappop(minheap)
            # If current points has already been visited, skip it
            if index in visited:
                continue
            res += cost
            visited.add(index)
            # For every neighbors of current point
            for neighbor_cost, neighbor in adj[index]:
                # If the neigbor is not visited, add it to minheap
                if neighbor not in visited:
                    heapq.heappush(minheap, [neighbor_cost, neighbor])

        return res