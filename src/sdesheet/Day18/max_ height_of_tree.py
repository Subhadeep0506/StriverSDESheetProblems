class MaxDepth:
	def maxDepth(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        queue = collections.deque()
        queue.append([1, root]) # [level, node]
        max_height = 1
        
        while queue:
            level, curr = queue.popleft()
            max_height = max(max_height, level)
            if curr.left:
                queue.append([level + 1, curr.left])
            if curr.right:
                queue.append([level + 1, curr.right])
        return max_height