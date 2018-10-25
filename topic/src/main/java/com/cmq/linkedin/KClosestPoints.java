package com.cmq.linkedin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xavier.qiu
 * 10/23/18 12:02 AM
 */
public class KClosestPoints {

    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public List<Point> KClosestPoints_(Point[] arr, int k) {


        List<Point> list = new ArrayList();


        return list;

    }

    public static int partition(Point[] arr, int lo, int hi, double[] distances) {

        double pivot = distances[lo];
        lo = lo + 1;
        while (lo < hi) {


        }

        return lo;

    }

    public static int partition(int lo, int hi, double[] distances) {

        double pivot = distances[lo];
        int lo2 = lo;
        lo++;

        // quick sort the distance [lo+1, hi] according to the pivot,
        while (lo < hi) {
            while (lo < hi && distances[lo] < pivot) {
                lo++;
            } // END of while
            while (lo < hi && distances[hi] > pivot) {
                hi--;
            } // END of while

            swap(distances, lo, hi);

        } // END of while
        swap(distances, lo2, lo - 1);
        // after this, the first several numbers are less than pivot and the last several numbers are larger than pivot.

        return lo;
    }

    public static double distance(Point a, Point b) {
        return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
    }

    public void swap(Point[] points, int a, int b) {
        Point temp = points[a];
        points[a] = points[b];
        points[b] = temp;
    }

    public static void swap(double[] indices, int a, int b) {
        double temp = indices[a];
        indices[a] = indices[b];
        indices[b] = temp;

    }

    public void swap(int[] indices, int a, int b) {
        int temp = indices[a];
        indices[a] = indices[b];
        indices[b] = temp;

    }

    static Map<Character, String> map = new HashMap();

    static {
        map.put('g', "0000");
        map.put('l', "0001");
        map.put('r', "0010");
        map.put('t', "0011");
        map.put('i', "010");
        map.put('n', "011");
        map.put('a', "100");
        map.put('s', "101");
        map.put(' ', "110");
        map.put('A', "111000");
        map.put('e', "111001");
        map.put('h', "111010");
        map.put('m', "111011");
        map.put('o', "111100");
        map.put('y', "111101");
        map.put('d', "11111");

    }

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        String test2 = "Algorithms design and analysis is an art";
        Map<Character, Integer> map2 = new HashMap();

        for (int i = 0; i < test2.length(); i++) {
            //map.put(test2.charAt(i), map.getOrDefault(test2.charAt(i), 0) + 1);
            if (map.get(test2.charAt(i)) == null) {
                System.out.println(test2.charAt(i));
            } // END of if
            sb.append(map.get(test2.charAt(i)));
        } // END of for i


        double[] test = new double[]{5, 2, 7, 4, 3, 6};
        int k = partition(0, test.length - 1, test);

        double res = distance(new Point(1, 2), new Point(2, 2));
        System.out.println("" +
                "");

    }
}
