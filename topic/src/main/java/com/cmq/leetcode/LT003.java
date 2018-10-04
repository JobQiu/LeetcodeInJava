package com.cmq.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xavier.qiu
 * 10/1/18 4:33 PM
 */
public class LT003 {

    public static void main(String[] args) {
//        String test = "au";
//        LT003 l = new LT003();
//        int res = l.lengthOfLongestSubstring(test);
//        System.out.println("");

        String s = "abcdabcebb";
        int end = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap();

        int res = 0;
        while (end < s.length()) {
            char cur = s.charAt(end);
            System.out.println("end->" + cur);
            if (map.containsKey(cur)) {
                System.out.println("start=" + start + ", mapcur+1 = " + (map.get(cur) + 1));
                start = Math.max(map.get(cur) + 1, start);

            } // END of if
            System.out.println("start->" + s.charAt(start));

            map.put(cur, end);
            System.out.println("res str->" + s.substring(start, end + 1));
            if (end - start + 1 > res) {
                res = end - start + 1;
            } // END of if
            end++;
        } // END of while
        System.out.println("Result=" + res);
    }


    public int lengthOfLongestSubstring(String s) {

        return 0;
    }
}
