package com.cmq.linkedin.mine;

import java.util.*;

public class DNA_Sequence_in_order {

    public static void main(String[] args) {
        String test = "GCATCGTAGCTGCTATCTGCTATCGTAGTCGTAGGCATCGTAGCTGCTATCTGCTATCGTAGTCGTAG";
        List<Character> list = new ArrayList<>();
        for (char c : test.toCharArray()) {
            list.add(c);
        } // END of for

        List<String> res = findRepeatedDnaSequences(test);

        System.out.println("");
    }


    public static List<String> findRepeatedDnaSequences(String s) {

        Map<Integer, String> map = new HashMap();
        List<String> res = new ArrayList();
        if (s == null || s.length() < 11) {
            return res;
        } // END of if

        int[] dict = new int[26];
        dict[0] = 0;
        dict['C' - 'A'] = 1;
        dict['G' - 'A'] = 2;
        dict['T' - 'A'] = 3;


        int mask = 0xFFFFF; // 1111
        int hash = 0;
        for (int i = 0; i < 10; i++) {
            hash = hash << 2 | dict[s.charAt(i) - 'A'];
        } // END of for i

        Set<Integer> add = new HashSet();
        Set<Integer> seen = new HashSet();
        add.add(hash);


        for (int i = 10; i < s.length(); i++) {
            hash = (hash << 2 | dict[s.charAt(i) - 'A']) & mask;
            if (!add.add(hash)) {
                if (seen.add(hash)) {
                    map.put(hash, s.substring(i - 9, i + 1));
                } // END of if
            } // END of if
        } // END of for i

        int[] keys = new int[map.size()];
        int i = 0;
        for (int key : map.keySet()) {
            keys[i++] = key;
        } // END of for

        java.util.Arrays.sort(keys); //Collections.reverseOrder()
        for (int key : keys) {
            res.add(map.get(key));
        } // END of for

        return res;
    }

    // output as in order and in O(n)
    // A -> 0
    // C -> 1
    // G -> 2
    // T -> 3
    public static List<String> findDNA(Iterator<Character> input) {
        HashMap<Long, String> sequence = new HashMap<>();
        int[] number = new int[26];
        number[0] = 0;
        number['C' - 'A'] = 1;
        number['G' - 'A'] = 2;
        number['T' - 'A'] = 3;

        StringBuilder buffer = new StringBuilder();
        Set<String> seen = new HashSet<>();
        long maxIndex = 0;
        int count = 10;
        while (count > 0 && input.hasNext()) {
            buffer.append(input.next());
            count--;
        }
        if (buffer.length() < 10) {
            return new ArrayList<>();
        }
        seen.add(buffer.toString());
        while (input.hasNext()) {
            buffer.delete(0, 1);
            buffer.append(input.next());
            if (seen.contains(buffer.toString())) {
                long index = getIndex(buffer.toString(), number);

                maxIndex = Math.max(index, maxIndex);
                sequence.put(index, buffer.toString());
            } else {
                seen.add(buffer.toString());
            }
        }

        /* use a mexIndex to do in-order */
        List<String> result = new ArrayList<>();
        for (long i = 0; i <= maxIndex; i++) {
            if (sequence.containsKey(i)) {
                result.add(sequence.get(i));
            }
        }
        return result;
    }

    private static long getIndex(String dna, int[] number) {
        long index = 0;
        for (char letter : dna.toCharArray()) {
            index = index * 10 + number[letter - 'A'];
        }
        return index;
    }
}
