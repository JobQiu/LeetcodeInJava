
## 583. Delete Operation for Two Strings

Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same, where in each step you can delete one character in either string.

Example 1:
Input: "sea", "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
Note:
The length of given words won't exceed 500.
Characters in given words can only be lower-case letters.


<img src="https://leetcode.com/uploads/files/1495160742022-wechatimg8.jpeg" width="250px"/>

The idea here is to use dynamic to choose which to delete.

In the dp matrix. move to right or move down means delete one of the two characters.

```
class Solution {
    public int minDistance(String word1, String word2) {

        if(word1 == null || word1.length() == 0){
            return word2 == null? 0:word2.length();
        } // end of if

        int l1 = word1.length();
        int l2 = word2.length();

        int[][] dp = new int[l1+1][l2+1];
        dp[0][0] = 0;
        for(int i = 1; i <= l1 ; i++){
            dp[i][0] = dp[i-1][0] + 1;
        } // end of for I

        for(int i = 1; i <= l2 ; i++){
            dp[0][i] = dp[0][i-1] + 1;
        } // end of for I

        //    "" b r e a k f
        // "" 0  1 2 3 4 5 6
        // a  1
        // f  2
        // t  3
        // e  4
        // r  5


        for(int i = 1; i <= l1 ; i++){
            for(int j = 1; j <=l2  ; j++){
                int temp;
                if(word1.charAt(i-1) == word2.charAt(j-1) ){
                    temp = dp[i-1][j-1];
                } // end of if
                else{
                    temp = dp[i-1][j-1] + 2;
                }
                temp = Math.min(temp,dp[i-1][j]+1);
                temp = Math.min(temp,dp[i][j-1]+1);

                dp[i][j] = temp;

            } // end of for j
        } // end of for I

        return dp[l1][l2];
    }
}
```

`What I've learned from this problem, for those problem might be solved using dp, we can think the problem with several rows of array, or to this dimension problem, we can think with a matrix. and represent each operation to get value from previous values. `

## 72. Edit Distance

Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example 1:

>Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')

Example 2:

>Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation:
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')


https://ws4.sinaimg.cn/large/0069RVTdly1fusq3dr1tsj31kw0px7dy.jpg

The code is same as last problem, delete distance, except here.

https://ws1.sinaimg.cn/large/0069RVTdly1fusq6ah925j30y20hygo5.jpg


## Maximum sum rectangle in a 2D matrix
