package com.cmq.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author xavier.qiu
 * 10/11/18 1:55 AM
 */
public class LT056 {

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        List<Interval> list = new ArrayList();
        list.add(new Interval(1, 3));
        list.add(new Interval(2, 4));
        list.add(new Interval(1, 6));

        Collections.sort(list, (i1,i2)->i1.start - i2.start);
        System.out.println("");

    }
}
