package com.cmq.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xavier.qiu
 * 10/2/18 9:55 PM
 */
public class LT159 {

    public static void main(String[] args) {

        String s = "ccaabbb";

        int start = 0;
        int end = 0;
        int res = 0;

        Map<Character, Integer> map = new HashMap();

        while (end < s.length()) {
            while (end < s.length() && map.size() <= 2) {
                char c = s.charAt(end);
                if (!map.containsKey(c)) {
                    map.put(c, 1);
                } // END of if
                else {
                    map.put(c, map.get(c) + 1);
                }

                end++;
            } // END of while

            res = Math.max(res, end - start-1);

            while (map.size() > 2) {
                char c = s.charAt(start);
                if (map.get(c) == 1) {
                    map.remove(c);
                } // END of if
                else {
                    map.put(c, map.get(c) - 1);
                }
                start++;
            } // END of while

        } // END of while

        System.out.println(res);
    }
}
