package com.cmq.leetcode;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * @author xavier.qiu
 * 10/11/18 3:40 PM
 */
public class LT046 {

    public static void main(String[] args) {
       //BitSet

        int[] nums = new int[]{1, 2, 4,  6, 7, 8, 9, 10};
        int target = 7;

        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if(nums[mid] > target){
                hi = mid;

            } // END of if
            else {
                lo = mid+1;
            }
        } // END of while

        LT046 l = new LT046();
        l.permute(new int[]{1, 2, 3});

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        dfs(nums, 0, res);
        return res;
    }

    private void dfs(int[] nums, int idx, List<List<Integer>> res) {
        if (idx == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            res.add(list);
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            swap(nums, idx, i);
            dfs(nums, idx + 1, res);
            swap(nums, idx, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


}
