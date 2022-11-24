class RegularExpressionMatching:
    def isMatch(self, s: str, p: str) -> bool:

        cache = {}

        def dfs(i, j):
            if (i, j) in cache:
                return cache[(i, j)]
            # If we have exhausted both s and p strings, retrun 
            # true as we have our answer
            if i >= len(s) and j >= len(p):
                return True
            # If the p string is exhausted, return false as we have run out 
            # of room to check s string
            if j >= len(p):
                return False
            
            match = i < len(s) and (s[i] == p[j] or p[j] == '.')

            if (j + 1) < len(p) and p[j + 1] == "*":
                cache[(i, j)] = dfs(i, j + 2) or (match and dfs(i + 1, j))
                return cache[(i, j)]
            
            if match:
                cache[(i, j)] = dfs(i + 1, j + 1)
                return cache[(i, j)]
            cache[(i, j)] = False
            return False

        return dfs(0, 0)