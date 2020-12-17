//Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target. 
//
// Note: 
//
// 
// Given target value is a floating point. 
// You are guaranteed to have only one unique value in the BST that is closest to the target. 
// 
//
// Example: 
//
// 
//Input: root = [4,2,5,1,3], target = 3.714286
//
//    4
//   / \
//  2   5
// / \
//1   3
//
//Output: 4
// 
// Related Topics Binary Search Tree



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
    double minGap;
    int ans;
    public int closestValue(TreeNode root, double target) {
        minGap = Double.POSITIVE_INFINITY;
        helper(root, target);
        return ans;
    }
    private void helper(TreeNode root, double target){
        if (root==null) return;
        if (root.val>= target) helper(root.left, target);
        double gap = Math.abs(root.val-target);
        if (gap<minGap){
            minGap = gap;
            ans = root.val;
        }
        if (root.val<=target) helper(root.right, target);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
