"""
https://leetcode.com/problems/number-of-provinces/
You have a graph on `n` nodes. You are given an integer 'n' and an array 'edges'.
Where edges[i] = [ai, bi] indicates that there is a edge between ai and bi, in the graph

Return the no of connected components.

eg: 
0----1      3
     |      |
     |      |
     |      |
     2      4
Here there are 2 connected components
"""
from typing import List


class NumberOfConnectedComponents:
     def countConnectedComponents(self, n: int, edges: List[List[int]]):
          parent = [i for i in range(n)]
          rank = [1] * n

          def find(node):
               res = node

               while node != parent[node]:
                    parent[res] = parent[parent[res]]
                    res = parent[res]
               return res

          def union(n1, n2):
               p1, p2 = find(n1), find(n2)
               if p1 == p2:
                    return 0
               if rank[p1] > rank[p2]:
                    parent[p2] = p1
                    rank[p1] += rank[p2]
               else:
                    parent[p1] = p2
                    rank[p2] += rank[p1]
               return 1

          res = n
          for n1, n2 in edges:
               n -= union(n1, n2)

          return res