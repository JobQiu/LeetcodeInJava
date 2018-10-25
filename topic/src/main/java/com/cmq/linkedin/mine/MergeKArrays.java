package com.cmq.linkedin.mine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*

* time : O(nlogn)
* merge k sorted arrays
* */
public class MergeKArrays {
    public List<Integer> mergeKArrays(List<List<Integer>> input) {
        PriorityQueue<Number> pq = new PriorityQueue<>(
                Comparator.comparingInt((Number a) -> a.value)
        );
        List<Integer> list = new ArrayList<>();

        /* add the head of each list into pq*/
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).size() == 0)
                continue;
            pq.add(new Number(input.get(i).get(0), 0, i));
        }

        while (!pq.isEmpty()) {
            Number min = pq.poll();
            list.add(min.value);


            /* refer to the solution of pairs, add one by one, so only need to add*/
            if (min.index < input.get(min.listIndex).size() - 1) {
                pq.add(new Number(input.get(min.listIndex).get(min.index + 1), min.index + 1, min.listIndex));
            }

        }

        return list;

    }

    private class Number {
        int value;
        int index;
        int listIndex;

        public Number(int value, int index, int listIndex) {
            this.value = value;
            this.index = index;
            this.listIndex = listIndex;
        }
    }
}
