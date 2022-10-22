class IsSameTree:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        return self.helper(p, q)
        
    def helper(self, p, q):
        # if both p and q don't exist, then retutrn true
        if not p and not q:
            return True
        # if either p or q don't exist, return false
        elif not p or not q:
            return False
        else:
            return p.val == q.val and self.helper(p.left, q.left) and self.helper(p.right, q.right)
