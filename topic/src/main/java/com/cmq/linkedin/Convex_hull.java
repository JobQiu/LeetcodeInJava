/*
package com.cmq.linkedin;

*/
/*

真的是平生第一次看到这个题，看到之后傻了半天，后来给了O(n^2)的算法，manager问time complexity，然后说有更好的算法O(nlogn)。
我说看起来像divide-and-conquer，可是也没有想明白具体怎么做。我说能给点提示吗？manager说他也不确定这样work不work。然后说不能给提示，但是过了5秒，
manager自己走到白板前，刷刷刷的从头到尾把算法讲出来了。。。这几天在家看书发现好几本算法书上都有讲这个（不过都在很后面的章节），愧叹还是用功不到位！


// convex hull
// http://www.geeksforgeeks.org/convex-hull-set-2-graham-scan/
// find the most left buttom point,
// find all the remain points that three of them form a counter clockwise line
 *//*



import java.util.*;

public class Convex_hull {

    class Point {
        int x;
        int y;
    }

    public List<Point> convexHull(Point[] points) {
        List<Point> hull = new ArrayList<>();
        if (points == null && points.length == 0) {
            return hull;
        }
        int yMin = points[0].y;
        int minIndex = 0;
        for (int i = 1; i < points.length; i++) {
            if (points[i].y < yMin || (points[i].y == yMin && points[i].x < points[minIndex].x)) {
                yMin = points[i].y;
                minIndex = i;
            }
        }
        Point temp = points[minIndex];
        points[minIndex] = points[0];
        points[0] = temp;

        Arrays.sort(points, 1, points.length, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                int orientation = orientation(points[0], p1, p2);
                if (orientation == 1) {
                    return -1;
                } else if (orientation == 2) {
                    return 1;
                }
                return 0;
            }
        });
        int maxIndex = 1;
        for (int i = 1; i < points.length; i++) {
            while (i < points.length - 1 && orientation(points[0], points[i], points[i + 1]) == 0) {
                i++;
            }
            points[maxIndex++] = points[i];
        }
        if (maxIndex < 3) {
            return hull;
        }
        Stack<Point> stack = new Stack<>();
        for (int i = 0; i < 3; i++) {
            stack.push(points[i]);
        }
        for (int i = 3; i < maxIndex; i++) {
//            prev = nextTop(stack);
//            cur = stack.peek();
//            next = points[i];
            while (orientation(nextTop(stack), stack.peek(), points[i]) != 1) {
                stack.pop();
            }
            stack.push(next);
        }
        while (!stack.isEmpty()) {
            hull.add(stack.pop());
        }
        return hull;
    }

    private Point nextTop(Stack<Point> stack) {
        Point top = stack.pop();
        Point result = stack.peek();
        stack.push(top);
        return result;
    }

    // linear -> 0
    // p, q, r form a counterClock -> 1
    // p, q, r form a clockwise -> 2
    // k1 = (p.y - q.y) / (p.x - q.x) k2 = (q.y - r.y) / (q.x - r.x)
    // k2 == k1 -> linear
    // k2 > k1 -> counterClockWise, turn left
    // k2 < k1 -> clockWise, turn right
    private int orientation(Point p, Point q, Point r) {
        int value = (p.y - q.y) * (q.x - r.x) - (q.y - r.y) * (p.x - q.x);
        if (value == 0) {
            return 0;
        }
        return value > 0 ? 2 : 1;
    }
}
*/
