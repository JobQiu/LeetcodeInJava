

// take abb as an example,
at

firstly you just have an abb


public void backtrack(
  List<List<String>> lists,
  List<String> list,
  String s,
  int l,
  int r
  ){


    if(l == r){

      lists. add(new ArrayList(list));
      return;
      } // end of if




}


private boolean isPalindrome(String s, int l, int r){ // r is exclusive
    if(l==r-1) return true;
    while(l<r-1){
        if(s.charAt(l)!=s.charAt(r-1)) return false;
        l++;r--;
    }
    return true;
}
