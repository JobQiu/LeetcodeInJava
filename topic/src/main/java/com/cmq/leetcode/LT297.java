package com.cmq.leetcode;

import com.cmq.util.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author xavier.qiu
 * 10/11/18 1:14 PM
 */
public class LT297 {

    /***
     * binary search num in range[start, end]
     *
     * @param start and end are inclusive, num is the target we want to search
     * @return the index of num, or -1 if not exist
     * @throws
     **/
    public int bsearch(int[] array, int start, int end, int num) {

        if (array == null || array.length == 0) {
            return -1;
        }
        if (end >= array.length) {
            end = array.length - 1;
        } // end of if

        if (num < array[0] || num > array[end]) {
            return -1;
        } // end of if

        if (start < 0) {
            start = 0;
        } // end of if

        while (start <= end) {

            int mid = (start + end) / 2;
            if (array[mid] == num) {
                return mid;
            } else if (num < array[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        TreeNode t = TreeNode.getTestTree();
        LT297 l = new LT297();

        String res = l.serialize(t);
        System.out.println(res);
        TreeNode tt = l.deserialize(res);

    }

    private static final String spliter = ",";
    private static final String NN = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NN).append(spliter);
        } else {
            sb.append(node.val).append(spliter);
            buildString(node.left, sb);
            buildString(node.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(NN)) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}
