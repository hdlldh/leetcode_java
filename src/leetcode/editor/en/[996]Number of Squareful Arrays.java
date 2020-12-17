//Given an array A of non-negative integers, the array is squareful if for every pair of adjacent elements, their sum is a perfect square. 
//
// Return the number of permutations of A that are squareful. Two permutations A1 and A2 differ if and only if there is some index i such that A1[i] != A2[i]. 
//
// 
//
// Example 1: 
//
// 
//Input: [1,17,8]
//Output: 2
//Explanation: 
//[1,8,17] and [17,8,1] are the valid permutations.
// 
//
// Example 2: 
//
// 
//Input: [2,2,2]
//Output: 1
// 
//
// 
//
// Note: 
//
// 
// 1 <= A.length <= 12 
// 0 <= A[i] <= 1e9 
// Related Topics Math Backtracking Graph



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSquarefulPerms(int[] A) {
        int n = A.length;
        if (n==0) return 0;
        List<List<Integer>> ans = new ArrayList<>();
        int[] visited = new int[n];
        Arrays.fill(visited, 0);
        Arrays.sort(A);
        dfs(A, new ArrayList<Integer>(), ans, visited);
        return ans.size();
    }

    private boolean isSquare(int x, int y){
        int low = 0;
        int high = x+y;
        while (low<=high){
            int mid = low + (high-low)/2;
            int mid2 = mid*mid;
            if (mid2>x+y) high = mid -1;
            else if (mid2<x+y) low = mid +1;
            else return true;
        }
        return false;
    }

    private void dfs(int[] A, List<Integer> out, List<List<Integer>> ans, int[] visited){
        if (out.size()==A.length){
            ArrayList<Integer> out1 = new ArrayList<>(out);
            ans.add(out1);
            return;
        }
        for (int i=0; i<A.length; i++){
            if (visited[i]==1) continue;
            if (i==0 || A[i]!=A[i-1] || visited[i-1]==1){
                if (out.isEmpty() || isSquare(A[i], out.get(out.size()-1))){
                    visited[i] = 1;
                    out.add(A[i]);
                    dfs(A, out, ans, visited);
                    visited[i] = 0;
                    out.remove(out.size()-1);
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
