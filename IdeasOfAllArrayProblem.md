[TOC]

## 011. container with most water
>https://leetcode.com/problems/container-with-most-water/description/
<img src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/07/17/question_11.jpg" width="250px"/>

the basic idea of this problem, is to use two pointers, s from the start and e from the end of this array.

Take this as an example,
[1,8,6,2,5,4,8,3,7]

 s               e

In this situation we will move s forward, because, if we move e, the area after this move will always be less than before.

1 ... 3 7 area = 8
1 ... 3   area = 7,

so we have to move the pointer s.
And move these two pointers until they meet each other.

The time complexity of this method is O(N), the space complexity is constant.

`Using two pointers`

## 016. 3Sum Closest

> https://leetcode.com/problems/3sum-closest/description/
> Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
Example:
Given array nums = [-1, 2, 1, -4], and target = 1.
The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

The idea of this problem, is to firstly sort the array.

For this example, it will be [-4 -1 1 2]
Then we use i to iterate from 0 to the end-2.
For the number after i, use two pointers from i+1, end-1 respectively.

For example, i =0, the first number is -4, the target is 1, then we need the other two numbers' sum close to 3,
[-1 1 2]
s     e
-1 + 2 < 3, so we will move s forward to 1,
1+2 =3, and since `each input would have exactly one solution.` we can just return.

The time complexity of this solution is $O(n^2)$.
We dont need extra space as well.

**Things learned from this problem. **
`If we dont use sort, it will take us O(n^3) to solve this problem. But by using sort and for iteration sequentially, we can solve it in O(N^2). So I guess it's a good idea to combine different operations flexibly to get a faster solution. `


## 018. 4Sum

> https://leetcode.com/problems/4sum/description/
>Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
Note:
The solution set must not contain duplicate quadruplets.
Example:
Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]

The idea here is to sort it firstly.

Notice that there can be duplicate numbers.

After sort, the array will become.


[-2 -1 0 0 1 2]

Then the quadruplets can be classified into 4 groups.

|     | # of zeros | # of positive | # of negative |
| --- | ---------- | ------------- | ------------- |
| 1   | 4          | 0             | 0             |
| 2   | 2          | 1             | 1             |
| 3   | 1          | 1             | 2             |
| 4   | 1          | 2             | 1             |
| 5   | 0          | 1             | 3             |
| 6   | 0          | 2             | 2             |
| 7   | 0          | 3             | 1             |


So firstly we count the zeros in this sorted array, and
if there are more than 4 zeros in it.

We can add 4 zeros into the result list.

If there are more than 2 zeros, we can search a positive and a negative, whose sum is 0.
For this operation, you can use a binary search in the positive array or negative. And it will cost o(log n) to do this.

It there are more than 1 zeros, type 3 and 4 is possible, so we can determine the positive, and search other two negative in the negative subarray, and this becomes a 2sum problem. The operation of this is O(N) to iterate the positive, and O(N) (we can use a two pointers to do this). So totally this will cost O(N^2).

For the rest 3 types, 5,6 and 7. It will cost O(N^3) for type 5 and 7. Since we need to iterate all positive numbers and solve a 3sum in negative subarray.

Over all:
1. sort O(n log n)
2. find the number of zeros and their locations O(log n), using binary search to find zero and find the most left and right zero and their indices.
3. consiter type 1-7. The most time-consuming operation will cost O(N^3) here.

The overall time complexity is O(N^3)

`What if we just iterate the number and do 3sum in the subarray`.
The time complexity of a 3-sum is O(N^2), so the total time complexity is also O(N^3), the amount of the code will be smaller.

Some tips from discussion:
1. we can stop eariler at some situation, for example, we want to search two numbers whose sum is 5, but the largest number in our array is 1, which means it's impossible to find two numbers whose sum = 5, we can just give up this array and continue
2. Same when sum is too small.


## 035. search insert position.

Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
Example 3:

Input: [1,3,5,6], 7
Output: 4
Example 4:

Input: [1,3,5,6], 0
Output: 0

it's easy if you use two pointers.
take this as an example
[1 3 5 6]

  index val
s   0 -> 1
e   3 -> 6,
mid 1 -> 3

compare the number with mid, which is smaller, so we move end to mid

s 0
e 1

we will stop when e-s == 1

some special situation is like 0 to [1 3 4]
and 7 to [1 3 4]

so we can compare the smallest and largest number with the target number firstly
if it's not the beginning or the end, use while to determine the position.

The time complexity of this method is log n, just like binary search
we dont need extra space for this.

Nothing special about this problem, so we just skip to the next problem.

## 041. first missing positive

Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3
Example 2:

Input: [3,4,-1,1]
Output: 2
Example 3:

Input: [7,8,9,11,12]
Output: 1

---

The idea of this problem is to use swap those number within the range to where they should be.

for example, as to [3 4 -1 1]
we swap the 3 to the third number in this array
[-1 4 3 1]
4 is out of the range, we dont touch it
[-1 4 3 1]
3 is in the right position, we dont touch it
as to 1, it should be put to the first
[1 4 3 -1]

and then start from the beginning, and we find there is no 2 in this array.

The time complexity of this method is O(N), since we just need to iterate once, we dont need extra space as well.

Some special situation of this problem is that.

for i = 0
nothing happen because 4 is out of the range
for i = 1
[4 3 2 1]
As to 3, you need to swap 3 with 1, but you cannot just continue to deal with 2 now.
[4 1 2 3]
You have to continue to swap 4 and 1, i.e. put 1 to its right position.
[1 4 2 3]
// keep swapping until the second number is in its right position.
// so you will use a while here, keep swaping until the second value <=0 or >= len(arr)

for i = 2
[1 2 4 3]

for i = 3
[1 2 3 4]

then you know the answer should be 5

`What I've learned from this problem:
it's difficult to come up with this swapping solution at the beginning.
So I think it's a good idea to image what kind of temporary result you want if you want to solve this in O(N) time.
An ideal temporary result is to convert the original arr into sth like
[-1 4 3 1] -> [1 _ 3 _ ], then u can use O(N) to get what you want, then start to think how can i get this temporary result.
Result driven way to solve problems.

`

## 045. Jump Game II

// for example, iterate all the number into the

okay, the idea to solve this problem is, for example, we can use a BFS to store the level of each

take this as an example,
[2 3 1 1 1 1 1 4]
[0 1 1 ]
2>3>     1 1 1 4


```

class Solution {
    public int jump(int[] nums) {


        // the idea of this problem is to use another int array to store the temporary result         
        //                         [0 1 2 3 4 5 6]
        // take this as an example [2 3 1 1 1 1 4]
        // so the level will be    [2 ] level 0
        //                           [3 1] level 1
        //                               [1 1] level 2
        //                                   [1] level 3
        //                                     [4] level 4
        // so we need 4 steps to reach

        // filter some special situation
        if(nums ==null || nums.length <= 1){
            return 0;
        } // end of if

        int l = nums.length;

        int start = 0;
        int end = 0;
        int level = 0;

        while( end<l){
            int max = 0;
            for(int i = start; i <= end ; i++){
                max = Math.max(nums[i]+i,max);

                if(max>=l-1){
                    return level+1;
                } // end of if
            } // end of for I

            start = end+1;
            end = max;
            level++;
        }

        return level;
    }
}

```

But the result of this code is slow, so I will compare this with the fastest and see what I can improve it.


```
class Solution {
    public int jump(int[] nums) {
        int jump = 0, curEnd = 0, curFar = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFar = Math.max(curFar, nums[i] + i);
            if (i == curEnd) {
                jump++;
                curEnd = curFar;
            }
        }
        return jump;
    }
}

```

`6ms VS 5ms`
The code is very clean!
`Things leart from this code and this problem.`
1. initialize the variable together make the code clean, and usually initialization is meaningless, so it's reasonable to put them together to highlight other code whose has more information.





##

Given a 2d matrix, find the largest sum of sub matrix.

//  1  2  3  4  5
// -1  -9 1 -3 10
//  

## 53. Maximum Subarray

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.


---


## 63. Unique Paths II

> A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
Now consider if some obstacles are added to the grids. How many unique paths would there be?

<img src="https://leetcode.com/static/images/problemset/robot_maze.png" width="250px"/>

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Note: m and n will be at most 100.

Example 1:

Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right

----

I think it's not difficult, just use dp to start from the end and firstly the last row and last column, they should be 1.

```
obstacle    path number of the end
[0 0 0]    [0 0 1]
[0 1 0]    [0 0 1]
[0 0 0]    [1 1 1]

then update according to the obstacle matrix
and from down to up, right->left


obstacle    path number of the end
[0 0 0]    [2 1 1]
[0 1 0]    [1 0 1]
[0 0 0]    [1 1 1]

```

Result driven, if you want to reach the bottom-right, you must reach [1,2] or [2,1] in this example.


## 64. Minimum Path Sum

Same idea as the last one, from [2,2] to [0,0]

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.

```
[1,3,1]    [1 3 3]
[1,5,1] -> [1 5 2]
[4,2,1]    [7 3 1]

[1,3,1]    [1 3 3]    [1 3 3]    [1 3 3]
[1,5,1] -> [1 5 2] -> [1 7 2] -> [8 7 2] ->
[4,2,1]    [7 3 1]    [7 3 1]    [7 3 1]


[7 6 3]
[8 7 2]
[7 3 1]

so the result is 7.

```
