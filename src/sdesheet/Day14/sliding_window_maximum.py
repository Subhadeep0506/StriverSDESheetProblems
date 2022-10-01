import collections

class SlidingWindowMaximum:
	def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        ind_queue = collections.deque()
        res = []
        
        for i, curr in enumerate(nums):
            while ind_queue and nums[ind_queue[-1]] <= curr:
                ind_queue.pop()
            
            ind_queue.append(i)
            # if first element is outside window, remove it
            if ind_queue[0] == i - k:
                ind_queue.popleft()
            # if window has k elements add to results (first k-1 windows have < k 
            # elements because we start from empty window and add 1 element each 
            # iteration)
            if i >= k - 1:
                res.append(nums[ind_queue[0]])
                
        return res

    # ------------------------ Alternative --------------------------------
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        ind_queue = collections.deque()
        res = []
        for i, curr in enumerate(nums):
            if ind_queue and ind_queue[0] == (i - k):
                ind_queue.popleft()
                
            while ind_queue and nums[ind_queue[-1]] < nums[i]:
                ind_queue.pop()
                
            ind_queue.append(i)
            if i >= k - 1:
                res.append(nums[ind_queue[0]])
        return res