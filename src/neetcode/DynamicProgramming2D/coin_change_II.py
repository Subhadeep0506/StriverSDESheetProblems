from typing import List


class CoinChangeII:
    def change(self, amount: int, coins: List[int]) -> int:
        cache = {}

        def dfs(index, curr_amount):
            if curr_amount == amount:
                return 1
            if curr_amount > amount or index == len(coins):
                return 0
            if (index, curr_amount) in cache:
                return cache[(index, curr_amount)]

            cache[(index, curr_amount)] = dfs(index, curr_amount + coins[index]) + dfs(index + 1, curr_amount)
            return cache[(index, curr_amount)]

        return dfs(0, 0)
    
    # Tabulation
    def changeTabu(self, amount: int, coins: List[int]) -> int:
        dp = [[0] * (len(coins) + 1) for _ in range(amount + 1)]
        dp[0] = [1] * (len(coins) + 1)

        for a in range(1, amount + 1):
            for i in range(len(coins) - 1, -1, -1):
                dp[a][i] = dp[a][i + 1]
                if a - coins[i] >= 0:
                    dp[a][i] += dp[a - coins[i]][i]
        return dp[amount][0]