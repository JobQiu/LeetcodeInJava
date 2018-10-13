package com.cmq.util;

/**
 * @author xavier.qiu
 * 10/11/18 2:29 PM
 */
public class BinarySearch {

    public static void main(String[] args) {
        int i = -Integer.MIN_VALUE;

        System.out.println(i);

        int[] nums = new int[]{0, 1, 2, 3, 4, 5, 7, 8, 9};
        int target = 6;
        int res = search(nums, target);

        nums = new int[]{3, 1};
        target = 3;
        res = search(nums, target);

        target = 1;
        res = search(nums, target);

        nums = new int[]{1};
        res = search(nums, target);

        target = 3;
        res = search(nums, target);

        System.out.println(res);
        /*
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] == target) {
                System.out.println("find it");
                break;
            } // END of if
            else if (nums[mid] > target) {
                hi = mid;
                System.out.println("high = " + hi);
            } // END of if
            else {
                lo = mid + 1;
                System.out.println("low  = " + lo);
            }

        } // END of while
*/

    }

    private static int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = nums.length;
        int lo = 0;
        int hi = l - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            System.out.println("mid  = " + mid);
            int num = nums[mid];

            System.out.println("num = " + num);
            if (num < nums[0] && target < nums[0]) {
                System.out.println("they are both less than nums[0]");
            } // END of if

            if (num > nums[0] && target > nums[0]) {
                System.out.println("they are both larger than nums[0]");
            } // END of if

            if (num == target) {

                return mid;
            } // END of if

            num = num < nums[0] == target < nums[0] ? num : target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            if (num < target) {
                lo = mid + 1;
                System.out.println("low  = " + lo);

            } // END of if
            else {
                hi = mid;
                System.out.println("high = " + hi);

            }

        } // END of while

        return -1;

    }
}
