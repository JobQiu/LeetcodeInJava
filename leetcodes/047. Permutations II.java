public class Solution{
  public List<List<Integer>> permuteUnique(int[] nums){
    List<List<Integer>> list = new ArrayList();
    if( nums== null || nums.length == 0){
      return  list;
    }
    int l = nums.length;
    boolean[] used = new boolean[l];
    List<Integer> temp = new ArrayList();
    java.util.Arrays.sort(nums); //Collections.reverseOrder()


    return  list;
  }

  private void dfs(List<List<Integer>> res, List<Integer> temp, int[] nums, boolean[] used){

    if(temp.size() == nums.length ){
      res.add(new ArrayList(temp));
      return ;
    } // END of if

    for(int i = 0; i < nums.length ; i++){
      if(used[i]){
        continue;
      } // END of if

      if(i > 0 && nums[i-1] == nums[i] && !used[i-1]){
        continue;
      } // END of if

      used[i] = true;
      temp.add(nums[i]);
      dfs(res, temp, nums,used);
      used[i] = false;
      temp.remove(temp.size()-1);

    } // END of for i

  }
}
