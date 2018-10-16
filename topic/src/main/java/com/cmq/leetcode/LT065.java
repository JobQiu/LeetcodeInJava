package com.cmq.leetcode;

/**
 * @author xavier.qiu
 * 10/14/18 6:48 PM
 */
public class LT065 {



    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(-Integer.MIN_VALUE);
        System.out.println(Integer.MIN_VALUE / -2);

        System.out.println(-Integer.MAX_VALUE);

        System.out.println(-5/2);
    }


    public boolean isNumber(String s) {

        s = s.trim();

        // split the string to two part if contains e

        // [-+ numbers . numbers]
        // e
        // [+- numbers]

        int indexOfE = -1;

        // find the location of E
        for (int i = 0; i < s.length(); i++) { // END of for i
            char c = s.charAt(i);
            if (c == 'e') {
                if (indexOfE != -1) {
                    return false;
                } // END of if
                indexOfE = i;
            } // END of if
        } // END of for


        return indexOfE == -1 ?
                isNumberWithoutE(s, true) :
                isNumberWithoutE(s.substring(0, indexOfE), true) && isNumberWithoutE(s.substring(indexOfE + 1), false);


    }

    /***
     *
     *
     * @param beforeE if this part is before
     * @return
     * @throws
     **/
    private boolean isNumberWithoutE(String s, boolean beforeE) {

        if (s == null || s.length() == 0) {
            return false;
        } // END of if

        int start = 0;
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            start++;
        } // END of if

        boolean seenDot = false;
        boolean seenNumber = false;
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                seenNumber = true;
                continue;
            } // END of if
            else if (c == '.') {
                // return false if it's the part after e and there is a dot
                if (!beforeE) {
                    return false;
                } // END of if
                if (seenDot) {
                    return false;
                } // END of if
                else {
                    seenDot = true;
                    continue;
                }
            } // END of if
            else {
                return false;
            }
        } // END of for i

        // return false if there are no numbers in this part, for example -.
        return seenNumber ? true : false;
    }
}
