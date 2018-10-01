package com.cmq.leetcode;

/**
 * @author xavier.qiu
 * 9/29/18 10:59 PM
 */
public class LT169 {

    /***
     * Moore Voting Algorithm
     *
     * @param
     * @return
     * @throws
     **/
    public int majorityElement(int[] num) {


        int major = num[0], count = 1;

        // take this [2,2,1,1,1,2,2] as an example
        for (int i = 1; i < num.length; i++) {

            if (count == 0) {
                count++;
                major = num[i];
            } else if (major == num[i]) {
                count++;
            } else count--;

        }
        return major;
    }
    // count = 1
    // major = 2


    public static void main(String[] args) {

    }
}
