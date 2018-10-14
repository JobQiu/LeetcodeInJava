

public boolean canPartitionKSubsets(int[] nums, int k){
  if( nums== null || nums.length < k){
    return  false;
  }

  int sum = 0;
  for(int i : nums){
    sum += i;
  } // END of for
  if(sum % k != 0){
    return false;
  } // END of if
  int l = nums.length;
  boolean[] visited = new boolean[l];

  return helper(nums, visited, k, 0 ,0, sum/k);
}

private boolean helper(int[] nums, boolean[] visited,  int k, int startIndex, int curSum, int target){
  if(curSum > target){
    return false;
  } // END of if

  if(k == 1){
    return true;
  } // END of if

  if(curSum == target){
    return helper(nums,visited, k-1, 0, 0, target);
  } // END of if

  for(int i = startIndex; i < nums.length ; i++){
    if(!visited[i]){
      visited[i] = true;
      if(helper(nums,visited, k, i+1, curSum+nums[i], target)){
        return true;
      } // END of if

      visited[i] = false;
    } // END of if
  } // END of for i

return false;
}
