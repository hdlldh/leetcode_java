//The set [1,2,3,...,n] contains a total of n! unique permutations. 
//
// By listing and labeling all of the permutations in order, we get the following sequence for n = 3: 
//
// 
// "123" 
// "132" 
// "213" 
// "231" 
// "312" 
// "321" 
// 
//
// Given n and k, return the kth permutation sequence. 
//
// Note: 
//
// 
// Given n will be between 1 and 9 inclusive. 
// Given k will be between 1 and n! inclusive. 
// 
//
// Example 1: 
//
// 
//Input: n = 3, k = 3
//Output: "213"
// 
//
// Example 2: 
//
// 
//Input: n = 4, k = 9
//Output: "2314"
// 
// Related Topics Math Backtracking


import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int count;
    String ans;
    public String getPermutation(int n, int k) {
        int[] visited = new int[n];
        Arrays.fill(visited, 0);
        count = 0;
        dfs(n, k, new ArrayList<Integer>(), visited);
        return ans;
    }
    private boolean dfs(int n, int k, List<Integer> out, int[] visited){
        if (out.size()==n){
            count++;
            if (count==k){
                ans = "";
                for (int num: out) ans+= Integer.toString(num);
                return true;
            }
            return false;
        }
        for (int i=1; i<=n; i++){
            if (visited[i-1]==1) continue;
            visited[i-1] = 1;
            out.add(i);
            if (dfs(n, k, out, visited)) return true;
            out.remove(out.size()-1);
            visited[i-1] = 0;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
