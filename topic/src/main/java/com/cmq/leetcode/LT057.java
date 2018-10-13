package com.cmq.leetcode;

import com.cmq.util.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xavier.qiu
 * 10/12/18 6:41 PM
 */
public class LT057 {

    public static void main(String[] args) {
        List<Interval> list = new ArrayList();
        list.add(new Interval(1,3));
        list.add(new Interval(6,9));

//        list.add(new Interval(1, 2));
//        list.add(new Interval(3, 5));
//        list.add(new Interval(6, 7));
//        list.add(new Interval(8, 10));
//        list.add(new Interval(12, 16));

        Interval target = new Interval(2, 5);
        insert(list, target);

    }

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        if (intervals == null || newInterval == null) return result;
        int iStart = findStartPos(intervals, newInterval.start);
        int iEnd = findEndPos(intervals, newInterval.end);
        if (iStart > 0 && intervals.get(iStart - 1).end >= newInterval.start) iStart--;
        if (iEnd == intervals.size() || intervals.get(iEnd).start > newInterval.end) iEnd--;

        //If not in the corner cases, this condition should apply.
        if (iStart <= iEnd) {
            newInterval = new Interval(Math.min(newInterval.start, intervals.get(iStart).start),Math.max(newInterval.end, intervals.get(iEnd).end));
        }

        int i = 0;
        while (i < iStart) result.add(intervals.get(i++));
        result.add(newInterval);
        i = iEnd + 1;
        while (i < intervals.size()) result.add(intervals.get(i++));
        return result;
    }

    private static int findStartPos(List<Interval> intervals, int value) {
        int l = 0, r = intervals.size() - 1;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (intervals.get(m).start == value) return m;
            else if (intervals.get(m).start < value) l = m + 1;
            else r = m - 1;
        }
        return l;
    }

    private static int findEndPos(List<Interval> intervals, int value) {
        int l = 0, r = intervals.size() - 1;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (intervals.get(m).end == value) return m;
            else if (intervals.get(m).end < value) l = m + 1;
            else r = m - 1;
        }
        return l;
    }


    public static List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
        List<Interval> list = new ArrayList();
        if (intervals == null || intervals.size() == 0) {
            list.add(newInterval);
            return list;
        } // END of if
        int length = intervals.size();

        if (newInterval.start > intervals.get(length - 1).end) {
            intervals.add(newInterval);
            return intervals;
        } // END of if

        if (newInterval.end < intervals.get(0).start) {
            intervals.add(0, newInterval);
            return intervals;
        } // END of if

        int[] starts = new int[length];
        int[] ends = new int[length];

        for (int i = 0; i < length; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        } // END of for i


        // 1. search the insert position of newInterval
        int endInStart = insertPos(starts, newInterval.end); // 4
        int startInEnd = insertPos(ends, newInterval.start); // 1

        // intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
        for (int i = 0; i < startInEnd; i++) {
            list.add(intervals.get(i));
        } // END of for i

        list.add(new Interval(
                Math.min(newInterval.start, intervals.get(startInEnd).start),
                Math.max(newInterval.end, intervals.get(Math.min(endInStart,length-1)).end)));


        for (int i = endInStart + 1; i < length; i++) {
            list.add(intervals.get(i));
        } // END of for i

        return list;
    }

    private static int insertPos(int[] nums, int target) {

        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                return mid;
            } // END of if
            if (nums[mid] > target) {
                hi = mid;
            } // END of if
            else {
                lo = mid + 1;
            }
        } // END of while

        return lo;

    }
}
