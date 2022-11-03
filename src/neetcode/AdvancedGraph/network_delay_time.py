from typing import List
import collections
import heapq


class NetworkDelayTime:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        edges = collections.defaultdict(list)
        # Make a adjacency list for nodes with their edge weights
        for u, v, w in times:
            edges[u].append((v, w))
        
        # Minheap to store neighbors. Neighbors with least weights are chosen forst
        minheap = [(0, k)] # [weight, node]
        visited = set()
        res = 0

        while minheap:
            # pop the closest neighbor
            w, nod = heapq.heappop(minheap)
            # If the node is already visited, continue
            if nod in visited:
                continue
            # Else add it to visited
            visited.add(nod)
            # Add the weight to result
            res = w

            # Now for each neighbors of current node
            for node, weight in edges[nod]:
                # If the neighbor is not visited, add it to heap
                if node not in visited:
                    heapq.heappush(minheap, (weight + w, node))
        return res if len(visited) == n else -1