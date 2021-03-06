//Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number. 
//
// An example is the root-to-leaf path 1->2->3 which represents the number 123. 
//
// Find the total sum of all root-to-leaf numbers. 
//
// Note: A leaf is a node with no children. 
//
// Example: 
//
// 
//Input: [1,2,3]
//    1
//   / \
//  2   3
//Output: 25
//Explanation:
//The root-to-leaf path 1->2 represents the number 12.
//The root-to-leaf path 1->3 represents the number 13.
//Therefore, sum = 12 + 13 = 25. 
//
// Example 2: 
//
// 
//Input: [4,9,0,5,1]
//    4
//   / \
//  9   0
// / \
//5   1
//Output: 1026
//Explanation:
//The root-to-leaf path 4->9->5 represents the number 495.
//The root-to-leaf path 4->9->1 represents the number 491.
//The root-to-leaf path 4->0 represents the number 40.
//Therefore, sum = 495 + 491 + 40 = 1026. 
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
    int ans;
    public int sumNumbers(TreeNode root) {
        ans = 0;
        helper(root, 0);
        return ans;
    }
    private void helper(TreeNode root, int val){
        if (root==null) return;
        val = val*10+root.val;
        if (root.left==null && root.right==null) ans+=val;
        helper(root.left, val);
        helper(root.right, val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
