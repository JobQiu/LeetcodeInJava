package com.cmq.linkedin.mine;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Questiion:
Given three sorted arrays A[], B[] and C[], find 3 elements i, j and k from A, B and C respectively such that
max(abs(A – B[j]), abs(B[j] – C[k]), abs(C[k] – A)) is minimized. Here abs() indicates absolute value.
Example :
Input:
 A[] = {1, 4, 10}
 B[] = {2, 15, 20}
 C[] = {10, 12}
Output: 10 15 10. 10 from A, 15 from B and 10 from C
Input: A[] = {20, 24, 100} B[] = {2, 19, 22, 79, 800} C[] = {10, 12, 23, 24, 119} Output: 24 22 23。24 from A, 22 from B and 23 from C

Solution;
use three pointers
O(n);
 */
public class Three_max_min_abs {
    public List<Integer> getMin(int[] A, int[] B, int[] C) {
        if (A == null || B == null || C == null) return new LinkedList<>();

        List<Integer> result = null;
        int min = Integer.MAX_VALUE;
        int posa = 0, posb = 0, posc = 0;
        while(posa < A.length && posb < B.length && posc < C.length) {
            int a = A[posa], b = B[posb], c = C[posc];
            int sumDiff = Math.abs(a - b) + Math.abs(b - c) + Math.abs(a - c);

            if (sumDiff < min) {
                min = sumDiff;
                result = Arrays.asList(a, b, c);
            }
            if (a <= b && a <= c)
                posa++;
            else if (c <= b && c <= a)
                posc++;
            else
                posb++;

        }
        return result;
    }

}
