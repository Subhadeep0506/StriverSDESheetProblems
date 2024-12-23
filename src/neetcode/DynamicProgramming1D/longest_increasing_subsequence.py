from typing import *


class LongestIncreasingSubsequence:
    def lengthOfLIS(self, nums: List[int]) -> int:
        dp = [1] * len(nums)
        size = len(nums)
        for i in range(size - 1, -1, -1):
            for j in range(i + 1, size):
                if nums[i] < nums[j]:
                    dp[i] = max(dp[i], dp[j] + 1)
        return max(dp)