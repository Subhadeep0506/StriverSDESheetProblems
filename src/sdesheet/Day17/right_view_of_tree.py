from tree_node import TreeNode

class RightView:
	def right_view(self, root, res, curr_depth):
    if not root:
        return
    if curr_depth == len(res):
        res.append(root.val)
        
    self.left_view(root.right, res, curr_depth + 1)
    self.left_view(root.left, res, curr_depth + 1)

	def rightView(self, root: TreeNode):
	    res = []
	    self.right_view(root, res, 0)
	    return res