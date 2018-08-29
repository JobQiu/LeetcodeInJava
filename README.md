# LeetcodeInJava


### The optimal procedure of code interview from experience

- [ ] Read the problem and ask for clarifications.
- [ ] What should we do if we dont have any idea
- [ ] Explain the method in a normal speed, and ask questions like, do u follow me, does this make sense, or can u correct me when it doesnot make sense.
- [ ] i think it's a good idea to list several examples, and explain your solution using those examples
- [ ] explain the time complexity and space cost, try to spend sometime to find a better solution, or ask if the interviewer has some ideas
- [ ] start to code, say sth about what you are doing so that interviewer know what you're doing.
- [ ] i think it's a good idea to type some comment about what this function will do, what this block will do, make the code readable and maintainable.
- [ ] if it's easy, i think it's a good idea to ask sth outside of the code, like, what's the weather in balabala, is that happy to work in balabala.
- [ ] finish the code, and i think it's good to prepare a checklist like the next section, check the mistakes you might make. [it's a good idea to collect your mistakes and sort them by frequency]
- [ ] build some test set or just simulate them through your code and check if it can work, to show them that you are used to write test code to make your code more robust.
- [ ]

### Checklist after you finish your code


- [ ] check you will change the value to stop while()
- [ ] i<l before nums[i], cause if i == l, and nums[i] is first, the index will be out of the bound.
- [ ] the length of each rows in int[][] can be different.

| Day | Hour   | LeetCode # | Should Redo |
| --- | ------ | ---------- | ----------- |
| 29  | 2-3 pm | 041        | yes         |
|     |   3-4 pm     |   743. Network Delay Time         |             |


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
