class MaxDiameter:
	max_diam = 0
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        self.max_diam = 0
        self.helper(root)
        return self.max_diam
    
    def helper(self, root):
        if not root:
            return 0
        
        # get the height of left and right subtree
        left_height = self.helper(root.left)
        right_height = self.helper(root.right)
        
        # calculate the diameter after getting left and right subtree
        self.max_diam = max(self.max_diam, left_height + right_height)
        # return the max of left and right subtree
        return 1 + max(left_height, right_height)