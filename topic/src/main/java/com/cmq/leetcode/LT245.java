package com.cmq.leetcode;

/**
 * @author xavier.qiu
 * 10/2/18 9:10 PM
 */
public class LT245 {
    public static void main(String[] args) {

        String[] words = new String[]{"practice", "makes", "perfect", "coding", "makes"};

        String word1 = "practice";
        // word1 = "makes";
        String word2 = "makes";
        int l = words.length;
        int res = Integer.MAX_VALUE;
        if (word1.equals(word2)) {
            int prev = -1;
            for (int i = 0; i < l; i++) {
                if (prev == -1 && words[i].equals(word1)) {
                    prev = i;
                    continue;
                } // END of if

                if (words[i].equals(word1)) {
                    res = Math.min(res, i - prev);
                    prev = i;
                } // END of if
            } // END of for i

        } // END of if
        else {

            int prev1 = -1;
            int prev2 = -1;

            for (int i = 0; i < l; i++) {

                if (prev1 == -1 && words[i].equals(word1)) {
                    prev1 = i;
                    if (prev2 != -1) {
                        res = Math.min(res, i - prev2);
                    } // END of if

                    continue;
                } // END of if

                if (prev2 == -1 && words[i].equals(word2)) {
                    prev2 = i;
                    if (prev1 != -1) {
                        res = Math.min(res, i - prev1);
                    } // END of if
                    continue;
                } // END of if

                if (word1.equals(words[i])) {
                    res = Math.min(res, i - prev2);
                    prev1 = i;
                } // END of if

                if (word2.equals(words[i])) {
                    res = Math.min(res, i - prev1);
                    prev2 = i;
                } // END of if

            } // END of for i

        }


    }
}
