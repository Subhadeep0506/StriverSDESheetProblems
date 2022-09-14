class StocksIII:
	def maxProfit(self, k: int, prices: List[int]) -> int:
        memo = [[-1 for _ in range(k * 2)] for _ in range(len(prices))]
        n = len(prices)
        
        return self.helper(0, 0, prices, n, k, memo)
    
    def helper(self, index, tran_no, prices, n, k, memo):
        if (index == n or tran_no == k * 2):
            return 0
        
        if (memo[index][tran_no] != -1):
            return memo[index][tran_no]
        
        if (tran_no % 2 == 0): # if we have bought
            memo[index][tran_no] = max(self.helper(index + 1, tran_no + 1, prices, n, k, memo) - prices[index], 
                                       self.helper(index + 1, tran_no, prices, n, k, memo))
            
        else: # If we have sold
            memo[index][tran_no] = max(self.helper(index + 1, tran_no, prices, n, k, memo), 
                                      prices[index] + self.helper(index + 1, tran_no + 1, prices, n, k, memo))
            
        return memo[index][tran_no]