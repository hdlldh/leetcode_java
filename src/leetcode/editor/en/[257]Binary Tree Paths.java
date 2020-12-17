//Given a binary tree, return all root-to-leaf paths. 
//
// Note: A leaf is a node with no children. 
//
// Example: 
//
// 
//Input:
//
//   1
// /   \
//2     3
// \
//  5
//
//Output: ["1->2->5", "1->3"]
//
//Explanation: All root-to-leaf paths are: 1->2->5, 1->3
// Related Topics Tree Depth-first Search



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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(root, path, ans);
        return ans;
    }
    private void helper(TreeNode root, List<Integer> path, List<String> ans){
        if (root==null) return;
        path.add(root.val);
        if (root.left==null && root.right==null){
            String t ="";
            for (int i=0; i<path.size(); i++){
                if (i==0) t += Integer.toString(path.get(i));
                else{
                    t+="->";
                    t += Integer.toString(path.get(i));
                }
            }
            path.remove(path.size()-1);
            ans.add(t);
            return;
        }
        helper(root.left, path, ans);
        helper(root.right, path, ans);
        path.remove(path.size()-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
