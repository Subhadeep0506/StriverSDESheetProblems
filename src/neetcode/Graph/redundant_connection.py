from typing import List


class RedundantConnection:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        par = [i for i in range(len(edges) + 1)]
        ranks = [1] * (len(edges) + 1)

        def findParent(n):
            p = par[n]
            while p != par[p]:
                par[p] = par[par[p]]
                p = par[p]
            return p
        
        def union(n1, n2):
            p1, p2 = findParent(n1), findParent(n2)
            if p1 == p2:
                return False

            if ranks[p1] > ranks[p2]:
                par[p2] = p1
                ranks[p1] += ranks[p2]
            else:
                par[p1] = p2
                ranks[p2] += ranks[p1]
            return True
        
        for n1, n2 in edges:
            if not union(n1, n2):
                return [n1, n2]
        
        return []