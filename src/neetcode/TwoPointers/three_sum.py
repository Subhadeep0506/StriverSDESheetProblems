"""
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.
"""


from typing import List


class ThreeSum:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        res = []
        nums.sort()
        size = len(nums)
        for i in range(size - 2):
            if i > 0 and nums[i - 1] == nums[i]:
                continue
            first = nums[i]
            l, r = i + 1, size - 1
            while l < r:
                curr = nums[l] + nums[r] + first
                if curr < 0:
                    l += 1
                elif curr > 0:
                    r -= 1
                else:
                    res.append([first, nums[l], nums[r]])
                    l += 1
                    while nums[l] == nums[l - 1] and l < r:
                        l += 1
        return res

"""
for [-3, 0, 2, -3, 2, 1]... we sort it -> [-3, -3, 0, 1, 2, 2]
we take each elemnt from first till 3rd last, and combine with other 2
"""