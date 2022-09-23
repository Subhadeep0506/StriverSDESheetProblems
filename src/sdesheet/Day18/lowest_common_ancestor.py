class LCAOfBinaryTree:
	def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # if root is null or root is either p or q, return root
        if not root or (root == p) or (root == q):
            return root
        # find if p and q exist in left and right subtree
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        
        # if we get null from left return right
        if not left:
            return right
        # if we get null from right return left
        elif not right:
            return left
        # if both left and right are non null, we know that we found out node
        # return root
        else:
            return root
