package com.cmq.leetcode;

/**
 * @author xavier.qiu
 * 10/2/18 9:16 PM
 */
public class LT045 {

    public static void main(String[] args) {

        int[] nums = new int[]{2, 3, 1, 1, 4};

    }

    public int jump(int[] nums) {

        int max = 0;
        int nextmax = 0;
        int start = 0;
        int res = 0;


        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 0;
        } // END of if
        int l = nums.length;
        while (max < l) {

            for (int i = start; i <= max; i++) {
                nextmax = Math.max(nextmax, nums[i] + i);
                if (nextmax >= l - 1) {
                    return res+1;
                } // END of if
            } // END of for i

            res++;
            start = max + 1;
            max = nextmax;
        } // END of while


        return res;
    }
}
