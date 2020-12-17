//A full binary tree is a binary tree where each node has exactly 0 or 2 childre
//n. 
//
// Return a list of all possible full binary trees with N nodes. Each element of
// the answer is the root node of one possible tree. 
//
// Each node of each tree in the answer must have node.val = 0. 
//
// You may return the final list of trees in any order. 
//
// 
//
// Example 1: 
//
// 
//Input: 7
//Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,
//0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
//Explanation:
//
// 
//
// 
//
// Note: 
//
// 
// 1 <= N <= 20 
// 
// Related Topics Tree Recursion




//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> ans = new ArrayList<>();
        if (N%2==0) return ans;
        if (N==1){
            TreeNode root= new TreeNode(0);
            ans.add(root);
            return ans;
        }
        for (int i=1; i<N; i+=2){
            for (TreeNode l: allPossibleFBT(i)){
                for (TreeNode r: allPossibleFBT(N-i-1)){
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
