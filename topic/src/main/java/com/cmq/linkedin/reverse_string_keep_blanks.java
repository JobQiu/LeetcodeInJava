package com.cmq.linkedin;

public class reverse_string_keep_blanks {

    /* version of keep number of blanks*/
    public String reverseWords_keepBlanks(String s) {
        s = s.trim();
        if (s.length() == 0) return s;
        int left = 0, right = 0;
        StringBuilder sb = new StringBuilder();
        while(right < s.length()) {
            while(right < s.length() && s.charAt(right) != ' ')   right++;
            right--;
            reverse(s, left, right, sb);
            left = right + 1;
            while(left < s.length() && s.charAt(left) == ' ') {
                left++;
                sb.append(" ");
            }
            right = left;
        }


        return sb.reverse().toString();
    }

    private void reverse(String s, int left, int right, StringBuilder sb) {
        if (left > right) return;
        for (int i = right; i >= left; i--) {
            sb.append(s.charAt(i));
        }
    }
}
