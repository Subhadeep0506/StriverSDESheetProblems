class SubArray:
	def findLength(self, nums1: List[int], nums2: List[int]) -> int:
        len1, len2 = len(nums1), len(nums2)
        
        memo = [[0 for _ in range(len2 + 1)] for j in range(len1 + 1)]
        max_len = 0
        
        for i in range(1, len1 + 1):
            for j in range(1, len2 + 1):
                if nums1[i - 1] == nums2[j - 1]:
                    memo[i][j] = memo[i - 1][j - 1] + 1
        return max(max(row) for row in memo)