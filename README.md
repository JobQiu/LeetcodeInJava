# LeetcodeInJava

Some procedure to practice from [this doc(https://docs.google.com/document/d/1yxATCtTuv5ZgomU2AeL6luNwPWvHSBYSh7V8FLvtLM8/edit#):

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


### Some summary about each category



### The optimal procedure of code interview from experience

- [ ] Read the problem and ask for clarifications. some specific situation of input,
- [ ] What should we do if we dont have any idea
- [ ] Explain the method in a normal speed, and ask questions like, do u follow me, does this make sense, or can u correct me when it doesnot make sense.
- [ ] i think it's a good idea to list several examples, and explain your solution using those examples
- [ ] explain the time complexity and space cost, try to spend sometime to find a better solution, or ask if the interviewer has some ideas
- [ ] start to code, say sth about what you are doing so that interviewer know what you're doing.
- [ ] i think it's a good idea to type some comment about what this function will do, what this block will do, make the code readable and maintainable.
- [ ] if it's easy, i think it's a good idea to ask sth outside of the code, like, what's the weather in balabala, is that happy to work in balabala.
- [ ] finish the code, and i think it's good to prepare a checklist like the next section, check the mistakes you might make. [it's a good idea to collect your mistakes and sort them by frequency]
- [ ] build some test set or just simulate them through your code and check if it can work. Show them that you are used to write test code to make your code more robust.
- [ ] haha, and some interesting ideas like, you know what, we can use NLP to train a model to write code. If everyone write comment and do exactly what they described in the comment, machine can be trained to write code given those description, I think it's cool. We don't need to write those meaning less code and can work more efficiently.



### Checklist after you finish your code


- [ ] check you will change the value to stop while()
- [ ] i<l before nums[i], cause if i == l, and nums[i] is first, the index will be out of the bound.
- [ ] the length of each rows in int[][] can be different.

| Day | Hour   | LeetCode #              | Should Redo |
| --- | ------ | ----------------------- | ----------- |
| 29  | 2-3 pm | 041                     | yes         |
|     | 3-4 pm | 743. Network Delay Time |             |
|     |        |                         |             |
|     |        |                         |             |

## 105. Construct Binary Tree from Preorder and Inorder Traversal

Things learned from this, Arrays.copyOfRange(), start is inclusive, and end is not inclusive.



```
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // take this as an example, we know that 3 is the root of the whole tree
        // search it in the inorder, we will know what are in the left and what nodes are in the right

        if(preorder == null || preorder.length == 0){
            return null;
        } // end of if

        int l = preorder.length;

        if(preorder.length == 1){
            return new TreeNode(preorder[0]);
        } // end of if

        TreeNode root = new TreeNode(preorder[0]);
        int i = 0;
        // 1. search the index of the root in inorder array
        for(i = 0; i < inorder.length ; i++){
            if(inorder[i] == root.val){
                break;

            } // end of if
        } // end of for I

        // take 3 as an example, when i = 1 it will return

        root.left = buildTree(Arrays.copyOfRange(preorder, 1, i+1), Arrays.copyOfRange(inorder,0, i));
        root.right = buildTree(Arrays.copyOfRange(preorder, i+1, l), Arrays.copyOfRange(inorder,i+1,l));

        return root;
    }
}

```

But my method is very slow. What is the time complexity of this method, it's O(logn), to divide them into two part and build the subtrees. Or maybe it's inefficient to use Arrays.copyOfRange


```

class Solution {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    //Corner cases.
    if (preorder == null
        || inorder == null || preorder.length != inorder.length || preorder.length == 0) {
      return null;
    }
    return buildTreeHelper(preorder, new int[1], inorder, new int[1], Integer.MIN_VALUE);
  }
  //What things do this recursion do?
    //1. reconstructs the subtree based on preorder.
    //2. traverses the tree following in order.
      //Key point: the next in order travering node is root itself --> the left subtree is over.
      //And we could make use of this key point to identify the boundary of the left subtree of the current root.

  //rootValue: the next inorder traversing node after finishing up the current subtree.
  private TreeNode buildTreeHelper(int[] preorder, int[] preIndex, int[] inorder, int[] inIndex, int rootValue) {
    //Base case.
    if (inIndex[0] == inorder.length || inorder[inIndex[0]] == rootValue) {
      return null;
    }
    //Recursive case.
    int curRootVal = preorder[preIndex[0]];
    TreeNode curRoot = new TreeNode(curRootVal);
    preIndex[0]++;
    curRoot.left = buildTreeHelper(preorder, preIndex, inorder, inIndex, curRootVal);
    inIndex[0]++;
    curRoot.right = buildTreeHelper(preorder, preIndex, inorder, inIndex, rootValue);
    return curRoot;
  }
}
```

The idea is same, but it used index to build it. I think it's cool.


## 795. Number of Subarrays with Bounded Maximum

```

class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        // so what we need to do is to find the number of subarrays whose maximum is between L and R , inclusive


        int res = 0, count = 0;
        int j = 0 ;

        // j is used to locate the most recent number that is bigger than R

        // take this as an example,
        // 2 1 2 1 2 1 2 1 3 6 1 2
        // L = 2, R = 3

        // index   0  1  2  3  4  5  6  7  8  9 10 11
        //         2  1  2  1  2  1  2  1  3  6  1  2
        // count   1  1  3  3  5  5  7  7  9  0  0  2
        // j       0                          9  9  9
        // res     1  2  5  8 13 18 25 32 41 41 41 43

        int l = A.length;
        // count is use to store the subarrays satisify the requirement, who end with the current i
        for(int i = 0; i < l ; i++){
            if(A[i]<= R && A[i]>=L){
                res+=i-j+1; // 2-0+1 = 3 // 11 - 9 + 1 = 3
                count=i-j+1;
            }else{
                if(A[i]>R){
                    count=0;
                    j = i+1;
                } // end of if
                else{

                    res+=count;

                }

            } // end of if
        } // end of for I

        return res;

    }
}

```

## 279. perfect squares



the problem we need to solve is, given a number, for example, 13, split into square sum of several numbers, find the least length of combinations of number squares.

`13 = 4 + 9 `

One solution I came up with is to use recursion. for example, we will search 13-9 = 4, then the len is the result of 4 plus 1.

But it exceeds the time limitation.

The time complexity of this method,

---

Some solution from discussion.

`dp`

```

/***
 * what is the time complexity of using dp,
 * firstly, you need to iterate all the numbers from 1 to n, and for each number, you need to iterate from 1 to a cetain number, so i think it's larger than o(N)
 * the space is o(N)
 *
 * @param
 * @return
 * @throws
 **/
public int numSquares(int n){
  // build a int array to store the result of the dp

  // temp is the worst name
  int [] count = new int[n+1];
  for(int i = 1; i < =n ; i++){
    count[i] = Integer.MAX_VALUE;
    } // end of for I

  // count = [from 0 to 14] , size = 15

  //.when we initialize the int array, are the value are all 0 or random numbers?   

  for(int i = 1; i <= n ; i++){
    for(int j = 1; j*j <= i  ; j++){

      count[i] = Math.min(count[i], count[i-j*j] + 1);

      } // end of for j


    } // end of for I

    return count[n];

}
```



## 743. Network delay time

one way to solve this problem is to expand node by node to update the minimal distance from each node to the start node.

And in the end, iterate all the minimal distance from them to start. return the maximum of them.

You can use dij to search the shortest path from one to another.

So firstly, we will build a priority queue to store those node we want to expand, and sort them by the distance.



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
