package com.cmq.leetcode;

import java.util.*;

/**
 * @author xavier.qiu
 * 9/30/18 7:09 PM
 */
public class LT090 {

    public static void main(String[] args) {
//        int[] test = new int[]{1, 2, 2};
//        LT090 l = new LT090();
//        List<List<Integer >> res = l.subsetsWithDup(test);
//        System.out.println("");

        String test = "123";
        System.out.println(test.substring(0,1));


        int[] nums = new int[]{1, 2, 2};
        List<List<Integer>> list = new ArrayList();

        List<Integer> temp = new ArrayList();

        helper(list, temp, nums, 0);

        System.out.println("" +
                "");

    }

    private static void helper(List<List<Integer>> list, List<Integer> temp, int[] nums, int start) {

        if (start <= nums.length) {
            list.add(new ArrayList<>(temp));
        } // END of if

        int i = start;
        while (i < nums.length) {
            temp.add(nums[i]);
            helper(list, temp, nums, i + 1);
            temp.remove(temp.size() - 1);

            i++;
            while (i<nums.length &&  nums[i] == nums[i - 1]) {
                System.out.println(nums[i] + " is same with " + nums[i - 1]);
                i++;
            } // END of if
        } // END of while


    }


    public void helper(List<List<Integer>> res, List<Integer> each, int pos, int[] n) {
        if (pos <= n.length) {
            res.add(each);
        }
        int i = pos;
        while (i < n.length) {
            each.add(n[i]);
            helper(res, new ArrayList<>(each), i + 1, n);
            each.remove(each.size() - 1);
            i++;
            while (i < n.length && n[i] == n[i - 1]) {i++;}
        }
        return;
    }


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        java.util.Arrays.sort(nums); //Collections.reverseOrder()

        backtracking(list, new ArrayList<Integer>(), nums, 0);

        return list;
    }


    private void backtracking(List<List<Integer>> result, List<Integer> temp, int[] nums, int start) {
        result.add(new ArrayList<Integer>(temp));

        for (int i = start; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {

                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                } // end of if

                for (ArrayList a : map.get(nums[i])) {

                    temp.addAll(a);
                    backtracking(result, temp, nums, start + mapcout.get(nums[start]));

                    for (int j = 0; j < a.size(); j++) {
                        temp.remove(temp.size() - 1);
                    } // end of for j

                }


            } // end of if
            else {
                temp.add(nums[i]);
                backtracking(result, temp, nums, i + 1);
                temp.remove(temp.size() - 1);
            }

        } // end of for i


    }

    private Set<Integer> used = new HashSet();
    private Map<Integer, ArrayList<ArrayList<Integer>>> map = new HashMap();
    private Map<Integer, Integer> mapcout = new HashMap<>();

    private void buildMap(int[] nums) {
        if (nums.length < 2) {
            return;
        } // end of if
        int l = nums.length;
        Map<Integer, Integer> temp = new HashMap();
        for (int i = 0; i < l; i++) {
            temp.put(nums[i], temp.getOrDefault(nums[i], 0) + 1);

        } // end of for i

        for (Integer i : temp.keySet()) {
            if (temp.get(i) > 1) {
                ArrayList<ArrayList<Integer>> templist = new ArrayList();
                List<Integer> list = new ArrayList();
                for (int j = 0; j <= temp.get(i); j++) {
                    templist.add(new ArrayList(list));
                    list.add(i);
                } // end of for i
                map.put(i, templist);
                mapcout.put(i, temp.get(i));
            } // end of if
        }


    }

}
