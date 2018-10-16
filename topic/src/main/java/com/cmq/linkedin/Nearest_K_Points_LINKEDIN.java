package LinkedIn;

import java.util.*;

public class Nearest_K_Points_LINKEDIN {


    class Point{
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    /* method, my own version */
    public List<Point> findNearestPoints_own_quickSelect(Point point, int k, Point[] points) {
        List<Point> list = new ArrayList<>();
        if (k <= 0) return list;

        int lo = 0, hi = points.length - 1;
        while(lo < hi) {

        }
    }

    /* method 1 */
    /*
    use priority queue : O(nlogn)
     */
    public List<Point> findNearestPoints(Point point, int k, Point[] points) {
        List<Point> result = new ArrayList<>();
        if (k <= 0) {
            return result;
        }
        PriorityQueue<Point> maxDistance = new PriorityQueue<>(k, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                int distance1 = distance(p1, point);
                int distance2 = distance(p2, point);
                return distance2 - distance1;
            }
        });
        for (Point poi : points) {
            if (maxDistance.size() < k) {
                maxDistance.add(poi);
                continue;
            }
            int curDis = distance(poi, point);
            int maxDis = distance(maxDistance.peek(), point);
            if (curDis < maxDis) {
                maxDistance.poll();
                maxDistance.add(poi);
            }
        }
        while (!maxDistance.isEmpty()) {
            result.add(maxDistance.poll());
        }
        return result;
    }

    private int distance(Point p1, Point p2) {
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
    }



    /* method 2 */
    /* use quick select : O(n)
    * */
    public Point findNearestKthPoint(Point[] points, int k) {
        if (k > points.length || k == 0) {
            throw new IllegalArgumentException("K's value is illegal\n");
        }
        return quickSelect(points, 0, points.length - 1, k - 1);
    }


    private Point quickSelect(Point[] points, int left, int right, int k) {
        Random rand = new Random();
        int pivotIndex = 0;
        if (right != 0) {
            pivotIndex = rand.nextInt(right) % (right - left + 1) + left;
        }
        pivotIndex = partition(pivotIndex, points, left, right);
        if (pivotIndex == k) {
            return points[k];
        }
        else if (pivotIndex > k) {
            return quickSelect(points, left, pivotIndex - 1, k);
        }
        else {
            return quickSelect(points, pivotIndex + 1, right, k);
        }
    }

    private int partition(int pivotIndex, Point[] points, int left, int right) {
        int i = left;
        int j = right;
        Point temp = points[pivotIndex];
        int tempDistance = distance(temp);
        swap(points, left, pivotIndex);
        while (i < j) {
            while (j > i && distance(points[j]) >= tempDistance) {
                j--;
            }
            points[i] = points[j];
            while (j > i && distance(points[i]) <= tempDistance) {
                i++;
            }
            points[j] = points[i];
        }
        points[i] = temp;
        return i;
    }

    private int distance(Point point) {
        return point.x * point.x + point.y * point.y;
    }

    private void swap (Point[] points, int index1, int index2) {
        Point temp = points[index1];
        points[index1] = points[index2];
        points[index2] = temp;
    }

    /**
     * another version from github : https://github.com/tongzhang1994/Facebook-Interview-Coding/blob/master/Find%20K%20Closest%20Points.java
     */



//    重点看第二种方法！记住
//
//    Solution 1： MAX Heap
//    Time: O(nlogk)    Space: O(k)

    public Point[] findKClosestPoints(Point[] points, int k, Point target) {
        if (points == null || points.length == 0 || k < 1 || k > points.length)   return points;
        Queue<Point> pq = new PriorityQueue<>(k, new Comparator<Point>(){
            public int compare(Point p1, Point p2) {
                int d1 = (p1.x - target.x) * (p1.x - target.x) + (p1.y - target.y) * (p1.y - target.y);
                int d2 = (p2.x - target.x) * (p2.x - target.x) + (p2.y - target.y) * (p2.y - target.y);
                return d2 - d1;
            }
        });
        for (Point p : points) {
            pq.offer(p);
            if (pq.size() > k)
                pq.poll();
        }
        Point[] res = new Point[k];
        for (int i = k - 1; i >= 0; i--)
            res[i] = pq.poll();
        return res;
    }


//    Solution 2: QuickSelect
//    Time: O(n) average, O(n + klogk) time if output is sorted;  O(n^2) worst case
//    Space: O(1)

    public Point[] findKClosestPoints(Point[] points, int k, Point target) {
        if (points.length == 0 || k < 1 || k > points.length)   return points;
        int left = 0, right = points.length - 1;
        while (true) {
            int pos = partition(points, left, right, target);
            if (pos == k - 1)   break;
            else if (pos > k - 1)   right = pos - 1;
            else    left = pos + 1;
        }
        Point[] res = new Point[k];
        for (int i = 0; i < k; i++)
            res[i] = points[i];
        return res;
    }

    private int partition(Point[] points, int left, int right, Point target) {
//        shuffle(points);
        int idx = left; // important
        Point pivot = points[idx];
        int pDist = getDistance(pivot, target);
        swap(points, idx, right);
        for (int i = left; i < right; i++) {
            int iDist = getDistance(points[i], target);
            if (iDist < pDist)  swap(points, i, idx++);
        }
        swap(points, idx, right);
        return idx;
    }

    private int getDistance(Point p, Point target) {
        return (p.x - target.x) * (p.x - target.x) + (p.y - target.y) * (p.y - target.y);
    }

    private static void swap(Point[] points, int left, int right) {
        Point temp = points[left];
        points[left] = points[right];
        points[right] = temp;
    }
}
