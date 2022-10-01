from typing import *

class LargestRectangleInHistogram:
	def largestRectangleArea(self, heights: List[int]) -> int:
        suffix = [] # to store left smaller element index
        prefix = [] # to store right smaller element index
        
        stack = []
        size = len(heights)
        
        for i in range(size):
            while stack != [] and heights[stack[-1]] >= heights[i]:
                stack.pop()
                
            if stack == []:
                suffix.append(0)
            else:
                suffix.append(stack[-1] + 1)
            stack.append(i)
        
        stack = []
        for i in range(size - 1, -1, -1):
            while stack != [] and heights[stack[-1]] >= heights[i]:
                stack.pop()
            
            if stack == []:
                prefix.append(size - 1)
                
            else:
                prefix.append(stack[-1] - 1)
                
            stack.append(i)
        prefix.reverse() # reverse the prefix array
        max_area = 0
        for i in range(size):
            max_area = max(max_area, (prefix[i] - suffix[i] + 1) * heights[i])
            
        return max_area

    # ===================== OPTIMAL ===================================
    def largestRectangleAreaOptimal(self, heights: List[int]) -> int:
        stack = []
        max_area = 0
        size = len(heights)
        
        for i in range(size + 1):
            # while the stack is non empty and,
            # either we are in the last index or height of top elem of stack 
            # is greater than the current element
            while stack != [] and (i == size or heights[stack[-1]] >= heights[i]):
                # get the top height
                height = heights[stack[-1]]
                stack.pop()
                width = 0
                # if satck is empty, width will be the current index
                if stack == []:
                    width = i
                # else, width will be index - top elem of stack -1
                else:
                    width = i - stack[-1] - 1
                
                max_area = max(max_area, width * height)
            stack.append(i)
        return max_area 