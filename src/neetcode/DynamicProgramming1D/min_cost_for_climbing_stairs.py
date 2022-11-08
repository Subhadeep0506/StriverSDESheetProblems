from typing import List


class MinCostClimbingStairs:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        # Create a list of length of costs array and fill it with 0s
        dp = [0] * len(cost)
        # set dp[0] to cost[0]
        dp[0] = cost[0]
        # if cost[1] exists, set dp[1] to it, else set dp[1] to 0
        dp[1] = cost[1] if len(cost) >= 2 else 0

        # Now traverse for all the costs and add min of previous 2 costs to costs[i]
        # and set dp[i] to it
        for i in range(2, len(cost)):
            dp[i] = cost[i] + min(dp[i - 1], dp[i - 2])

        # Return min of last and second last costs as answer
        return min(dp[-1], dp[-2])