class ZigZagTraversal:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        res = []
        
        if not root:
            return res
        
        leftToRight = True
        queue = collections.deque()
        queue.append([root, True])
        
        while queue:
            size = len(queue)
            curr_level = collections.deque()
            
            for _ in range(size):
                node, leftToRight = queue[0]
                queue.popleft()
                if leftToRight:
                    curr_level.append(node.val)
                else:
                    curr_level.appendleft(node.val)
                if node.left:
                    queue.append([node.left, not leftToRight])
                if node.right:
                    queue.append([node.right, not leftToRight])
            res.append(curr_level)
        
        return res