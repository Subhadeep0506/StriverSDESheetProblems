class BuildTree:
    # using preorder and inorder
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if inorder:
            # popping the 1st element [root] of preorder list and getting it's index
            # in inorder list
            index = inorder.index(preorder.pop(0))
            # making a node using element from that index
            root = TreeNode(inorder[index])
            
            # forming tree using left part of root in inorder list
            root.left = self.buildTree(preorder, inorder[:index])
            # and the right part
            root.right = self.buildTree(preorder, inorder[index + 1:])
            return root

    # Using inorder and postorder
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if inorder:
            index = inorder.index(postorder.pop())
            root = TreeNode(inorder[index])
            root.right = self.buildTree(inorder[index + 1:], postorder)
            root.left = self.buildTree(inorder[:index], postorder)
            return root