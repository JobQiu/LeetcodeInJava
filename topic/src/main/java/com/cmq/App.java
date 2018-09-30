package com.cmq;

/**
 * Hello world!
 *
 */
public class App 
{




    public int[] dailyTemperatures(int[] nums) {

        if( nums== null || nums.length == 0){
            return new int[0];
        }

        int l = nums.length;  // 8
        int[] res = new int[l];
        //  0  1  2  3  4  5  6  7 index
        // 73 74 75 71 69 72 76 73
        //  0  0  0  0  0  0  0  0


        /*
        i = 7
        j = 1

        i = 6, j = 1

        i = 5, j = 1
        */

        for(int i = l-1; i >= 0   ; i--){
            int j = 1;
            while( j + i < l){

                if(nums[i] > nums[i+j] && res[i+j] != 0 ){
                    j += res[i+j];
                } // end of if
                else{
                    break;
                }
            } // end of while

            if(j+i >= l ){
                res[i] = 0;
            } // end of if
            else{
                res[i] = j;
            }
        } // end of for i

        return res;
    }

    public static void main( String[] args )
    {
        int[] a = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        new App().dailyTemperatures(a);
        System.out.println( "Hello World!" );
    }
}
