package com.cmq;

import java.util.*;

/**
 * @author xavier.qiu
 * 10/25/18 11:35 AM
 */
public class TestMain {

    class TestNode{

    }

    public static void main(String[] args) {
        TestNode t = new TestNode();

        List<Integer> list1 = new ArrayList();
        list1.add(1);
        list1.add(1);
        list1.add(1);
        list1.add(2);

        List<Integer> list2 = new ArrayList();
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(1);

        List<Integer> list3 = new ArrayList();
        list3.add(3);
        list3.add(3);
        list3.add(3);
        list3.add(3);
        minCost(4,list1,list2,list3);

    }


    static int result = Integer.MAX_VALUE;

    public static int minCost(int gNodes,
                              List<Integer> gFrom,
                              List<Integer> gTo,
                              List<Integer> gWeight) {

        // 1. we can create any edge to be 1
        // 2. we cannot

        Map<Integer, Boolean> visited = addOnes(gFrom, gTo, gWeight, gNodes);

        dfs(0, 1, gFrom, gTo, gWeight, gNodes, visited);

        return result == Integer.MAX_VALUE ? 1 : result;


    }

    private static Map<Integer, Boolean> addOnes(List<Integer> gFrom,
                                                 List<Integer> gTo,
                                                 List<Integer> gWeight,
                                                 int gNodes) {

        Set<Integer> set = new HashSet();

        for (int i : gFrom) {
            set.add(i);
        } // END of for

        for (int i : gTo) {
            set.add(i);
        } // END of for

        set.add(gNodes);
        // after this, set will contain all the number

        // set to list
        List<Integer> list = new ArrayList();
        for (int i : set) {
            list.add(i);
        } // END of for

        Map<Integer, Set<Integer>> map = new HashMap();

        for (int i = 0; i < gFrom.size(); i++) {
            if (!map.containsKey(gFrom.get(i))) {
                map.put(gFrom.get(i), new HashSet<Integer>());
            } // END of if
            map.get(gFrom.get(i)).add(gTo.get(i));
        } // END of for i

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i == j) {
                    continue;
                } // END of if

                int from = list.get(i);
                int to = list.get(j);

                if (!map.containsKey(from)) {
                    map.put(from, new HashSet<Integer>());
                } // END of if

                if (!map.containsKey(to)) {
                    map.put(to, new HashSet<Integer>());
                } // END of if
                if (map.get(from).contains(to) || map.get(to).contains(from)) { // here
                    continue;
                } // END of if
                else {
                    gFrom.add(from);
                    gTo.add(to);
                    gWeight.add(1);

                }
            } // END of for j
        } // END of for i

        Map<Integer, Boolean> visited = new HashMap();
        for (int i : list) {
            visited.put(i, false);
        } // END of for

        return visited;

    }

    private static void dfs(int curSum,
                            int curNode,
                            List<Integer> gFrom,
                            List<Integer> gTo,
                            List<Integer> gWeight,
                            int gNodes,
                            Map<Integer, Boolean> visited) {

        if (curSum > result) {
            return;
        } // END of if

        // check if reached the
        if (curNode == gNodes) {
            if (curSum < result) {
                result = curSum;
            } // END of if
            return;
        } // END of if

        visited.put(curNode, true);
        for (int i = 0; i < gFrom.size(); i++) {
            if (gFrom.get(i) == curNode && !visited.get(gTo.get(i))) {
                dfs(curSum + gWeight.get(i), gTo.get(i), gFrom, gTo, gWeight, gNodes, visited);
            } // END of if
        } // END of for

        visited.put(curNode, false);

    }


}
