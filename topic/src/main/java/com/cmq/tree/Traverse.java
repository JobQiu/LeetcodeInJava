package com.cmq.tree;

import com.cmq.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author xavier.qiu
 * 9/29/18 1:58 PM
 */
public class Traverse {

    List<Integer> preorderTraverse(TreeNode root) {
        List<Integer> list = new ArrayList();

        if (root == null) {
            return list;
        } // end of if
        traverse(list, root);

        return list;
    }

    private void traverse(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        } // end of if

        list.add(root.val);
        traverse(list, root.left);
        traverse(list, root.right);


    }

    List<Integer> preorderDC(TreeNode root) {
        List<Integer> list = new ArrayList();
        if (root == null) {
            return list;
        } // end of if

        List<Integer> left = preorderDC(root.left);
        List<Integer> right = preorderDC(root.right);

        list.add(root.val);
        list.addAll(left);
        list.addAll(right);

        return list;
    }

    List<Integer> inorder(TreeNode root) {
        List<Integer> list = new ArrayList();

        if (root == null) {
            return list;
        } // end of if

        Stack<TreeNode> stack = new Stack();
// size, pop, push, peek, empty
        while (root != null) {
            stack.push(root);
            root = root.left;
        } // end of while

        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            if (root.right != null) {
                root = root.right;
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                } // end of while
            } // end of if

        } // end of while

        return list;
    }


    List<Integer> preorder(TreeNode root) {
        List<Integer> list = new ArrayList();
        if (root == null) {
            return list;
        } // end of if

        Stack<TreeNode> stack = new Stack();
        // size, pop, push, peek, empty
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();

            list.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            } // end of if
            if (cur.left != null) {
                stack.push(cur.left);
            } // end of if
        } // end of while

        return list;
    }

    public static void main(String[] args) {
        Traverse t = new Traverse();
        List<Integer> l = t.preorder(TreeNode.getTestTree());
        System.out.println("");

        l = t.inorder(TreeNode.getTestTree());
        System.out.printf("123");

    }
}
