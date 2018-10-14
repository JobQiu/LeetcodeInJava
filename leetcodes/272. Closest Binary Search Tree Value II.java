

/***
 * push all the nodes after target into the stack
 **/
private void initializeSuccessorStack(TreeNode root, double target, Stack<TreeNode> succ){
  while( root != null ){
    if(root.val == target ){
      succ.push(root);
      break;
    } // END of if
    else if(root.val > target){
      succ.push(root);
      root = root.left;
    } // END of if
    else{
      root = root.right;
    }
  } // END of while

//
}

/*
Input: root = [4,2,5,1,3], target = 3.714286, and k = 2

    4
   / \
  2   5
 / \
1   3

*/

public List<Integer> cloestKValues(TreeNode root, double target, int k ){
  List<Integer> res = new ArrayList();

  Stack<TreeNode> succ = new Stack();
  Stack<TreeNode> pred = new Stack();

  initSuccStack(root, target, succ);
  initPredStack(root, target, pred);

  if(succ.size()>0 && pred.size()> 0 && succ.peek().val == pred.peek().val ){
    getNextPred(pred);
  } // END of if

  while(  k-- > 0){
    if(succ.size() == 0){
      res.add(getNextPred);
    } // END of if
    else if(pred.size()==0){
      res.add(getNextSucc);
    } // END of if
    else{
      double succ_diff = succ.peek().val - target;
      double pred_diff = target - pred.peek().val;
      if(succ_diff > pred_diff){
        res.add(getNextPred(pred));
      } // END of if
      else{
        res.add(getNextSucc(succ));
      }
    }
  } // END of while

  return res; 

}


private int getNextSucc(Stack<TreeNode> succ){
  TreeNode cur = succ.pop();
  int res = cur.val;
  cur = cur.right;
  while( cur != null ){
    succ.push(cur);
    cur = cur.left;
  } // END of while

  return res;

}

private int getNextPred(Stack<TreeNode> pred){
  TreeNode cur = pred.pop();
  int res = cur.val;
  cur  = cur.left;
  while( cur != null){
    pred.push(cur);
    cur = cur.right;
  } // END of while

  return res;
}

private void initPredStack(TreeNode root, double target, Stack<TreeNode > pred){
  while( root != null ){
    if(root.val == target){
      pred.push(root);
      break;
    } // END of if
    else if(root.val < target){
      pred.push(root);
      root = root.right;
    } // END of if
    else {
      root = root.left;
    }
  } // END of while
}

private void initSuccStack(TreeNode root, double target, Stack<TreeNode> succ){
  while( root != null){
    if(root.val == target){
      succ.push(root);
      break;
    } // END of if
    else if(root.val > target){
      succ.push(root);
      root = root.left;
    } // END of if
    else{
      root = root.right;
    }
  } // END of while
}














//
