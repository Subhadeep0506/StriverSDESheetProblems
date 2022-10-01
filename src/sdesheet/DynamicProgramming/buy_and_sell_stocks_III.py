from typing import List

class StocksIII:
	def maxProfitMemo(self, prices: List[int]) -> int:
        memo = [[[-1 for _ in range(3)] for _ in range(2)] for _ in range(len(prices))]
        
        return self.helper(0, 1, 2, prices, memo)
    
    
    def helper(self, index, buy, capacity, prices, memo):
        if (index == len(prices) or capacity == 0):
            return 0
        
        if (memo[index][buy][capacity] != -1):
            return memo[index][buy][capacity]
        
        if (buy == 1):
            memo[index][buy][capacity] = max(self.helper(index + 1, 0, capacity, prices, memo) - prices[index], 
                                             self.helper(index + 1, 1 ,capacity, prices, memo))
            
        else:
            memo[index][buy][capacity] = max(self.helper(index + 1, 0, capacity, prices, memo), 
                                             prices[index] + self.helper(index + 1, 1, capacity - 1, prices, memo));
            
        return memo[index][buy][capacity]

    # ---------------------------------Different Approach----------------------------------------
	def maxProfit(self, prices: List[int]) -> int:
        buy_one = float("inf")
        profit_one = 0
        buy_two = float("inf")
        profit_two = 0
        
        for price in prices:
            buy_one = min(buy_one, price)
            profit_one = max(profit_one, price - buy_one)
            buy_two = min(buy_two, price - profit_one)
            profit_two = max(profit_two, price - buy_two)
            
        return profit_two
