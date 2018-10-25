/*

package com.cmq.linkedin.mine;

import com.cmq.linkedin.TreeNode;

import java.util.LinkedList;
import java.util.List;

/*
Question;
Path Sum的变种：给一个二叉树，每个节点的value都是one digit，比如[1,2,3,null,4] (leetcode的表示法)，那path就是1->2->4和1->3，那return 124+13;





public class Path_Sum_modefied {

    public static void main(String[] args) {
        int[] test = new int[]{
                3, 2, 3, 1, 2, 4, 5, 5, 6
        };
        findKthLargest(test, 4);

    }

    public static int findKthLargest(int[] nums, int k) {

        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int j = partition(nums, lo, hi);
            if (j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private static int partition(int[] a, int lo, int hi) {

        int i = lo;
        int j = hi + 1;
        while (true) {
            while (i < hi && less(a[++i], a[lo])) ;
            while (j > lo && less(a[lo], a[--j])) ;
            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static void exch(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static boolean less(int v, int w) {
        return v < w;
    }


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
*/