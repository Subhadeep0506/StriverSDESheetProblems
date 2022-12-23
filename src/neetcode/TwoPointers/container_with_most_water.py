"""
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.
"""


from typing import List


class ContainerWithMostWater:
    def maxArea(self, height: List[int]) -> int:
        size = len(height)
        l, r = 0, size - 1
        max_vol = 0
        while l < r:
            max_vol = max(max_vol, min(height[l], height[r]) * (r - l))
            if height[l] < height[r]:
                l += 1
            elif height[l] > height[r]:
                r -= 1
            else:
                l += 1
                r -= 1
        return max_vol