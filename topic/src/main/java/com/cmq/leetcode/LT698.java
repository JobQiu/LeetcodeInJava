package com.cmq.leetcode;

import com.cmq.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author xavier.qiu
 * 10/13/18 12:49 AM
 */
public class LT698 {


    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        return helper(coins, amount, new int[amount]);
    }

    private int helper(int[] coins, int rem, int[] count) { // rem: remaining coins after the last step; count[rem]: minimum number of coins to sum up to rem
        if (rem < 0) return -1; // not valid
        if (rem == 0) return 0; // completed
        if (count[rem - 1] != 0) return count[rem - 1]; // already computed, so reuse
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = helper(coins, rem - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }

    public static void main(String[] args) {

        String[] test = {"10", "11"};

        TreeNode root = TreeNode.getBinarySearchTree();
        Stack<TreeNode> pred = new Stack();
        Stack<TreeNode> succ = new Stack();
        initializePredecessorStack(root, 3.7, pred);
        initializeSuccessorStack(root, 3.7, succ);


        List<Double> list = new ArrayList();
        list.add(0.001);
        list.add(0.101);
        list.add(0.401);
        list.add(0.501);
        list.add(1.001);
        list.add(7.001);

        double[] targets = new double[]{0, 0.05, 0.3, 0.45, 0.51, 0.9, 1.3, 5, 8};

        for (double target : targets) {
            int res = insertPosition(list, target);
            System.out.println(target + " 's position in the list is " + res);
        } // END of for

    }


    private static void initializeSuccessorStack(TreeNode root, double target, Stack<TreeNode> succ) {
        while (root != null) {
            if (root.val == target) {
                succ.push(root);
                break;
            } else if (root.val > target) {
                succ.push(root);
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }

    private static void initializePredecessorStack(TreeNode root, double target, Stack<TreeNode> pred) {
        while (root != null) {
            if (root.val == target) {
                pred.push(root);
                break;
            } else if (root.val < target) {
                pred.push(root);
                root = root.right;
            } else {
                root = root.left;
            }
        }
    }

    private static int getNextSuccessor(Stack<TreeNode> succ) {
        TreeNode curr = succ.pop();
        int ret = curr.val;
        curr = curr.right;
        while (curr != null) {
            succ.push(curr);
            curr = curr.left;
        }
        return ret;
    }

    private static int getNextPredecessor(Stack<TreeNode> pred) {
        TreeNode curr = pred.pop();
        int ret = curr.val;
        curr = curr.left;
        while (curr != null) {
            pred.push(curr);
            curr = curr.right;
        }
        return ret;
    }


    private static int insertPosition(List<Double> nums, double target) {
        int lo = 0;
        int hi = nums.size();

        if (target < nums.get(0)) {
            return 0;
        } // end of if
        if (target > nums.get(hi - 1)) {
            return hi;
        } // END of if

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums.get(mid) == target) {
                return mid;
            } // END of if
            if (nums.get(mid) > target) {
                hi = mid;
            } // END of if
            else {
                lo = mid + 1;
            }
        } // END of while

        return lo;

    }


    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (k <= 0 || sum % k != 0) return false;
        int[] visited = new int[nums.length];
        // use an array to maintain if we have used a value.
        return canPartition(nums,
                visited,
                0,
                k,
                0,
                0,
                sum / k);
    }

    public static boolean canPartition(int[] nums,
                                       int[] visited,
                                       int start_index,
                                       int k,
                                       int cur_sum,
                                       int cur_num,
                                       int target) {
        if (k == 1)
            return true;
        if (cur_sum == target && cur_num > 0)
            return canPartition(nums,
                    visited,
                    0,
                    k - 1,
                    0,
                    0,
                    target);
        for (int i = start_index; i < nums.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                if (canPartition(nums,
                        visited,
                        i + 1,
                        k,
                        cur_sum + nums[i],
                        cur_num++,
                        target))
                    return true;
                visited[i] = 0;
            }
        }
        return false;
    }

}
