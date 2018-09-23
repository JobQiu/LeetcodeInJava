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
