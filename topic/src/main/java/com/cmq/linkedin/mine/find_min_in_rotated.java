package com.cmq.linkedin.mine;

public class find_min_in_rotated {
    public int findMinInRotated(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        int lo = 0, hi = n - 1;
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi])
                lo = mid + 1;
            else
                hi = mid;
        }
        int smal = lo;
        return smal;
    }
}
