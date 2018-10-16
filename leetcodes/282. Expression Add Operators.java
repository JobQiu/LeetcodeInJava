public class Solution{

  public  List<String > addOperators(String num, int target){


  }

  private void helper(List<String> result, String path , String num, int target, int pos, long eval, long multed){
    if(pos == num.length() ){
      if(target == eval ){
        result.add(path);
      } // END of if
      return;
    } // END of if

    for(int i = pos; i < num.length()  ; i++){
      if( i != pos && num.charAt(pos) == '0'){ break;} // END of if

      long cur = Long.parseLong(num.substring(pos, i+1));
      if( pos == 0){
        helper(result, )
      } // END of if
    } // END of for i
  }
}
