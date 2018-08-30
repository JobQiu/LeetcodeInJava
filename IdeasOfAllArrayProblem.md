

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
