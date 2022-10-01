def helper(index, heights, size, k, memo):
	if index == 0:
		return 0
	if memo[index] != -1:
		return memo[index]
	mincost = float("inf")
	for i in range(1, k + 1):
		if (index - i >= 0):
			mincost = min(mincost, 
				(helper(index - i, heights, size, k, memo) + abs(heights[index] - heights[index - i])))

	memo[index] = mincost
	return memo[index]

def frog_jump(heights, size, k):
	memo = [-1 for _ in range(size)]
	return helper(size - 1, heights, size, k, memo)

# --------------------TABULATION---------------------

def frog_jump_tabu(heights, size, k):
	memo = [-1 for _ in range(size)]
	memo[0] = 0
	for i in range(1, size):
		mincost = float("inf")
		for j in range(1, k + 1):
			if (i - j >= 0):
				mincost = min(mincost, memo[i - j] + abs(heights[i] - heights[i - j]))
		memo[i] = mincost
	return memo[size - 1]

# User input
nums = [int(item) for item in input().split()]
size = nums[0]
k = nums[1]
heights = [int(item) for item in input().split()]

print(frog_jump_tabu(heights, size, k))