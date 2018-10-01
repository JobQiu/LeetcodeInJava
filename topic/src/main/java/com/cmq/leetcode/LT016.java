package com.cmq.leetcode;

/**
 * @author xavier.qiu
 * 9/30/18 3:42 PM
 */
public class LT016 {
    public static void main(String[] args) {
        int[] test = new int[]{0,5,-1,-2,4,-1,0,-3,4,-5};
        int res = new LT016().threeSumClosest(test, 1);

        System.out.println(" ");
    }
    public int threeSumClosest(int[] nums, int target) {
        int res = Integer.MAX_VALUE;
        int distance = Integer.MAX_VALUE;

        java.util.Arrays.sort(nums); //Collections.reverseOrder()
        int l = nums.length;
        for (int i = 0; i < l - 2; i++) {
            // -4 -1 1 2
            int lo = i + 1;
            int hi = l - 1;
            while (lo < hi) {
                int temp = nums[i] + nums[lo] + nums[hi];
                if (Math.abs(temp - target) < distance) {
                    distance = Math.abs(temp - target);
                    res = temp;
                    if (distance == 0) {
                        return res;
                    } // end of if
                } // end of if

                if (target < temp) {
                    hi--;
                } // end of if
                else {
                    lo++;
                }


            } // end of while
        } // end of for i

        return res;

    }
}
