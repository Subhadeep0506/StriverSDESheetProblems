from typing import List


class PartitionEqualSubsetSum:
    def canPartition(self, nums: List[int]) -> bool:
        if sum(nums) % 2 != 0:
            return False
        dp =set()
        dp.add(0)
        target = sum(nums) // 2

        for i in range(len(nums) - 1, -1, -1):
            next = set()
            for t in dp:
                next.add(t + nums[i])
                next.add(t)
            dp = next
        return True if target in dp else False
