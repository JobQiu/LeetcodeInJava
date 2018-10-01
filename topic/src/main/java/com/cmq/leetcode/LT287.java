package com.cmq.leetcode;

/**
 * @author xavier.qiu
 * 9/30/18 9:49 PM
 */
public class LT287 {

    public static void main(String[] args) {
        int [] test = new int[]{1,3,4,2,2};
        new LT287().findDuplicate(test);
    }

    public int findDuplicate(int[] nums) {
        // can not modify no sorting
        // optimized sol O(N)  0(1)
        // uing slow fast points, 类似linked list cycle

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int slow = nums[0], fast = nums[nums[0]];

        while (fast != slow) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        // slow = fast
        // fast reset
        fast = 0;

        while (fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
