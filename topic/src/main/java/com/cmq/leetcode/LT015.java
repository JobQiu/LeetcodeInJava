package com.cmq.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xavier.qiu
 * 9/30/18 7:56 PM
 */
public class LT015 {



    List<List<Integer>> threeSum01(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        if (nums == null || nums.length <= 2) {
            return list;
        }

        java.util.Arrays.sort(nums); //Collections.reverseOrder()
        int l = nums.length;
        for (int i = 0; i < l; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {

                int lo = i + 1;
                int hi = l - 1;
                while (lo < hi) {
                    int sum = nums[i] + nums[lo] + nums[hi];
                    if (sum == 0) {
                        list.add(Arrays.asList(nums[i], nums[lo], nums[hi]));

                        while (lo < hi && nums[lo] == nums[lo + 1]) {
                            lo++;// if the next number is still lo, plus and skip
                        } // end of while
                        while (lo < hi && nums[hi] == nums[hi - 1]) {
                            hi--;
                        } // end of while
                        lo++;
                        hi--;
                    } // end of if
                    else if (sum > 0) {
                        hi--;
                    } // end of if
                    else {
                        lo++;
                    }


                } // end of while


            } // end of if
        } // end of for i

        return list;

    }


    public static void main(String[] args) {
//        int[] test = new int[]{1, -1, -1, 0};
//        LT015 l = new LT015();
//        List<List<Integer>> res = l.threeSum01(test);
//        System.out.println("");

        int[] test = new int[]{6,7,8,1,2,3,4,5,6};




    }

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> list = new ArrayList();
        if (nums == null || nums.length <= 2) {
            return list;
        }

        java.util.Arrays.sort(nums); //Collections.reverseOrder()

        int l = nums.length;
        int prev = nums[0];

        for (int i = 0; i < l - 2; i++) {
            if (nums[i] == prev && i != 0) {
                continue;
            } // end of if

            int lo = i + 1;
            int hi = l - 1;
            while (lo < hi) {
                int sum = nums[lo] + nums[hi] + nums[i];
                if (sum == 0) {
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[lo]);
                    temp.add(nums[hi]);

                    list.add(temp);
                    lo++;
                    hi--;
                    while (lo + 1 < l && nums[lo + 1] == nums[lo]) {
                        lo++;
                    } // end of while
                    while (hi - 1 >= 0 && nums[hi - 1] == nums[hi]) {
                        hi--;
                    } // end of while
                } // end of if

                else if (sum > 0) {
                    lo++;
                } // end of if
                else {
                    hi--;
                }

            } // end of while

        } // end of for i

        return list;
    }


    // O(N + logN)
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        int len = nums.length;
        if (len < 3) {
            return res;
        }

        Arrays.sort(nums);
        int lastNeg = Arrays.binarySearch(nums, 0);
        int firstPos = lastNeg;
        int numZero;

        if (lastNeg < 0) {
            // no zeros, indices: [0..lastNeg,firstPos..N)
            numZero = 0;
            lastNeg = ((-lastNeg) - 1) - 1;    // retrieve insertion point from Java binarySearch
            firstPos = lastNeg + 1;             // firstPos is immediately after lastNeg
        } else {
            // zeros exist, indices: [0..lastNeg..zeros..firstPos..N)
            while (lastNeg > -1 && nums[lastNeg] == 0)
                lastNeg--;
            while (firstPos < len && nums[firstPos] == 0)
                firstPos++;
            numZero = firstPos - lastNeg - 1;
        }

        int min = nums[0];
        int max = nums[len - 1];
        int[] hash = new int[max - min + 1]; // hash[i] = j means there are j instances of (i + min)
        for (int v : nums) {
            hash[v - min]++;
        }

        // Case 0: (0,0,0)
        if (numZero >= 3) {
            res.add(Arrays.asList(0, 0, 0));
        }

        // Case 1: (-X,0,X)
        if (numZero > 0) {
            for (int i = firstPos; i < len; i++) {
                // skip redundant values
                if (nums[i] == nums[i - 1]) {
                    continue;
                }

                int need = 0 - (nums[i] + min);
                if (need >= 0 && hash[need] > 0) {
                    res.add(Arrays.asList(0, nums[i], -nums[i]));
                }
            } // END for i
        }

        // Case 2: 1 positive, 2 negative
        for (int i = firstPos; i < len; i++) {
            // ignore repeated values
            if (i > firstPos && nums[i] == nums[i - 1]) {
                continue;
            }

            int half;
            if (nums[i] % 2 != 0) {
                // round up
                half = -(nums[i] + 1) / 2;
            } else {
                // Subcase: (x, -x/2, -x/2)
                half = -nums[i] / 2;
                if (half >= min && hash[half - min] > 1) {
                    res.add(Arrays.asList(nums[i], half, half));
                }
            }

            for (int j = lastNeg; j >= 0 && nums[j] > half; j--) {
                // Note: nums[j] > half prevents repeated cases. E.g., (4,-1,-3) and (4,-3,-1)
                // ignore repeated values
                if (j < lastNeg && nums[j] == nums[j + 1]) {
                    continue;
                }

                int need = 0 - (nums[i] + nums[j]);
                if (need >= min && hash[need - min] > 0)
                    res.add(Arrays.asList(nums[i], nums[j], need));
            } // END for j
        } // END for i

        // Case 3: 1 negative, 2 positive
        for (int i = lastNeg; i > -1; i--) {
            if (i < lastNeg && nums[i] == nums[i + 1]) {
                continue;
            }

            int half;
            if (nums[i] % 2 != 0) {
                half = -(nums[i] - 1) / 2;
            } else {
                half = -nums[i] / 2;
                // Subcase: (x, -x/2, -x/2), x < 0
                if (half - min < hash.length && hash[half - min] > 1)
                    res.add(Arrays.asList(nums[i], half, half));
            }

            for (int j = firstPos; j < len && nums[j] < half; j++) {
                if (j > firstPos && nums[j] == nums[j - 1]) {
                    continue;
                }

                int need = 0 - (nums[i] + nums[j]);
                if (need <= max && hash[need - min] > 0) {
                    res.add(Arrays.asList(nums[i], nums[j], need));
                }
            } // END for j
        } // END for i

        return res;
    }
}
