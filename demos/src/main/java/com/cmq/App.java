package com.cmq;

import java.util.*;

/**
 * Hello world!
 */
public class App {


    public static int time2(int[][] grid) {
        Set<String> expanded = new HashSet();
        // {1,2} {1,2}
        PriorityQueue<int[]> pq = new PriorityQueue<>((i1, i2) -> {
            return i1[2] - i2[2];
        });
        int row = grid.length, col = grid[0].length;
        pq.add(new int[]{0, 0, grid[0][0]});
        int max = Integer.MIN_VALUE;
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int i = temp[0];
            int j = temp[1];

            max = Math.max(max,temp[2]);

            if (i == row - 2 && j == col - 1) {
                return Math.max(max, grid[row - 1][col - 1]);
            } // END of if


            if (i == row - 1 && j == col - 2) {
                return Math.max(max, grid[row - 1][col - 1]);
            } // END of if


            add2Pq(grid, i + 1, j, expanded, pq);
            add2Pq(grid, i - 1, j, expanded, pq);
            add2Pq(grid, i, j + 1, expanded, pq);
            add2Pq(grid, i, j - 1, expanded, pq);

            expanded.add(temp[0] + "," + temp[1]);
            System.out.println(pq.peek()[0] + " " + pq.peek()[1] + " " + pq.peek()[2]);

        } // END of while

        return -1;


    }

    private static void add2Pq(int[][] grid, int i, int j, Set<String> expanded, PriorityQueue<int[]> pq) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || expanded.contains(i + "," + j)) {
            return;
        } // END of if

        pq.add(new int[]{i, j, grid[i][j]});


    }

    public static int time(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        Set<int[]> set = new HashSet();
        set.add(new int[]{0, 0});
        int max = Integer.MIN_VALUE;
        int row = grid.length, col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                max = Math.max(max, grid[i][j]);
            } // END of for j
        } // END of for i

        for (int t = 0; t <= max; t++) {

            Set<int[]> set2 = new HashSet(set);

            for (int[] ii : set2) {
                dfs(grid, ii[0], ii[1], t, set, new HashSet<int[]>());
            } // END of for

            if (set.contains(new int[]{row - 1, col - 1})) {
                return t;
            } // END of if
        } // END of for i

        return -1;


    }

    private static void dfs(int[][] grid, int i, int j, int waterDepth, Set<int[]> set, Set<int[]> visited) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || set.contains(new int[]{i, j}) || visited.contains(new int[]{i, j})) {
            return;
        } // END of if

        if (grid[i][j] <= waterDepth) {
            set.add(new int[]{i, j});
        } // END of if

        dfs(grid, i + 1, j, waterDepth, set, visited);
        visited.add(new int[]{i + 1, j});
        dfs(grid, i - 1, j, waterDepth, set, visited);
        visited.add(new int[]{i - 1, j});

        dfs(grid, i, j + 1, waterDepth, set, visited);
        visited.add(new int[]{i, j + 1});

        dfs(grid, i, j - 1, waterDepth, set, visited);
        visited.add(new int[]{i, j - 1});


    }

    public static class Node {
        int freq;
        int value;

        public Node(int freq, int value) {
            this.freq = freq;
            this.value = value;
        }
    }

    public static void main(String[] args) {

        Set<int[]> set = new HashSet();
        set.add(new int[]{1, 2});
        set.add(new int[]{1, 2});

        int[][] grid = new int[][]{
                {0, 1, 2, 3, 4},
                {24, 23, 22, 21, 5},
                {12, 13, 14, 15, 16},
                {11, 17, 18, 19, 20},
                {10, 9, 8, 7, 6}
        };

        int res = time2(grid);

        Map<Integer, Node> map = new HashMap();
        PriorityQueue<Node> pq = new PriorityQueue<>((i1, i2) -> -i1.freq + i2.freq);

        Node n1 = new Node(3, 1);
        Node n2 = new Node(4, 2);

        // 2 should be in front of 1
        pq.add(n1);
        pq.add(n2);
        System.out.println(pq.peek().value);

        n1.freq = 10;
        System.out.println(pq.peek().value);


        Collections.shuffle(new ArrayList<>());
        String[] test = {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
                "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};

        int maxWidth = 20;
        fullJustify(test, maxWidth);
        System.out.println("");
        test = new String[]{"What", "must", "be", "acknowledgment", "shall", "be"};
        maxWidth = 16;
        fullJustify(test, maxWidth);
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList();

        int start = 0;
        while (start < words.length) {
            int end = start;
            int lineLen = 0;
            while (end < words.length && lineLen + words[end].length() <= maxWidth) {
                lineLen += words[end].length() + 1;
                end++;
            } // END of while
            for (int i = start; i < end; i++) {
                System.out.print(words[i]);
            } // END of for i
            list.add(correctLine(words, start, end, maxWidth, lineLen));

            System.out.println("");

            start = end;
        } // END of while


        return list;
    }

    private static String correctLine(String[] words, int start, int end, int maxWidth, int lineLen) {
        StringBuilder sb = new StringBuilder();

        if (end - start == 1) {
            sb.append(words[start]);

            System.out.print(" lenth = 1 " + sb.toString());

        } // END of if
        else if (end == words.length) {
            System.out.print(" last line");
            for (int i = start; i < end - 1; i++) {
                sb.append(words[i] + " ");
            } // END of for i
            sb.append(words[end - 1]);


        } // END of if
        else {
            int numOfWords = end - start;
            int numOfSpace = maxWidth - lineLen + end - start;
            int spaceBase = numOfSpace / (numOfWords - 1);
            int spaceExtra = numOfSpace % (numOfWords - 1);

            for (int i = start; i < end - 1; i++) {
                sb.append(words[i]);
                for (int j = 0; j < spaceBase; j++) {
                    sb.append(" ");
                } // END of for j
                if (spaceExtra-- > 0) {
                    sb.append(" ");
                } // END of if
            } // END of for i
            sb.append(words[end - 1]);

            System.out.print(" normal situation");
        }


        while (sb.length() < maxWidth) {
            sb.append(" ");
        } // END of while

        return sb.toString();
    }
}
