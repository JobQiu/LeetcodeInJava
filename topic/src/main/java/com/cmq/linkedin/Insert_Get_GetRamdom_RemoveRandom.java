package com.cmq.linkedin;

import java.util.HashMap;
import java.util.Random;

/*
注意上述的三种trade off
第二题是design a data structure, support add(val), remove(val), removeRandom.
step1: design  add = O(1), remove O(1), removeRandom, O(N). => hashset only, removeRandom的时候把东西全放进一个array, 然后再删。这样有O(N)的memory.不过也符合要求啦。.
step2: design  add = O(1), remove O(N), removeRandom, O(1). => hashset + array... 这个简单。. Waral 鍗氬鏈夋洿澶氭枃绔�,
step3: design  add = O(1), remove O(1), removeRandom, O(1). => hashset + array .. 用下面说的那个trick做remove.

关键是要想到如何在O(1)时间里，从一个array里面删除一个元素。
就是把这个元素和array的最后一个元素交换，然后删除最后一个元素，同时减小array的size。这样就O(1)完成了删除。思想感觉和quick sort的in-place partition非常像。
小哥这个三步走循循善诱，不然估计还想不出来嗯。
最后直接实现最后一个，前两个都是在讨论。
design题目是那个write/get/getRandom/deleteRandom都是O(1)的题目，我开始写的code和他想要的略有不同，
最正确解法是vector里面同时存key/val，hashtable里面存key，value是vector的index。我的vector里面只存了key，所以多用了一个hashtable，不过最后也经过提示找到了这种方法。

 */

public class Insert_Get_GetRamdom_RemoveRandom {
    /*
     * generic type + two hashmap(can not use list)
     * */
    class RandomSet<T> {
        private HashMap<T, Integer> valueToIndex;
        private HashMap<Integer, T> indexToValue;
        private Random rand;

        public RandomSet() {
            this.valueToIndex = new HashMap<>();
            this.indexToValue = new HashMap<>();
            this.rand = new Random();
        }


        public boolean add(T value) {
            if (valueToIndex.containsKey(value))
                return false;

            int index = valueToIndex.size();
            valueToIndex.put(value, index);
            indexToValue.put(index, value);
            return true;
        }

        public void remove(T value) {
            if (!valueToIndex.containsKey(value))
                return;

            /* it is the last one, directly remove it */
            int index = valueToIndex.get(value);
            if (index == valueToIndex.size() - 1) {
                valueToIndex.remove(value);
                indexToValue.remove(index);
            } else {
                /* is not last one, adopt the same strategy */
                int lastIndex = indexToValue.size() - 1;
                T lastOne = indexToValue.get(lastIndex);
                valueToIndex.put(lastOne, index);
                indexToValue.put(index, lastOne);
                valueToIndex.remove(value);
                indexToValue.remove(lastIndex);
            }
        }

        public T randomGet() {
            if (valueToIndex.size() == 0)
                return null;

            int index = rand.nextInt(valueToIndex.size());
            return indexToValue.get(index);
        }

        public T randomRemove() {
            T value = randomGet();
            if (value == null)
                return null;
            remove(value);
            return value;
        }
    }
}
