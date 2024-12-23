from typing import List


class MaximumProductSubarray:
    def maxProduct(self, nums: List[int]) -> int:
        res = max(nums)
        currmin, currmax = 1, 1
        
        for n in nums:
            if n == 0:
                currmin, currmax = 1, 1
                continue
            temp = n * currmax
            currmax = max(n, temp, n * currmin)
            currmin = min(n, temp, n * currmin)
            res = max(currmax, currmin, res)
        
        return res