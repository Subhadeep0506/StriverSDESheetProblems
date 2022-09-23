from tree_node import TreeNode

class VerticalTraversal:
	def verticalTraversal(self, root: Optional[TreeNode]) -> List[List[int]]:
        res = []
        if not root:
            return res
        node_map = collections.defaultdict(list)
        queue = []
        queue.append((0, 0, root)) # level, index, node
        while queue:
            level, index, curr = queue[0]
            queue.pop(0)
            if not curr:
                continue
            # Here we use a tuple of level and index as key
            # ITS AWESOMEEEEE
            node_map[(level, index)].append(curr.val)
            node_map[(level, index)].sort()
            
            queue.extend([(level + 1, index - 1, curr.left), 
                          (level + 1, index + 1, curr.right)])
            
        key_map = collections.defaultdict(list)
        keys = sorted(list(node_map.keys()), key = lambda x: (x[1], x[0]))
        
        for k in keys:
            level, index = k
            key_map[index].extend(node_map[k])
            
        return key_map.values()