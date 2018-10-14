public class Solution{

  public int coinChange(int[] nums, int target){
    if(target < 1){
      return 0;
    } // END of if
    return helper(nums, target, new int[target]);
  }

  private int helper(int[] nums, int rem, int[] count){

    if(rem < 0 ){
      return -1;
    } // END of if
    if(rem == 0){
      return 0;
    } // END of if

    if(count[rem - 1] !=0 ){
      return count[rem - 1];
    } // END of if

  }


    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] min = {Integer.MAX_VALUE};
        helper(coins, amount, 0, coins.length - 1, min);
        return (min[0] == Integer.MAX_VALUE) ? -1 : min[0];
    }
    public void helper(int[] coins, int remain, int count, int index, int[] min){
            if(remain < 0)return;
            if(index < 0)return;
            if(index == 0){
                if(remain % coins[index] == 0)min[0] = Math.min(min[0], count + remain / coins[index]);
            }
            for (int i = remain / coins[index]; i >= 0 && count + i < min[0] ; i--){
                helper(coins, remain - coins[index] * i , count + i, index - 1, min);
        }

  }


}
