from typing import List


class TwoSum:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        num_map = {}
        for i, n in enumerate(nums):
            if target - n in num_map:
                return [i, num_map[target - n]]
            num_map[n] = i
        return []