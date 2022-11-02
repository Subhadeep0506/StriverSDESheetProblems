from typing import List


class LongestConsecutiveSequence:
    def longestConsecutive(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        nums = sorted(set(nums))
        longest = 0
        curr = 0
        for i in range(1, len(nums)):
            if nums[i - 1] == nums[i] - 1:
                curr += 1
            else:
                curr = 0    
            longest = max(curr, longest)
        return longest + 1

    # Method 2-----------------------------
    def longestConsecutive2(self, nums: List[int]) -> int:
        # make a set of the given List
        numset = set(nums)
        longest = 0
        # Run for each number in set
        for num in nums:
            # If the number's previous number dont exist in the list, 
            if (num - 1) not in numset:
                length = 0
                while (num + length) in numset:
                    length += 1
                
                longest = max(length, longest)
        
        return longest    