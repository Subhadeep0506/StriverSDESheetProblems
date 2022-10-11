from sdesheet.Day17.tree_node import TreeNode

class Serialization:
    def serialize(self, root: TreeNode):
        res = []
        def dfs(root):
            if not root:
                res.append('N')
                return
            res.append(str(root.val))
            dfs(root.left)
            dfs(root.right)
        dfs(root)
        return ",".join(res)
        
    def deserialize(self, data: str):
        vals = data.split(",")
        self.i = 0
        def dfs():
            if vals[self.i] == 'N':
                self.i += 1
                return None
            
            root = TreeNode(int(vals[self.i]))
            self.i += 1
            root.left = dfs()
            root.right = dfs()
            return root
        return dfs()