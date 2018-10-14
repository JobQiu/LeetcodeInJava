public TreeNode upsideDownBinaryTree(TreeNode root){

  if(root == null || root.left == null){
    return  root;
  } // END of if

  TreeNode newRoot = upsideDownBinaryTree(root.left);
  root.left.left = root.right;
  root.left.right = root;

  root.left = null;
  root.right = null;
  return newRoot;


}

public TreeNode upsideDownBinaryTree2(TreeNode root){
  TreeNode curr = root;
  TreeNode next = null;
  TreeNode temp = null;
  TreeNode prev = null;

  while(curr != null){
    next = curr.left;

    curr.left = temp;
    temp = curr.right;
    curr.right = prev;
    prev = curr;


    curr = next;

  } // END of while

  return prev;
}
