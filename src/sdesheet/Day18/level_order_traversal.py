import collections
from typing import *

class LevelOrder:
	def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        queue = collections.deque()
        queue.append(root)
        res = []
        while queue:
            curr_level = []
            size = len(queue)
            for _ in range(size):
                curr_node = queue.popleft()
                # queue.pop(0)
                curr_level.append(curr_node.val)
                if curr_node.left:
                    queue.append(curr_node.left)
                if curr_node.right:
                    queue.append(curr_node.right)
            res.append(curr_level)
            
        return res