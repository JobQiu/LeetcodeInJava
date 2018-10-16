package com.cmq.linkedin;

public class LCA_modified {
    /**
     * Question : 1
     * Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
     *
     * The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
     *
     * The node has an extra attribute *parent* which point to the father of itself. The root's parent is null.
     *
     *
     * Solution：
     * so do it like intersection of two linkedlist
     */



    /**
     * Question : 2
     * Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
     * The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
     * Return null if LCA does not exist.
     *
     * node A or node B may not exist in tree.
     *
     *
     * Solution：
     * so node A and node B may not exist in tree, so we need to detect the existance firstly, then adopt next step
     */

    private boolean foundA, foundB;

    public TreeNode lowestCommonAncestor_no(TreeNode root, TreeNode A, TreeNode B) {
        foundA = false;
        foundB = false;

        TreeNode LCA = find(root, A, B);
        if (foundB && foundA)
            return LCA;
        else
            return null;
    }

    public TreeNode find(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null)
            return null;

        TreeNode left = find(root.left, A, B);
        TreeNode right = find(root.right, A, B);

        /* if root is what we want to find, update foundA and foundB*/
        if (root == A || root == B) {
            foundA = (root == A) || foundA;
            foundB = (root == B) || foundB;
            return root;
        }

        return left == null ? right : right == null ? left : root;
    }
}
