package com.cmq.leetcode;

import com.alibaba.fastjson.JSON;

/**
 * @author xavier.qiu
 * 10/3/18 10:40 PM
 */
public class LT300 {

    public static void main(String[] args) {

        int[] nums = new int[]{4, 10, 4, 3, 8, 9};

        int l = nums.length;
        int[] temp = new int[l];
        for (int i = 0; i < l; i++) {
            temp[i] = Integer.MAX_VALUE;
        } // END of for i

        int res = 0;

        temp[0] = nums[0];
        for (int n : nums) {
            int pos = searchInsert(temp, n);
            System.out.println(pos);
            temp[pos] = n;
            if (pos > res) {
                res = pos;
            } // END of if
            System.out.println(JSON.toJSONString(temp));

        } // END of for

        // 4 m m m m m
        // 4 10 m m m m
        // 4 10 m m m m
        // 3 10 m m m m
        // 3 8 m m m m
        // 3 8 9 m m m
    }

    private static int searchInsert(int[] A, int target) {
        int low = 0, high = A.length - 1;
//        int low = start, high = end;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] == target) return mid;
            else if (A[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }


}
