from sdesheet.Day17.tree_node import TreeNode

class CountGoodNodes:
    def goodNodes(self, root: TreeNode) -> int:
        return self.countGoods(root, root.val)

    def countGoods(self, root, max_val):
        if not root:
            return 0
        
        res = 1 if root.val >= max_val else 0

        max_val = max(max_val, root.val)

        res += self.countGoods(root.left, max_val)
        res += self.countGoods(root.right, max_val)

        return res