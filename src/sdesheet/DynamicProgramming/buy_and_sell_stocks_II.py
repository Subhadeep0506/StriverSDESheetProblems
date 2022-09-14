class Stocks:
    def maxProfitMemo(self, prices: List[int]) -> int:
        n = len(prices)

        # take a memo matrix of size n * 2 and fill it with -1
        memo = [[-1 for _ in range(2)] for _ in range(n)]
        return self.helper(0, True, prices, memo)
        
    def helper(self, index: int, buy: bool, prices: List[int], memo: List[List[int]]) -> int:
        # Base Case:
        # If we have reached the end of the prices list, return 0
        # as we cannot sell stock at that point so no profit
        if (index == len(prices)):
            return 0
        
        # If memo[index][buy] was already visited before, return its value
        if memo[index][buy] != -1:
            return memo[index][buy]
        
        # If we have a stock in hand
        if (buy):
            # we have 2 choice here, either we sell it or dont sell it
            # if we sell it, we need to calculate the profit
            # else we take the profit from not selling it
            # we only consider the one that is max of both cases
            memo[index][buy] = max(self.helper(index + 1, False, prices, memo) - prices[index], 
                                 self.helper(index + 1, True, prices, memo))
        # If we dont have a stock in hand
        else:
            memo[index][buy] = max(self.helper(index + 1, False, prices, memo), 
                                 self.helper(index + 1, True, prices, memo) + prices[index])
        
        return memo[index][buy]
    # -----------------------------Tabulation------------------------------
    
    def maxProfitTabu(self, prices: List[int]) -> int:
        n = len(prices)
        memo = [[-1 for _ in range(2)] for _ in range(n + 1)]
        
        for i in range(2):
            memo[n][i] = 0
        
        for index in range(n - 1, -1, -1):
            for buy in range(2):
                if (buy):
                    memo[index][buy] = max(memo[index + 1][False] - prices[index], 
                                         memo[index + 1][True])
                else:
                    memo[index][buy] = max(memo[index + 1][False], 
                                         memo[index + 1][True] + prices[index])
                
                
        return memo[0][1]
