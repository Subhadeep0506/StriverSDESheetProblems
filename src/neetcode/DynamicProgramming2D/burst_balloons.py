from functools import cache
from typing import List


class BurstBalloons:
    def maxCoins(self, nums: List[int]) -> int:
        nums = [1] + nums + [1]
        size = len(nums)
        dp = {}

        def dfs(l, r):
            if l > r:
                return 0
            if (l, r) in dp:
                return dp[(l, r)]
            dp[(l, r)] = 0
            for i in range(l, r + 1):
                coins = nums[l - 1] * nums[i] * nums[r + 1]
                coins += dfs(l, i - 1) + dfs(i + 1, r)
                dp[(l, r)] = max(dp[(l, r)], coins)
            return dp[(l, r)]
        return dfs(1, size - 2)

    def maxCoins(self, nums: List[int]) -> int:
        nums = [1] + nums + [1]
        n = len(nums)
        dp = [[-1]*n for _ in range(n)]
   
        @cache
        def dfs(l,r):
            if l > r:
                return 0
            
            if dp[l][r] != -1:
                return dp[l][r]
            
            #dp[(l,r)] = 0
            
            for i in range(l, r+1):
                coins = nums[l-1] * nums[i] * nums[r+1]
                coins += dfs(i+1,r) + dfs(l, i-1)
                dp[l][r] = max(dp[l][r], coins)
                
            return dp[l][r]
        
        return dfs(1, n - 2)