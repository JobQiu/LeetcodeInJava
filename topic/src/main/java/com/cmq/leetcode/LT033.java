package com.cmq.leetcode;

/**
 * @author xavier.qiu
 * 9/30/18 3:09 PM
 */
public class LT033 {

    public static void main(String[] args) {
        int [] test = new int[]{3,1};
        int res = new LT033().search(test, 1);

        System.out.println("");
    }

    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int l = nums.length;
        int s = 0;
        int e = l - 1;
        int first = nums[0];
        if (target >= first) {

            // it means the number is in the first half, and any numbers less than first should be considered as infinite
            while (s < e) {
                int mid = (s + e) / 2;
                if (nums[mid] == target) {
                    return mid;
                } // end of if
                if (nums[mid] < first || nums[mid] > target) {
                    e = mid ;
                } // end of if{
                else {
                    s = mid + 1;
                }


            } // end of while
        } // end of if
        else {

            while (s < e) {
                int mid = (s + e) / 2;

                if (nums[mid] == target) {
                    return mid;
                } // end of if

                if (nums[mid] > first || nums[mid] < target) {
                    s = mid + 1;
                } else {
                    e = mid;
                }
            } // end of while


        }

        return -1;
    }
}
