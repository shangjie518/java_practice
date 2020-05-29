package cn.leetcode;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	TreeNode invertTree(TreeNode root) {

		if (root == null)
			return null;
		if (root.left == null && root.right == null)
			return root;
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		invertTree(root.left);
		invertTree(root.right);

		return root;

	}

	TreeNode searchBST(TreeNode root, int val) {

		if (root.val == val)
			return root;
		if (val < root.val && root.left != null)
			return searchBST(root.left, val);
		if (val > root.val && root.right != null)
			return searchBST(root.right, val);
		return null;

	}
}
