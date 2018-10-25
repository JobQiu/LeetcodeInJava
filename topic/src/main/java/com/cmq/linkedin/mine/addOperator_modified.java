package com.cmq.linkedin.mine;

import com.cmq.util.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/* *
Question:
like 282, expression add operations, but we add an extra operations "/" here

    // T(N) = 3 * (T(N - 1) + T(N -2) + .... + T(1))
    // T(N - 1) = 3 * (T(N - 2) + T(N - 3) + .... + T(1))
    // T(N) = (4 * T(N -1))
    // T(N) = 4 ^ (N -1)
    // time complexity: O(4 ^ n)
 */
public class addOperator_modified {


    public String frequencySort(String s) {

        int[] count = new int[128];

        for (char c : s.toCharArray()) {
            count[c]++;
        } // END of for

        int max = 0;
        for (int i = 0; i < 128; i++) {
            max = Math.max(max, count[i]);
        } // END of for i

        ArrayList<Character>[] charList = new ArrayList[max + 1];

        for (int n : count) {
            if (charList[n] == null) {
                charList[n] = new ArrayList<Character>();
            } // END of if
            charList[n].add((char) (n));
        } // END of for

        StringBuilder sb = new StringBuilder();
        for (int i = max - 1; i > 0; i--) {
            if (charList[i] == null) {
                continue;
            } // END of if
            for (Character c : charList[i]) {
                for (int j = 0; j < i; j++) {
                    sb.append(c.toString());
                } // END of for j
            } // END of for
        } // END of for i
        Deque<TreeNode> dq = new LinkedList<>();

        return sb.toString();

    }

    public List<String> addOperators(String num, int target) {
        List<String> list = new ArrayList<>();
        if (num.length() == 0) return list;
        add(num, (long) target, list, "", 0, 0L, 0L);
        return list;
    }

    private void add(String num, long target, List<String> list, String expr, int pos, long prev, long mult) {
        if (num.length() == pos && target == prev)
            list.add(expr);
        else {
            for (int i = pos; i < num.length(); i++) {
                if (i != pos && num.charAt(pos) == '0') return;
                long curr = Long.parseLong(num.substring(pos, i + 1));
                if (pos == 0)
                    add(num, target, list, expr + curr, i + 1, curr, curr);
                else {
                    add(num, target, list, expr + "+" + curr, i + 1, curr + prev, curr);
                    add(num, target, list, expr + "-" + curr, i + 1, prev - curr, -curr);
                    add(num, target, list, expr + "*" + curr, i + 1, prev - mult + mult * curr, mult * curr);
                    /* need to check if curr is 0, as 0 is undividable */
                    if (curr != 0) {
                        add(num, target, list, expr + "/" + curr, i + 1, prev - mult + mult / curr, mult / curr);
                    }

                }
            }
        }
    }


}
