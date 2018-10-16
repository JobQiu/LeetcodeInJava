package com.cmq.linkedin;

import java.util.LinkedList;
import java.util.List;

/*
Question;
Path Sum的变种：给一个二叉树，每个节点的value都是one digit，比如[1,2,3,null,4] (leetcode的表示法)，那path就是1->2->4和1->3，那return 124+13;




 */
public class Path_Sum_modefied {


    public int pathSum(TreeNode root) {
        if (root == null)
            return 0;

        List<Integer> numbers = new LinkedList<>();
        findNumber(root, numbers, 0);
        int sum = 0;
        for (int num : numbers)
            sum += num;

        return sum;
    }

    private void findNumber(TreeNode root, List<Integer> numbers, int num) {
        num = num * 10 + root.val;
        if (root.left == null && root.right == null) {
            numbers.add(num);
            return;
        }

        if (root.left != null)
            findNumber(root.left, numbers, num);

        if (root.right != null)
            findNumber(root.right, numbers, num);

    }
}
