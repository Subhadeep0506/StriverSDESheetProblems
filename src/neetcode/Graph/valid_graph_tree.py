"""
https://www.lintcode.com/problem/178/
Given n nodes labeled from 0 to n - 1 and a list of undirected edges 
(each edge is a pair of nodes), write a function to check whether these edges 
make up a valid tree.

examples:
Input: n = 5 edges = [[0, 1], [0, 2], [0, 3], [1, 4]]
Output: true.
          0
        / | \
       1  2  3
       |
       4

Input: n = 5 edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]]
Output: false.
          0
        /
       1--4 
       |\
       | \
       2--3
"""

from typing import List


class ValidGraphTree:
    def valid_tree(self, n: int, edges: List[List[int]]) -> bool:
        # If it is a empty graph, then it is also a tree, so return true
        if not n:
            return True

        # Create an adjacency list for each node from 0 to n - 1
        adj = {i : [] for i in range(n)}
        # Visited set to store the visited nodes
        visited = set()
        # Map each node to their neighbors
        for n1, n2 in edges:
            adj[n1].append(n2)
            adj[n2].append(n1)

        def dfs(i, prev):
            # If current node is already visited, return false
            if i in visited:
                return False
            # Node is visited, so add it to visited set
            visited.add(i)

            # Now, for each neighbors of the current node
            for j in adj[i]:
                # If that neighbor is previous node, then continue
                if j == prev:
                    continue
                # If Current path forms a cycle return false
                if not dfs(j, i):
                    return False
            # Else return true
            return True
        # If Graph has no cycles and all the nodes were visited, return True
        return dfs(0, -1) and n == len(visited)