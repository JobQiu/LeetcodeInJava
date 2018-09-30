package com.cmq.tree;

import com.cmq.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xavier.qiu
 * 9/29/18 2:27 PM
 */
public class MaxDepthBinaryTree {

    public int maxDepthDC(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepthDC(root.left);
        int right = maxDepthDC(root.right);

        return Math.max(left, right) + 1;


    }


    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        } // end of if

        int res = 0;
        Queue<TreeNode> q = new LinkedList<>();
        // offer, poll peek
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur.left != null) {
                    q.offer(cur.left);
                } // end of if

                if (cur.right != null) {
                    q.offer(cur.right);
                } // end of if
            } // end of for i
            res += 1;
        }

        return res;
    }

    public static void main(String[] args) {
        MaxDepthBinaryTree m = new MaxDepthBinaryTree();
        int res = m.maxDepth(TreeNode.getTestTree());
        System.out.println("");
    }
}
