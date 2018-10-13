package com.cmq.leetcode;

/**
 * @author xavier.qiu
 * 10/12/18 3:02 PM
 */
public class LT767 {

    public static void main(String[] args) {
        String test = "snnnnbpngobwznvnnnlnwhvnnnnfjnnlnnnnnnbnknnqkndzefncknnnnnaiqrntnndnnnjninnnunnunqhndnnqnnsjqnnpiqshntnnncnvnnnncnnqenlnninyndnnnljongnnjwnnnngllnnngkbnllnnnnontlbpngjnnenqnsnnnnnjeqqghnfpngepnodnnnnnnvnsrnughbnipvnhqmnzonoonnnjotnnonoennnpnfnnkdnnbmnmnpnqninnxronnnnvnlanlnnnebnnnlnvnfknsnbincnttnmnguqenhnnxunnnntnnnnhnqnzehvunfnvnndvnjnnnbnnpxnqipwnmnonnndlnsnonnninnxnnnjnnnnnesennmyiednnnnnnnnnhimtnnnonjlicnwnwvnntaxmnrntnnnnsnbnanninnecbcfjxncnnkvnnqgnunensanpnngjnzxjnopnnyvnnxskniyytnsnnnnx";
        String res = reorganizeString(test);
    }


    public static String reorganizeString(String S) {

        if (S == null || S.length() == 0) {
            return "";
        } // END of if

        char[] cs = S.toCharArray();
        int[] count = new int[26];
        for (char c : cs) {
            count[c - 'a']++;
        } // END of for

        java.util.Arrays.sort(count); //Collections.reverseOrder()
        int sum = 0;
        for (int i = 24; i >= 0; i--) {
            sum += count[i];
        } // END of for i

        if (sum < count[25] - 1) {
            return "";
        } // END of if

        StringBuilder sb = new StringBuilder();
        while (count[25] > 0) {
            int start = 25;
            while (start>=0 && count[start] > 0) {
                sb.append('a' + start);
                count[start]--;
                start--;

            } // END of while
        } // END of while

        return sb.toString();
    }
}
