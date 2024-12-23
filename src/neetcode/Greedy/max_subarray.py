from typing import List


class MaximumSubarray:
    def maxSubArray(self, nums: List[int]) -> int:
        sum = 0
        res = nums[0]

        for i in range(0, len(nums)):
            sum += nums[i]
            res = max(res, sum)
            if sum < 0:
                sum = 0
        return res