package com.cmq.leetcode;

/**
 * @author xavier.qiu
 * 10/3/18 10:40 PM
 */
public class LT300 {

    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};

        int l = nums.length;
        int[] temp = new int[l];

        int res = 1;
        temp[0] = nums[0];
        for (int i = 1; i < l; i++) {
            int pos = searchInsert(temp, nums[i], 0, res);
            if (pos < res) {
                temp[pos] = nums[i];
            } // END of if
            else {
                temp[pos] = nums[i];
                res = pos;
            }
            System.out.println(nums[i] + " : " + pos);
        } // END of for i


    }


    private static int searchInsert(int[] A, int target, int start, int end) {

        int low = start, high = end;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] == target) return mid;
            else if (A[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
}
