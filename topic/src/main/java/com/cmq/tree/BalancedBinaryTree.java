package com.cmq.tree;

import com.cmq.util.ResultType;
import com.cmq.util.TreeNode;

/**
 * @author xavier.qiu
 * 9/29/18 2:43 PM
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        ResultType res = helper(root);
        return res.isBalanced;
    }

    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(true, 0);
        } // end of if

        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        if (!left.isBalanced || !right.isBalanced) {
            return new ResultType(false, -1);
        } // end of if

        if (Math.abs(left.maxDepth - right.maxDepth) > 1) {
            return new ResultType(false, -1);
        } // end of if

        return new ResultType(true, Math.max(right.maxDepth, left.maxDepth) + 1);
    }

}
