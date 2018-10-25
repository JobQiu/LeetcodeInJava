package com.cmq.linkedin.mine;

import java.util.*;

/*
Question;
第三题：205的follow up，给一个string数组，将iso的词归在一组 {'fff','abc','foo','haa','www','vvv'}-> { {'fff','www','vvv'} , {'haa','foo'} , {'abc'} }


Solution:
借了group anagram的方法把所有的string都换成a开头的iso string，然后用hashmap<String,Set<String>>解了。

 transfer word into same isomorphic partten
 every word start with 'a', every time meet a new letter
 map it to cur char, and increase the value of cur char the then if same letter show up again, use the value in map
 ex. foo -> abb
 ex. gjk -> abc
 ex. pkk -> abb
 */
public class Find_Isomorphic {
    public List<List<String>> findIsomorphic(String[] input) {
        Map<String, Set<String>> wordToIso = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for (String word : input) {
            String newWord = transfer(word);
            if (!wordToIso.containsKey(newWord))
                wordToIso.put(newWord, new HashSet<>());
            wordToIso.get(newWord).add(newWord);
        }

        for (String iso : wordToIso.keySet())
            result.add(new ArrayList<>(wordToIso.get(iso)));

        return result;
    }

    private String transfer(String word) {
        Map<Character, Character> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        char cur = 'a';
        for (char letter : word.toCharArray()) {
            if (!map.containsKey(letter)) {
                map.put(letter, cur);
                cur++;
            }
            sb.append(map.get(letter));
        }

        return sb.toString();
    }

}
