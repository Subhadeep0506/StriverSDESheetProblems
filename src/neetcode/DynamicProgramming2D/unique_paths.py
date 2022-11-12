class UniquePaths:
    def uniquePaths(self, m: int, n: int) -> int:
        memo = [[-1] * n] * m

        for i in range(m):
            memo[i][0] = 1
        for i in range(n):
            memo[0][i] = 1

        for row in range(1, m):
            for col in range(1, n):
                memo[row][col] = memo[row - 1][col] + memo[row][col - 1]
        
        return memo[m - 1][n - 1]