package com.cmq.leetcode;

/**
 * @author xavier.qiu
 * 9/29/18 9:11 PM
 */
public class LT026 {


    public int removeDuplicatesF(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int count = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[count]) {
                count++;
                nums[count] = nums[i];
            }
        }

        return count + 1;
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 1,1,2,3,3,3,4,5,6
        //
        int prev = nums[0];
        int res = 1;
        int shift = 0;
        int l = nums.length;
        for (int i = 1; i < l; i++) {
            if (nums[i] == prev) {
                shift++;
                continue;
            } // end of if
            nums[i - shift] = nums[i];
            prev = nums[i];
            res++;
        } // end of for i


        return res;
    }

    public int mimic(int[] nums) {
        // 1, 2, 3, 3, 3, 4, 5, 6
        // |
        //    |
        //
        int count = 0;
        int l = nums.length;
        if (l <= 1) {
            return l;
        } // end of if

        for (int i = 0; i < l; i++) {
            if (nums[count] != nums[i]) {
                count++;
                nums[count] = nums[i];
            } // end of if
        } // end of for i


        return count;

    }

    public static void main(String[] args) {

        LT026 l = new LT026();
        int res = l.removeDuplicates(new int[]{1, 2, 3, 3, 3, 4, 5, 6});
        System.out.print("");


    }


}
