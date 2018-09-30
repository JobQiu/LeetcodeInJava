package com.cmq.tree;

import com.cmq.util.TreeNode;

/**
 * @author xavier.qiu
 * 9/29/18 2:55 PM
 */
public class SubtreeWithMaxAverage {

    class ResultType {
        int size, sum;

        public ResultType(int size, int sum) {
            this.size = size;
            this.sum = sum;
        }
    }

    private TreeNode resultTree;
    private ResultType result;

    public TreeNode findSubtree(TreeNode root) {

        return root;
    }

    private ResultType helper(TreeNode cur) {
        if (cur == null) {
            return new ResultType(0, 0);
        } // end of if

        ResultType left = helper(cur.left);
        ResultType right = helper(cur.right);

        ResultType res = new ResultType(left.size + right.size, left.sum + right.sum);
        if (result == null || res.sum * result.size < res.size * result.sum) {
            result = res;
            resultTree = cur;
        } // end of if

        return res;

    }

}
