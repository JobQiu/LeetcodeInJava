package com.cmq.linkedin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shortest_words_threedWords {
    /* follow up, how about 3 words,
     *  better solution?
     * */
    Map<String, List<Integer>> map;
    public void WordDistance_3word(String[] words) {
        map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i]))
                map.put(words[i], new ArrayList<>());
            map.get(words[i]).add(i);
        }
    }

    public int shortest_3word(String word1, String word2, String word3) {
        /* these three words doesn't exist */
        if (!map.containsKey(word1) || !map.containsKey(word2) || !map.containsKey(word3))
            return -1;

        List<Integer> indexs1 = map.get(word1);
        List<Integer> indexs2 = map.get(word2);
        List<Integer> indexs3 = map.get(word3);

        int poi1 = 0, poi2 = 0, poi3 = 0, minDis = Integer.MAX_VALUE;

        while(poi1 < indexs1.size() && poi2 < indexs2.size() && poi3 < indexs3.size()) {
            int index1 = indexs1.get(poi1);
            int index2 = indexs2.get(poi2);
            int index3 = indexs3.get(poi3);

            if (index1 < index2 && index1 < index3) {
                minDis = Math.min(index2 - index1 + index3 - index1 + Math.abs(index2 - index3), minDis);
                poi1++;
            } else if (index2 < index1 && index2 < index3) {
                minDis = Math.min(index1 - index2 + index3 - index2 + Math.abs(index1 - index3), minDis);
                poi2++;
            } else if (index3 < index2 && index3 < index1) {
                minDis = Math.min(index2 - index3 + index1 - index3 + Math.abs(index2 - index1), minDis);
                poi3++;
            }
        }

        return minDis;

    }
}
