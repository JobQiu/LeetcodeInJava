
public class Solution{

  public  List<List<String >> findLadders(String start,
                                          String end,
                                          List<String > wordDict){

  }

  private void bfs(String start,
                  String end,
                  Set<String> dict,
                  HashMap<String, ArrayList<String>> nodeNeighbors,
                  HashMap<String, Integer> distance){



  }

  private Set<String > getNeighbors(String node,
                                          Set< String > dict){

      Set<String> set = new HashSet();

      char[] chars = node.toCharArray();
      for(int i = 0; i < chars.length ; i++){
        char old = chars[i];
        for(char j = 'a'; j <='z'  ; j++){
          if(j != old){
            chars[i] = j;
            if(dict.contains(new String(chars) )){
              set.add(new String(chars));
            } // END of if
          } // END of if

        } // END of for j
        chars[i] = old;
      } // END of for i

      return set;
  }


private void dfs(String cur,
                String end,
                Set<String> dict,
                HashMap<String, ArrayList<String>> nodeNeighbors,
                HashMap<String, Integer> distance,
                ArrayList<String> solution,
                List<List<String>> res){



  }
}
