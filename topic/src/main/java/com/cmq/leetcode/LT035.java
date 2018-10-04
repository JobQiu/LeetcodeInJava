package com.cmq.leetcode;

/**
 * @author xavier.qiu
 * 10/3/18 10:13 PM
 */
public class LT035 {

    public static void main(String[] args) {

        int[] nums = new int[]{1, 3, 4, 5, 6, 7, 8, 9};
        int target = 2;
        int res = -1;
        if (target <= nums[0]) {
            res = 0;
        } // END of if
        int l = nums.length;
        if (target > nums[l - 1]) {
            res = l;
        } // END of if

        int lo = 0;
        int hi = l - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] == target) {
                res = mid - 1;
                break;
            } // END of if

            if (nums[mid] > target) {
                hi = mid-1;
            } // END of if
            else {
                lo = mid;
            }
        } // END of while
        if (res == -1)
            res = lo;
        System.out.println("");

        LT035 l2 = new LT035();
        res = l2.searchInsert(nums,6);
        System.out.println("");

    }

    public int searchInsert(int[] A, int target) {
        int low = 0, high = A.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(A[mid] == target) return mid;
            else if(A[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
}
