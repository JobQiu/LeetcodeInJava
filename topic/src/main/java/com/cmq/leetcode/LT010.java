package com.cmq.leetcode;

/**
 * @author xavier.qiu
 * 10/7/18 7:29 PM
 */
public class LT010 {

    public static void main(String[] args) {
        String s = "mississippi";
        String p = "mis*is*ip*.";
        //s = "aab";
        //p = "c*a*b";

        isMatch(s,p);
    }


    public static boolean isMatch(String s, String p) {

        //      m i s s i s s i p p i
        // m    1 0 0 0 0 0 0 0 0 0 0
        // i    0 1 0 0 0 0 0 0 0 0 0
        // s    0 0 1 0 0 0 0 0 0 0 0
        // *    0 0 1 1 0 0 0 0 0 0 0
        // i    0 0 0 0 1 0 0 0 0 0 0
        // s    0 0 0 0 0 1 0 0 0 0 0
        // *    0 0 0 0 1 1 1 0 0 0 0
        // p    0 0 0 0 0 0 0 0 0 0 0
        // *    0 0 0 0 0 0 0 0 0 0 0
        // .    0 0 0 0 0 0 0 0 0 0 0
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                    }
                }
            }
        }
        System.out.print("  ");
        for(int i = 0; i < p.length() ; i++){
            System.out.print(p.charAt(i));
        } // END of for i
        System.out.println("");
        for(int i = 0; i <= s.length() ; i++){
            if( i==0){
                System.out.print(" ");
            } // END of if
            else {
                System.out.print(s.charAt(i-1));
            }
            for(int j = 0; j <= p.length() ; j++){

                if(dp[i][j]){
                    System.out.print("1");
                } // END of if
                else System.out.print("0");
            } // END of for j
            System.out.println("");
        } // END of for i

        return dp[s.length()][p.length()];
    }
}
