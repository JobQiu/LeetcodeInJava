public boolean isNumber(String s){

  s = s.trim();

  // -+ numbers . numbers e +- numbers . number

  boolean containsE = false;
  int indexOfE = -1;

  for(int i = 0; i < s.length() ; i++){ // END of for i
    char c = s.charAt(i);
    if(c == 'e'){
      if(containsE){
        return false;
      } // END of if
      containsE = true;
      indexOfE = i;
    } // END of if
  } // END of for

  if(containsE){
    return isNumberWithoutE(s.substring(0,indexOfE)) && isNumberWithoutE(s.substring(indexOfE+1));
  } // END of if

  return isNumberWithoutE(s);

}

/***
 *
 *
 * @param end is exclusive;
 * @return
 * @throws
 **/
private boolean isNumberWithoutE(String s){

  if(s == null || s.length() == 0){
    return false;
  } // END of if

  int start = 0;
  if(s.charAt(0) == '-' || s.charAt(0) == '+'){
    start++;
  } // END of if

  boolean seenDot = false;
  for(int i = start; i < s.length()  ; i++){
    char c = s.charAt(i);
    if(c>='0' && c<='9' ){
      continue;
    } // END of if
    else if(s == '.'){
      if(seenDot){
        return false;
      } // END of if
      else{
        seenDot = true;
        continue;
      }
      else{
        return  false;
      }
    } // END of if
  } // END of for i

  return true;

}


public boolean isNumber(String s) {
        s = s.trim();

        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;
        boolean numberAfterE = false;
        for(int i=0; i<s.length(); i++) {
            if('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                numberSeen = true;
                if (eSeen) {
                    numberAfterE = true;
                }
            } else if(s.charAt(i) == '.') {
                if(eSeen || pointSeen) {
                    return false;
                }
                pointSeen = true;
            } else if(s.charAt(i) == 'e') {
                if(eSeen || !numberSeen) {
                    return false;
                }
                numberAfterE = false;
                eSeen = true;
            } else if(s.charAt(i) == '-' || s.charAt(i) == '+') {
                if(i != 0 && s.charAt(i-1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }

        return numberSeen && (eSeen && numberAfterE || !eSeen && !numberAfterE);
    }
