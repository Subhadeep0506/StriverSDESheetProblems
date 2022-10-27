from typing import List

class HouseRobberII:
    """
    This problem is solved by considering the houses in 2 variations
    First we find the amount robber aquires by robbing houses from index 1 to last
    Then he considers houses from index 0 to second last
    i.e. 1st: 0 to n - 2, then 1 to n - 1
    """
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1:
            return nums[0]
        memo = [-1 for _ in range(n)]
        with_first = self.helper(len(nums[: n - 1]) - 1, nums[: n - 1], memo)
        memo = [-1 for _ in range(n)]
        with_last = self.helper(len(nums[1:]) - 1, nums[1:], memo)
        
        return max(with_first, with_last)
    
    def helper(self, index, nums, memo):
        n = len(nums)
        
        if index < 0:
            return 0
        if index == 0:
            return nums[0]
        
        if memo[index] != -1:
            return memo[index]
        
        take = self.helper(index - 2, nums, memo) + nums[index]
        not_take = self.helper(index - 1, nums, memo)
        
        memo[index] = max(take, not_take)
        return memo[index]
    