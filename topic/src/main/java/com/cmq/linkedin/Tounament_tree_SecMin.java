package com.cmq.linkedin;

/*'
Question:
second min modified
Tournament tree 找secMin;.

Tournament tree 的定义是parent 是孩子node的最小值， 如下例 return 5

                2
              /  \
            2     7
          /  \    | \
        5    2    8  7.
        然后我问小哥要提示，小哥说第二名只能被最后的冠军打败。
所以我就想到只需要考虑被root打败过的node就可以了，就想到了O(logn)的解法，写出来了
思路就是第二小的一定是和最小的有一次比较，所以只遍历有最小值的那条路径，找到路径里面除了这个最小的之外，其他最小的就好了
follow up是找第三小的和找任意第k小的。

 */
public class Tounament_tree_SecMin {
    public int getSecondMin(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        int secondMin = Integer.MAX_VALUE;
        while (root.left != null && root.right != null) {
            if (root.val == root.right.val) {
                secondMin = Math.min(secondMin, root.left.val);
                root = root.right;
            }
            else {
                secondMin = Math.min(secondMin, root.right.val);
                root = root.left;
            }
        }
        return secondMin;
    }

}
