package com.cmq.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xavier.qiu
 * 9/28/18 4:30 PM
 */
public class ArrayLT {

    public static void main(String[] args) {

    }


    /***
     * Find all unique triplets in the array which gives
     * the sum of zero.
     *
     * [-1, 0, 1, 2, -1, -4]
     *
     * @param
     * @return
     * @throws
     **/
    public List<List<Integer>> threeSum(int[] nums) {
        java.util.Arrays.sort(nums); //Collections.reverseOrder()
        // -4 -1 -1 0 1 2
        //

        List<List<Integer>> list = new ArrayList();

        return list;

    }


    /***
     *
     * Given an integer array nums, find the contiguous
     * subarray (containing at least one number) which
     * has the largest sum and return its sum.
     *
     * Input: [-2,1,-3,4,-1,2,1,-5,4],
     * Output: 6
     * Explanation: [4,-1,2,1] has the largest sum = 6.
     *
     * @param
     * @return
     * @throws
     **/
    public int maxSubArray(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int maxCur = 0;

        int l = nums.length;
        for (int i = 0; i < l; i++) {
            maxCur = Math.max(maxCur + nums[i], nums[i]);
            max = Math.max(max, maxCur);
        } // end of for i


        return max;
    }

    /***
     * Input: [1,8,6,2,5,4,8,3,7]
     * Output: 49
     *
     * use two pointers, and dp
     *
     * @param
     * @return
     * @throws
     **/
    public int maxArea(int[] height) {
        // use two pointers from two sides

        if (height == null || height.length == 0) {
            return 0;
        }

        int res = 0;
        int s = 0;
        int l = height.length - 1;
        while (s < l) {
            res = Math.max(res, Math.min(height[s], height[l]) * (l - s));
            if (height[s] < height[l]) {
                s++;
            } // end of if
            else {
                l--;
            }
        } // end of while
        return res;

    }

    /***
     * this is hard, the tag is bsearch and divide and conquer.
     *
     *
     * @param
     * @return
     * @throws
     **/
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        return 0;
    }

    /***
     * just use a hashmap to search, so we dont need to search in O(N) each time.
     *
     * @param
     * @return
     * @throws
     **/
    private int[] twoSum(int[] arr, int target) {

        int[] res = new int[2];
        if (arr == null || arr.length == 0) {
            return res;
        }
        // use a Set<>, O(N) time, O(N) space
        Map<Integer, Integer> map = new HashMap();
        int l = arr.length;

        for (int i = 0; i < l; i++) {
            if (map.containsKey(target - arr[i])) {
                res[0] = map.get(target - arr[i]) + 1;
                res[1] = i + 1;
                return res;
            } // end of if
            map.put(arr[i], i);
        } // end of for i

        return res;

    }
}
