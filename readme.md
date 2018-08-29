# LeetcodeInJava

checklist
- [ ] check you will change the value to stop while()
- [ ] i<l before nums[i], cause if i == l, and nums[i] is first, the index will be out of the bound.


## 041. First Missing Positive



The most efficient way to solve this problem is to use a swap function to swap the number between 0 to l to other number.

For example, [3 4 -1 1, 2 ], we can use O(N) time to swap them into an array like this:

[3 4 -1 1 2]
swap 3 and -1,
[-1 4 3 1 2]
continue to 4
swap 4 and 1
[-1 1 3 4 2]
swap -1 and 1
[1 -1 3 4 2]
continue to 3
continue to 4
continue to 2
swap -1 and 2
[1 2 3 4 -1]

iterate the array and you will know the minimal positive value is 5 for this example.
