package com.cmq.linkedin.mine;

/*
Question:
看括号是否是闭合的
)()()()    ---->   true
(+1^$#)(#$)  ----> true
)(   ----->false
(()#%33  ----->false

 */
public class valid_parenthese_modified {

    public static void main(String[] args) {
        boolean rs = isValid(")()()()");
        System.out.println("");
    }
    public static boolean isValid(String input) {
        int count = 0;
        for (char c : input.toCharArray()) {
            if (c == '(')
                count++;
            else if (c == ')') {
                if (count == 0) // notes for the if-judge here
                    return false;
                count--;
            }
        }
        return count == 0;
    }
}

