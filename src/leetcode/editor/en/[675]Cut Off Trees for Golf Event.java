//You are asked to cut off trees in a forest for a golf event. The forest is represented as a non-negative 2D map, in this map: 
//
// 
// 0 represents the obstacle can't be reached. 
// 1 represents the ground can be walked through. 
// The place with number bigger than 1 represents a tree can be walked through, and this positive number represents the tree's height. 
// 
//
// 
//
// You are asked to cut off all the trees in this forest in the order of tree's height - always cut off the tree with lowest height first. And after cutting, the original place has the tree will become a grass (value 1). 
//
// You will start from the point (0, 0) and you should output the minimum steps you need to walk to cut off all the trees. If you can't cut off all the trees, output -1 in that situation. 
//
// You are guaranteed that no two trees have the same height and there is at least one tree needs to be cut off. 
//
// Example 1: 
//
// 
//Input: 
//[
// [1,2,3],
// [0,0,4],
// [7,6,5]
//]
//Output: 6
// 
//
// 
//
// Example 2: 
//
// 
//Input: 
//[
// [1,2,3],
// [0,0,0],
// [7,6,5]
//]
//Output: -1
// 
//
// 
//
// Example 3: 
//
// 
//Input: 
//[
// [2,3,4],
// [0,0,5],
// [8,7,6]
//]
//Output: 6
//Explanation: You started from the point (0,0) and you can cut off the tree in (0,0) directly without walking.
// 
//
// 
//
// Hint: size of the given matrix will not exceed 50x50. 
// Related Topics Breadth-first Search


import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        int m = forest.size();
        int n = forest.get(0).size();
        ArrayList<int[]> trees = new ArrayList<>();
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                int val = forest.get(i).get(j);
                if (val>1) {
                    int[] t = {val, i, j};
                    trees.add(t);
                }
            }
        }
        Collections.sort(trees, Comparator.comparing((int[] x)-> x[0]));
        int ans =0;
        int si = 0;
        int sj = 0;
        for (int i=0; i<trees.size(); i++){
            int ei = trees.get(i)[1];
            int ej = trees.get(i)[2];
            int cnt = bfs(forest, si, sj, ei, ej);
            if (cnt==-1) return -1;
            ans += cnt;
            si = ei;
            sj = ej;
        }
        return ans;
    }

    public int bfs(List<List<Integer>> forest, int si, int sj, int ei, int ej){
        if (si==ei && sj == ej) return 0;
        int m = forest.size();
        int n = forest.get(0).size();
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(si*n + sj);
        HashSet<Integer>  visited = new HashSet<>();
        visited.add( si*n+sj);
        int[] di = {0, -1, 0, 1};
        int[] dj = {-1, 0, 1, 0};
        int ans = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            ans++;
            for (int l= 0; l<size; l++){
                long t = queue.poll();
                si = (int) t/n;
                sj = (int) t%n;
                for (int k=0; k<4; k++){
                    int ni = si+di[k];
                    int nj = sj+dj[k];
                    if (ni<0 || ni>=m || nj<0 || nj>=n) continue;
                    if (ni==ei && nj==ej) return ans;
                    if (forest.get(ni).get(nj)==0) continue;
                    if (visited.contains( ni*n+nj)) continue;
                    queue.offer(ni*n+nj);
                    visited.add(ni*n+nj);
                }
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
