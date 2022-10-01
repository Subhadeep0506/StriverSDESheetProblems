from tree_node import TreeNode

class LeftView:
	def left_view(self, root, res, curr_depth):
    if not root:
        return
    if curr_depth == len(res):
        res.append(root.val)
        
    self.left_view(root.left, res, curr_depth + 1)
    self.left_view(root.right, res, curr_depth + 1)

	def LeftView(self, root: TreeNode):
	    res = []
	    self.left_view(root, res, 0)
	    return res