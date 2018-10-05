package com.cmq.leetcode;

/**
 * @author xavier.qiu
 * 10/3/18 11:56 PM
 */
public class LT074 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        matrix = new int[][]{{1, 3}};
        int target = 3;

        searchMatrix(matrix, target);

    }


    public static boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length, col = matrix[0].length;


        int begin = 0, end = row * col - 1;

        while (begin <= end) {
            int mid = (begin + end) / 2;
            int mid_value = matrix[mid / col][mid % col];

            if (mid_value == target) {
                return true;

            } else if (mid_value < target) {
                //Should move a bit further, otherwise dead loop.
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;

    }

}
