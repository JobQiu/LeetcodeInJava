# LeetcodeInJava

Some procedure to practice from [this doc](https://docs.google.com/document/d/1yxATCtTuv5ZgomU2AeL6luNwPWvHSBYSh7V8FLvtLM8/edit#):

```
Read the problem, think about the solutions:
if(easy){
  coding, compare with the hottest or fastest solutions
  if(different with their solution){
    compare and learn sth from their solutions.
  }
}else{
  check the hottest solution
  if(the idea is similar){
    be clear about the idea and why i didn't come up with the idea that is doable, and coding
  } else{
    understand their ideas, run some test cases
    coding;
    mark it and see if I can come up with the idea later
  }
}
summary for certain topics.
```

Also a good idea to practice your ability to implement your ideas, for example, you cannot come up with the idea to solve the problem, but if you know the idea and you want to test your code ability. I think you can write down the idea and implement it the next day.



### Some summary about each category



### The optimal procedure of code interview from experience

- [ ] Read the problem and ask for clarifications. some specific situation of input, get every information you need, you might miss sth that could be helpful.
- [ ] What should we do if we don't have any idea. I think in real world, there is no best solution as we solve the problems in leetcode. So I think in real work, if you need to get things done, you have to search the website, ask information from senior colleagues. At least you need to get things done even in brute force ways. And then you need to mark it and try your best to improve it.
- [ ] Explain the method in a normal speed, and ask questions like, do u follow me, does this make sense, or can u correct me when it does not make sense.
- [ ] i think it's a good idea to list several examples, and explain your solution using those examples
- [ ] explain the time complexity and space cost, try to spend sometime to find a better solution, or ask if the interviewer has some ideas
- [ ] start to code, say sth about what you are doing so that interviewer know what you're doing. Not just repeat your code. It's boring.  
- [ ] i think it's a good idea to type some comment about what this function will do, what this block will do, make the code readable and maintainable.
- [ ] if it's easy, i think it's a good idea to ask sth outside of the code, like, what's the weather in balabala, is that happy to work in balabala.
- [ ] finish the code, and i think it's good to prepare a checklist like the next section, check the mistakes you might make. [it's a good idea to collect your mistakes and sort them by frequency]
- [ ] build some test set or just simulate them through your code and check if it can work. Show them that you are used to write test code to make your code more robust.
- [ ] haha, and some interesting ideas like, you know what, we can use NLP to train a model to write code. If everyone write comment and do exactly what they described in the comment, machine can be trained to write code given those description, I think it's cool. We don't need to write those meaning less code and can work more efficiently.



### Checklist after you finish your code


- [ ] check you will change the value to stop while()
- [ ] i<l before nums[i], cause if i == l, and nums[i] is first, the index will be out of the bound.
- [ ] the length of each rows in int[][] can be different.


## Solutions checklist, iterate this checklist to see if you can solve the problems using this methods.


- Tree Problems, inorder, preorder,
- DP, **if we can reuse the previous result.**
- DFS, **if we need to iterate all the situation to mark or compare **
- BFS
- BackStracking
- Array, 2 pointers, swap, if the array is sorted, consider the 2 sum when the input array is sorted. 
- Matrix or Array, visited mark.
- Map, or array as dictionaries.
- Binary Search, insert
- Array, **if the number is the index of another number**
- Queue,
- Stack,
- Trie
- Linkedlist, find the start of loop,
- Intervals,
- Bit manipulation.
- Divide by 0.
- Priority Queue.
- Boundary problems.


---

### 1. Tree Problems, inorder, preorder,

### 2. DP, reuse the previous result.

560. the problems is given an array, for example, [1,1,1] and a target 2,
we need to return the number of continuous sub arrays whose sum is target. So one idea is to reuse the previous sums,
for example, the accumulative sum for this array is 0 1 2 3, so 2 - 0 is the target, and 3 - 1 is the target 2, so we have 2 subarrays meet the requirements.

**The idea here, is to use an array or map to store the previous results, so that we dont need to calculate them again but just use them, it's kind like a cache.**

139. Word break, given a string applepenapple, and there are two words apple and pen in the dictionary, determine if the string can be divided into words.

use a dp array to see if from 0 to i can be divided into words,
then the dp for this string becomes

```
   a p p l e p e n a p p l e
[t f f f f t f f t f f f f t]
```

return true.
It can be faster if we use trie.

https://medium.com/algorithms-and-leetcode/dp-c6797e0618a

### 3. DFS

681. next closest time, give u a time, for example, 19:34, the closest time using the same numbers is 19:39.
So you can just use a 4-depth dfs to iterate all the possible situations to get the closest time. It's optimal.
I think you can also use BFS, since we need to iterate all the situations.
679. 24 Game, give u 4 numbers, for example, 4 1 8 7, if it's possible to get a 24 from them.
The basic idea is also iterate all the possible situations to see if it's possible.
*Use array instead of list will be faster. *


### 4. BFS
### 5. Backtracking
### 6. Array, 2 pointers, swap
### 7. Matrix or Array, visited mark.
### 8. Map, or array as dictionaries.
### 9. Binary Search, insert

240. search a 2d matrix ii.

### 10. Array, the number is the index of another number

448. Find All Numbers Disappeared in an Array. Given an array, there are numbers from 1 to n, for example, [4,3,2,7,8,2,3,1], there are 8 numbers, we need to find numbers from 1 to n that does not appears in this array, in this example, they're 5 ad 6. Notice, each number-1 is an index for another number, so if we can mark their corresponding indices, we can iterate from 1 to n to get those numbers without marks.

[4 3 2 7 8 2 3 1]

[t t t t f f t t]




### 11. Queue,
### 12. Stack,
### 13. Trie
### 14. LinkedList, find the start of loop,
### 15. Intervals,

There is a very special trick for interval problems,
By sorting the start and end, we can solve the problems faster.

253. Meeting Rooms II. Given an array of Intervals, we need to determine how many rooms we need to hold these meetings.

<img src="https://i.loli.net/2018/09/24/5ba81e5ea9d15.jpg" width="500px"/>

406. Queue Reconstruction by Height


### 16. Bit manipulation.

Simplify the problem by represent them in bit.

### 17. Divide by 0

### 18. Priority Queue.
### 19. Boundary problems.



----

The idea of this note, is to generalize all the problems I've solved, and build a checklist, so that every time I need to solve new problems, I can check if I've met some similar questions before.
