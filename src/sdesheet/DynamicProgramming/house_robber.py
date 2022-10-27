class HouseRobber:
	def house_robber_memo(self, nums):
		size = len(nums)
		memo = [-1 for _ in range(size)]
		return self.helper(size - 1, nums, memo)

	def helper(self, index, nums, memo):
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
		
	# ==========================Tabulation==============================
	def house_robber_tabu(self, nums):
		n = len(nums)
		memo = [-1 for  _ in range(n)]
		memo[0] = nums[0]
		for index in range(1, n):
			take = nums[index]
			if index - 2 >= 0:
				take += memo[index - 2]
			not_take = memo[index - 1]
			memo[index] = max(take, not_take)
        
		return memo[n - 1]