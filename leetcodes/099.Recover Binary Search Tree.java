public class Solution{

  TreeNode firstElement = null;
  TreeNode secondElement = null;

  TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);

  public void recoverOrder(TreeNode root){


  }

  private void traverse(TreeNode root){

    if(root == null){
      return ;
    } // END of if

    traverse(root.left);

    // do sth

    if(firstElement == null && prevElement.val >= root.val){
      firstElement = prevElement;
    } // END of if

    if(firstElement != null && prevElement.val >= root.val){
      secondElement = root;
    } // END of if

    // do sth end

    traverse(root.right);


  }


}


//    6
//  3  4
// 5 2
