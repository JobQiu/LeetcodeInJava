package LinkedIn;

import java.util.List;

/*
Question: 2-color
问一个图能否用两种颜色涂色，要求是每条边的两个顶点颜色不同。


Solution:


 */
public class two_color {
    private boolean twoColor (List<List<Integer>> adjList) {
        /*
        assume that the input is a adjList

        but I think the real input might be the newly defined graph node
         */
        int n = adjList.size();     // how many nodes we get
        int[] colors = new int[n];   // 0 : not visited, -1 : one color, 1 : the other color

        return dfs(0, -1, colors, adjList, 1);
    }

    private boolean dfs(int n, int parent, int[] colors, List<List<Integer>> adjList, int color) {
        // color current node
        colors[n] = color;

        for (int child : adjList.get(n)) {
            if (child != parent) {  // don't go back
                if (colors[child] != 0) // child has been colored
                    return colors[child] != color;
                else {  // color an other color to child
                    if (!dfs(child, n, colors, adjList, color == 1 ? -1 : 1))
                        return false;
                }
            }
        }

        return true;
    }
}
