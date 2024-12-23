from typing import List


class BuyAndSellStockWithCooldown:
    def maxProfit(self, prices: List[int]) -> int:
        dp = {}

        def dfs(index, isBuying):
            if index >= len(prices):
                return 0
            if (index, isBuying) in dp:
                return dp[(index, isBuying)]

            if isBuying:
                buy = dfs(index + 1, not isBuying) - prices[index]
            else:
                buy = dfs(index + 2, not isBuying) + prices[index]
            cooldown = dfs(index + 1, isBuying)
            dp[(index, isBuying)] = max(buy, cooldown)
            return dp[(index, isBuying)]

        return dfs(0, True)
