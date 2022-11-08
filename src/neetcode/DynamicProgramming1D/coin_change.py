"""
coins: [1,3,4,5], 
amount = 7
dp = [inf,inf,inf,inf,inf,inf,inf]
for each amount from 1 to amount, dp[amount] = min(dp[amount], 1 + dp[amount - coin])
dp[0] = 0
dp[1] = 1 -> min(dp[1], dp[1 - 1] + 1) = 1
dp[2] = 2
.
.
.
dp[7] = 1 + dp[7 - 1] = 1 + dp[6]
        1 + dp[7 - 3] = 1 + dp[4] 
        1 + dp[7 - 4] = 1 + dp[3] 
        1 + dp[7 - 5] = 1 + dp[2]
        ... and chose the minimum of these 
"""

from typing import List


class CoinChange:
    def coinChange(self, coins: List[int], amount: int) -> int:
        memo = [float("inf")] * (amount + 1)

        memo[0] = 0

        for amnt in range(1, amount + 1):
            for coin in coins:
                if amnt - coin >= 0:
                    memo[amnt] = min(memo[amnt], memo[amnt - coin] + 1)

        return memo[amount] if memo[amount] != float("inf") else -1