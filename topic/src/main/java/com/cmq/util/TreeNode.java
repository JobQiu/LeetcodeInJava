package com.cmq.util;

/**
 * @author xavier.qiu
 * 9/29/18 1:58 PM
 */
public class TreeNode {
    public int val;

    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public static TreeNode getTestTree() {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(6);

        return root;
    }
}
