package com.cmq.tree;

import com.cmq.util.TreeNode;

/**
 * @author xavier.qiu
 * 9/29/18 2:36 PM
 */
public class MinimumSubtree {

    private TreeNode resultTree = null;
    private int resultSum = Integer.MAX_VALUE;

    private TreeNode findSubtree(TreeNode root) {

        helper(root);
        return resultTree;
    }

    /***
     *
     *
     * @param
     * @return the sum of this subtree
     * @throws
     **/
    private int helper(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int sum = helper(root.left) + helper(root.right) + root.val;
        if (sum < resultSum) {
            resultTree = root;
            resultSum = sum;
        } // end of if

        return sum;

    }

    public static void main(String[] args) {
        MinimumSubtree m = new MinimumSubtree();
        TreeNode res = m.findSubtree(TreeNode.getTestTree());
        System.out.println("");
    }
}
