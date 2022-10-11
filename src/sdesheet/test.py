from collections import defaultdict

def terrorist(N, M, AB):
    n = len(AB)
    G = defaultdict(list)
    for i in range(n):
        for j in range(n):
            if AB[i][j]:
                G[i].append(j)
    def dfs(v):
        if v in visited: return
        visited.add(v)
        for w in G[v]:
            dfs(w)

    visited = set()
    res =  []
    for v in range(n):
        count = 0
        if v not in visited:
            dfs(v)
            count += 1
    return res