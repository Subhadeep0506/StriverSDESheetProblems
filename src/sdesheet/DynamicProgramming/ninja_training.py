from typing import List

class NinjaTraining:
	def ninjaTraining(self, n: int, points: List[List[int]]) -> int:
	    memo = [[-1 for _ in range(4)] for _ in range(n)]
	    return self.helper(n - 1, 3, points, memo)

	def helper(self, day, last, points, memo):
	    if memo[day][last] != -1:
	        return memo[day][last]
	    
	    if day == 0:
	        max_point = 0
	        for i in range(3):
	            if i != last:
	                max_point = max(max_point, points[0][i])
	        memo[day][last] = max_point
	        return memo[day][last]
	    
	    max_point = 0
	    for i in range(3):
	        if i != last:
	            max_point = max(max_point, 
	                            self.helper(day - 1, i, points, memo) + points[day][i])
	            
	    memo[day][last] = max_point
	    return memo[day][last]