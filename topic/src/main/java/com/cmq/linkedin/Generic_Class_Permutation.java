package LinkedIn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Generic_Class_Permutation {
    class Permutation<T extends Comparable<T>> {
        public List<List<T>> permutation(T[] input) {
            List<List<T>> result = new ArrayList<>();
            if (input.length == 0 || input == null) return result;
            Arrays.sort(input, new Comparator<T>() {
                @Override
                public int compare(T o1, T o2) {
                    if (o1.compareTo(o2) > 0)
                        return 1;
                    else if (o1.compareTo(o2) < 0)
                        return -1;
                    else
                        return 0;
                }
            });

            findPermutation(result, new ArrayList<>(), input, new boolean[input.length] );
            return result;

        }

        private void findPermutation(List<List<T>> result, ArrayList<T> to_add, T[] input, boolean[] visited) {
            if (to_add.size() == input.length)
                result.add(new ArrayList<>(to_add));
            else {
                for (int i = 0; i < input.length; i++) {
                    if (visited[i] || (i != 0 && input[i] == input[i-1] && !visited[i - 1])) continue;
                    visited[i] = true;
                    to_add.add(input[i]);
                    findPermutation(result, to_add, input, visited);
                    to_add.remove(to_add.size() - 1);
                    visited[i] = false;
                }
            }
        }



    }
}
