package com.cmq;

/**
 * Hello world!
 */
public class App {

    private int bsearch2(int[] arr, int s, int e, int k) {


        if (arr == null || arr.length == 0) {
            return -1;
        }

        if (k < arr[s] || k > arr[e]) {
            return -1;
        } // end of if

        while (s < e) {
            int mid = (s + e) / 2;
            if (arr[mid] == k) {
                return mid;
            } // end of if
            else if (arr[mid] > k) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        } // end of while
        return -1;
    }

    /***
     * binary search num in range[start, end]
     *
     * @param start and end are inclusive, num is the target we want to search
     * @return the index of num, or -1 if not exist
     * @throws
     **/
    public int bsearch(int[] array, int start, int end, int num) {

        if (array == null || array.length == 0) {
            return -1;
        }
        if (end >= array.length) {
            end = array.length - 1;
        } // end of if

        if (num < array[0] || num > array[end]) {
            return -1;
        } // end of if

        if (start < 0) {
            start = 0;
        } // end of if

        while (start <= end) {

            int mid = (start + end) / 2;
            if (array[mid] == num) {
                return mid;
            } else if (num < array[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }


    public int[] dailyTemperatures(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int l = nums.length;  // 8
        int[] res = new int[l];
        //  0  1  2  3  4  5  6  7 index
        // 73 74 75 71 69 72 76 73
        //  0  0  0  0  0  0  0  0


        /*
        i = 7
        j = 1

        i = 6, j = 1

        i = 5, j = 1
        */

        for (int i = l - 1; i >= 0; i--) {
            int j = 1;
            while (j + i < l) {

                if (nums[i] > nums[i + j] && res[i + j] != 0) {
                    j += res[i + j];
                } // end of if
                else {
                    break;
                }
            } // end of while

            if (j + i >= l) {
                res[i] = 0;
            } // end of if
            else {
                res[i] = j;
            }
        } // end of for i

        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        new App().dailyTemperatures(a);
        System.out.println("Hello World!");

        int[] arr = new int[]{1, 2, 4, 5, 6, 7, 8, 9};
        int res = new App().bsearch2(arr, 0, 7, 5);
        System.out.println("" +
                "");
    }
}
