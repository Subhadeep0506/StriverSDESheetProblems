import collections

class TopViewTree:
	def topView(self, root):
        res = []
        
        if not root:
            return res
            
        node_map = collections.defaultdict(int)
        queue = []
        queue.append([0, root])
        
        while queue:
            index, node = queue[0]
            queue.pop(0)
            if not node_map[index]:
                node_map[index] = node.data
            
            if node.left:
                queue.append([index - 1, node.left])
            if node.right:
                queue.append([index + 1, node.right])
        
        for _, v in sorted(node_map.items()):
            res.append(v)
        return res