package com.cmq.linkedin;


/*
Question:
第二道是新题，给multidimensional array，给一个function， 输入这个array以及各个dimension上的index，可以output这个位置上的数字。
写一个function，input是multidimensional array，以及array的dimensions，只能调用上面给的那个function，输出这个array里面所有的数字的和。
题不难，是我当时脑子懵了，一直在想怎么找这个array的各个dimension上的boundary，其实input就给了。和面试官一直在交流，但我没说好，十几分钟一直在纠结这个问题。
后来面试官举了个例子，立刻反应过来了。但也没有什么时间，就草草的说了下pseudo code，用dfs做所有dimension上的不同index的combination，然后调用那个function求和。


so 我感觉像是 combination 或者permutation那种类型的 backtrack题目的变式


题目其实就是散散就，但是换了个形式出出来，楼主真的实力不济，一直没想到用recursion，一直在loop上纠结，最后都没出来。
. visit 1point3acres for more.
给一个MultiDimArray interface, 然后给一个MultiDimArray和一个Dim array，求MultiDimArray 的sum。Dim array表示每个dimension有多少个element。中规中矩，换了个马甲就没写出来，服了自己。.1point3acres网

interface MultiDimArray {
  int getValue(int[] indexes);
}

int getSum(MultiDimArray arr, int[] dim) {
}



 */
interface MultiDimArray {
    int getValue(int[] indexes);
}

public class Multidimensional_Array {
    int getSum(MultiDimArray arr, int[] dim) {
        if (dim.length == 0) return 0;
        return getSum(arr, dim, 0);
    }

    private int getSum(MultiDimArray arr, int[] dim, int pos) {
        int sum = 0;
        if (pos >= dim.length) return 0;

        for (int i = 1; i <= dim[pos]; i++) {
            dim[pos] -= i;
            sum += arr.getValue(dim) + getSum(arr, dim, pos + 1);
            dim[pos] += i;
        }

        return sum;
    }


    /* combination method */
    private int sum;

    int getSum_combination(MultiDimArray arr, int[] dim) {
        int[] index = new int[dim.length];
        sum = 0;
        getSum(arr, dim, index, 0);
        return sum;
    }

    private void getSum(MultiDimArray arr, int[] dim, int[] index, int pos) {
        if (pos == dim.length) {
            sum += arr.getValue(index);
        } else {
            for (int i = 0; i <= dim[pos]; i++) {
                index[pos] = i;
                getSum(arr, dim, index, pos + 1);
                index[pos] = 0;
            }
        }
    }
}