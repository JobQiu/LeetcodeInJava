package LinkedIn;

import java.util.Arrays;

public class Replace_String {
    class ReplaceString {
        public String replace(String origin, String from, String to) {
            if (origin.length() < from.length() || from.equals(to)) {
                return origin;
            }
            int len = from.length();
            int[] count = new int[26];
            for (char letter : from.toCharArray()) {
                count[letter - 'a']++;
            }
            int[] curCount = new int[26];
            int slow = 0;
            int fast = 0;
            while (fast < origin.length()) {
                if (fast - slow + 1 <= len) {
                    curCount[origin.charAt(fast) - 'a']++;
                }
                else {
                    boolean isSame = true;
                    for (int i = 0; i <= 25; i++) {
                        if (curCount[i] == count[i]) {
                            isSame = isSame && true;
                        }
                        else {
                            isSame = false;
                        }
                    }
                    if (isSame && origin.substring(slow, fast).equals(from)) {
                        origin = origin.substring(0, slow) + to + origin.substring(fast);
                        Arrays.fill(curCount, 0);
                        fast = slow;
                        continue;
                    }
                    curCount[origin.charAt(slow) - 'a']--;
                    slow++;
                    curCount[origin.charAt(fast) - 'a']++;
                }
                fast++;
            }
            return origin;
        }
    }
}
