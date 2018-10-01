package com.cmq.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xavier.qiu
 * 9/30/18 11:02 PM
 */
public class LT039 {

    public static void main(String[] args) {
        int[] test = new int[]{2,3,6,7};
        LT039 l = new LT039();
        List<List<Integer >> res = l.combinationSum(test,7);

        System.out.println("" +
                "");
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //java.util.Arrays.sort(candidates, Collections.reverseOrder()); //Collections.reverseOrder()

        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList();
        List<Integer> temp = new ArrayList();
        int l = candidates.length;

        helper(list, temp, target, l - 1, candidates);
        return list;
    }

    private void helper(List<List<Integer>> res, List<Integer> temp, int target, int start, int[] nums) {
        if (start < 0) {
            System.out.println("");
            return;
        } // end of if

        if (target == 0) {
            res.add(new ArrayList<Integer>(temp));
        } // end of if

        helper(res, new ArrayList<Integer>(temp), target, start - 1, nums);

        for (int i = 1; i < target / nums[start]; i++) {
            temp.add(nums[start]);
            helper(res, new ArrayList<Integer>(temp), target - i * nums[start], start - 1, nums);

        } // end of for i

    }
}
