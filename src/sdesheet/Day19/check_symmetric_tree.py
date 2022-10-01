class SymmetricTree:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return False
        return self.helper(root.left, root.right)
    
    def helper(self, left, right):
        if not left or not right:
            return left == right
        isleft = self.helper(left.left, right.right)
        isright = self.helper(left.right, right.left)
        
        return left.val == right.val and isleft and isright