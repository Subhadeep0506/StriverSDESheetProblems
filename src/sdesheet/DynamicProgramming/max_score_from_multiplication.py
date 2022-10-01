# https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/submissions/

class MaxScoreFromMultiplication:
	# ======================= Memoization ====================================
	def maximumScore(self, nums: List[int], multipliers: List[int]) -> int:        
        n = len(nums)
        m = len(multipliers)
        
        memo = [[-1 for _ in range(m)] for _ in range(m)]
        
        return self.helper(0, 0, nums, multipliers, memo)
    
    def helper(self, n, m, nums, multipliers, memo):
        if (m == len(multipliers)):
            return 0
        
        if memo[n][m] != -1:
            return memo[n][m]
        
        left = self.helper(n + 1, m + 1, nums, multipliers, memo) + nums[n] * multipliers[m]
        right = self.helper(n, m + 1, nums, multipliers, memo) + nums[len(nums) - (m - n) - 1] * multipliers[m]
        
        memo[n][m] = max(left, right)
        return memo[n][m]

    # ====================== Tabulation =====================================
    def maximumScore(self, nums: List[int], multipliers: List[int]) -> int:
        n, m = len(nums), len(multipliers)
        dp = [[0]*m for _ in range(m+1)]
        
        for i in range(m - 1, -1, -1):
            for j in range(i, m): 
                k = i + m - j - 1
                dp[i][j] = max(nums[i] * multipliers[k] + dp[i + 1][j], 
                               nums[j - m + n] * multipliers[k] + dp[i][j - 1])
        
        return dp[0][-1]