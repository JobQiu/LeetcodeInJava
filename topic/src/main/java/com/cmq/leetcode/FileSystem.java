package com.cmq.leetcode;

import java.util.Arrays;

/**
 * @author xavier.qiu
 * 10/4/18 5:31 PM
 */
public class FileSystem {


    /***
     * insert a number k into an array A
     *
     * @param A, assume A is not empty, null or so.
     * @return
     * @throws
     **/
    private int insertPos(int[] nums, int k){

        int lo = 0;
        int hi = nums.length ;

        while(  lo < hi ){
            int mid = (lo + hi) /2 ;
            if(nums[mid] == k ){
                return mid;
            } // END of if
            if(nums[mid] > k){
                hi = mid;
            } // END of if
            else{
                lo = mid + 1;
            }

        } // END of while

        return lo;
    }

    public static void main(String[] args) {

        FileSystem s = new FileSystem();
        int[] A = new int[]{1,3 , 5, 6};
        System.out.println(s.insertPos(A, 0));
        System.out.println(s.insertPos(A, 1));
        System.out.println(s.insertPos(A, 2));
        System.out.println(s.insertPos(A, 3));
        System.out.println(s.insertPos(A, 4));
        System.out.println(s.insertPos(A, 5));
        System.out.println(s.insertPos(A, 6));
        System.out.println(s.insertPos(A, 7));



    }
    public FileSystem() {

    }

    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];
        //fill right with n, no need to fill left, height since int[] is 0 by default
        Arrays.fill(right, n);
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            int currLeft = 0;
            int currRight = n;

            //compute height
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }

            //compute left boundary
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], currLeft);
                } else {
                    left[j] = 0;
                    currLeft = j + 1;
                }
            }

            //compute right boundary
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], currRight);
                } else {
                    right[j] = n;
                    currRight = j;
                }
            }


            //compute area
            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea, (right[j] - left[j]) * height[j]);
            }
        }

        return maxArea;
    }

//    public static void main(String[] args) {
//        char[][] test = new char[][]{
//                {'1', '0', '1', '0', '0', '1', '0'},
//                {'0', '1', '1', '1', '0', '1', '0'},
//                {'1', '1', '1', '1', '0', '1', '1'},
//                {'1', '0', '0', '1', '1', '1', '0'}
//        };
//
//
//        maximalRectangle(test);
//
//    }
}
