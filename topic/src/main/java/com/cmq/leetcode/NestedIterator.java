package com.cmq.leetcode;

import java.util.*;

/**
 * @author xavier.qiu
 * 10/16/18 11:12 PM
 */
public class NestedIterator implements Iterator<Integer> {

    public static void main(String[] args) {
        System.out.println("" +
                "");

    }

    Deque<NestedInteger> dq;

    public NestedIterator(List<NestedInteger> nestedList) {
        dq = new LinkedList();
        pushListToDq(nestedList);
    }


    @Override
    public Integer next() {
        return dq.removeFirst().getInteger();

    }

    @Override
    public boolean hasNext() {
        if (!dq.isEmpty()) {
            NestedInteger temp = dq.peekFirst();
            if (!temp.isInteger()) {
                pushListToDq(temp.getList());
            } // END of if
            return true;

        } // END of if
        return false;

    }

    private void pushListToDq(List<NestedInteger> nestedList) {
        nestedList = new ArrayList(nestedList); // o(size of nested list)
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            dq.addFirst(nestedList.get(i));
        } // END of for i
    }
}
