//
//There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.
// 
//
// 
//Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.
// 
//
// Example 1: 
// 
//Input: 
//[[1,1,0],
// [1,1,0],
// [0,0,1]]
//Output: 2
//Explanation:The 0th and 1st students are direct friends, so they are in a friend circle. The 2nd student himself is in a friend circle. So return 2.
// 
// 
//
// Example 2: 
// 
//Input: 
//[[1,1,0],
// [1,1,1],
// [0,1,1]]
//Output: 1
//Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends, so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
// 
// 
//
//
// Note: 
// 
// N is in range [1,200]. 
// M[i][i] = 1 for all students. 
// If M[i][j] = 1, then M[j][i] = 1. 
// 
// Related Topics Depth-first Search Union Find



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        if (n==0) return 0;
        int[] parent = new int[n];
        for (int i=0; i<n; i++) parent[i] = i;
        for (int i=0; i<n; i++){
            for (int j = i+1; j<n; j++){
                if (M[i][j]==1) union(parent, i, j);
            }
        }
        int ans = 0;
        for (int i=0; i<n; i++){
            if (parent[i]==i) ans++;
        }
        return ans;
    }
    private int find(int[] parent, int i){
        while (i!=parent[i]) i= parent[i];
        return i;
    }
    private void union(int[] parent, int i, int j){
        int root_i = find(parent, i);
        int root_j = find(parent, j);
        if (root_i!=root_j) parent[root_j] = root_i;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
