package com.cmq.array;

/**
 * @author xavier.qiu
 * 9/25/18 2:08 PM
 */
public class Rotation {



    void rotate(int[] arr, int d) {
        int l = arr.length;
        int temp[] = new int[d];
        for(int i = 0; i < d ; i++){
            temp[i] = arr[i];
        } // end of for i

        for(int i = 0; i < l - d ; i++){
            arr[i] = arr[i+d];
        } // end of for i

        for(int i = 0; i < d  ; i++){
            arr[i+l-d] = temp[i];
        } // end of for i

        System.out.println("123");

    }

    /***
     *
     *
     * @param
     * @return
     * @throws
     **/
    void rotate2(int[] nums, int shift) {
        // 1 3 4 2 5 6 7 8 , 2
        // 4 2 5 6 7 8 1 3

        int temp = nums[0];
        for (int i = 0; i < shift; i++) {


        } // end of for i


    }

    /*Function to left rotate arr[] of size n by d*/
    void leftRotate(int arr[], int d, int n) {
        for (int i = 0; i < d; i++)
            leftRotatebyOne(arr, n);
    }

    void leftRotatebyOne(int arr[], int n) {
        int i, temp;
        temp = arr[0];
        for (i = 0; i < n - 1; i++)
            arr[i] = arr[i + 1];
        arr[i] = temp;
    }

    /* utility function to print an array */
    void printArray(int arr[], int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        Rotation rotate = new Rotation();
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        rotate.rotate(arr,2);
        rotate.leftRotate(arr, 2, 7);
        rotate.printArray(arr, 7);
    }
}
