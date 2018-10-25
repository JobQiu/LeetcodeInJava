public class Solution{
  public int countPalindromicSubsequences(String s){
    int len = s.length();

    int[][] dp = new int[len][len];

    char[] cs = s.toCharArray();
    for(int i = 0; i < len ; i++){
      dp[i][i] = 1;
    } // END of for i

    // distance, what does this mean, distance from what to what
    for(int i = 1; i < len ; i++){
        for(int k = 0; k < len - i ; k++){
          int j = k+i;






        } // END of for k
    } // END of for i


  }
}
