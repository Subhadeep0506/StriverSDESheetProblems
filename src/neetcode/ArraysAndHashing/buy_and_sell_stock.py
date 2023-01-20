from typing import List


class BuyAndSellStockII:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        for i in range(1, len(prices)):
            if prices[i] > prices[i - 1]:
                profit += (prices[i] - prices[i - 1])

        return profit


class BuyAndSellStock:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        buy = prices[0]
        for i, price in enumerate(prices[1:]):
            buy = min(buy, price)
            profit = max(profit, price - buy)
        return profit


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
