package com.cmq.leetcode;

/**
 * @author xavier.qiu
 * 10/1/18 10:56 PM
 */
public class LT076 {

    public static void main(String[] args) {

        String s = "ADOBECODEBANC";
        String t = "ABC";


        s = "ab";
        t = "A";

        if (t.length() < s.length()) {
            // return "";
        } // END of if
        int start = 0;
        int end = 0;
        int res = 0;
        int minLen = Integer.MAX_VALUE;

        int dict[] = new int[256];
        for (char c : t.toCharArray()) {
            dict[c]++;
        } // END of for


        int count = t.length();
        while (end < s.length()) {
            if (dict[s.charAt(end++)]-- > 0) {
                count--;
            } // END of if

            while (count == 0) {
                if (minLen > end - start) {
                    minLen = end - start;
                    res = start;
                } // END of if

                if (++dict[s.charAt(start++)] > 0) {
                    count++;
                } // END of if
            } // END of while

        } // END of while

        String result = minLen == Integer.MAX_VALUE ? "" : s.substring(res, res + minLen);
        System.out.println(result);
    }


    public String minWindow(String s, String t) {

        if (s.length() <= t.length() && !s.equals(t)) {

            return "";
        } // END of if

        int[] dict = new int[256];

        for (char c : t.toCharArray()) {
            dict[c]++;
        } // END of for

        int start = 0;
        int end = 0;
        int count = t.length();
        int len = s.length();
        int minLen = Integer.MAX_VALUE;
        String res = "";
        // 0 1 2 3 4 5 6 7 8 9 1 11 12
        // A D O B E C O D E B A N C
        //             s
        //                           e

        while (end < len) {

            while (end < len && count > 0) {

                System.out.println(s.substring(start, end));
                if (dict[s.charAt(end++)]-- >= 1) {
                    count--;
                } // END of if
            } // END of while

            while (start < len && count == 0) {
                System.out.println(s.substring(start, end));

                if (minLen > end - start) {
                    System.out.println(end - start);
                    minLen = end - start;
                    res = s.substring(start, end);
                } // END of if

                if (dict[s.charAt(start++)]++ == 0) {
                    count++;
                } // END of if
            } // END of while


        } // END of while


        return res;


    }
}
