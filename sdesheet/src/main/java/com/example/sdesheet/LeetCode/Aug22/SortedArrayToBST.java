/*
	Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

	A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
*/

package com.example.sdesheet.LeetCode.Aug22;

public class SortedArrayToBST {
	public TreeNode sortedArrayToBST(int[] nums) {
        return addSubTree(nums, 0, nums.length - 1);
    }
    
    public TreeNode addSubTree(int[] nums, int start, int end) {
        if (end < start)
            return null;
        int mid = start + (end - start) / 2;
        TreeNode newNode = new TreeNode(nums[mid]);
        newNode.left = addSubTree(nums, start, mid - 1);
        newNode.right = addSubTree(nums, mid + 1, end);
        return newNode;
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {

	}

	TreeNode(int val) {
		this.val = val; 
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
 