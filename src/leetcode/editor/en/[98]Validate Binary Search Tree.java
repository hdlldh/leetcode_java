//Given a binary tree, determine if it is a valid binary search tree (BST). 
//
// Assume a BST is defined as follows: 
//
// 
// The left subtree of a node contains only nodes with keys less than the node's key. 
// The right subtree of a node contains only nodes with keys greater than the node's key. 
// Both the left and right subtrees must also be binary search trees. 
// 
//
// 
//
// Example 1: 
//
// 
//    2
//   / \
//  1   3
//
//Input: [2,1,3]
//Output: true
// 
//
// Example 2: 
//
// 
//    5
//   / \
//  1   4
//     / \
//    3   6
//
//Input: [5,1,4,null,null,3,6]
//Output: false
//Explanation: The root node's value is 5 but its right child's value is 4.
// 
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
    public boolean isValidBST(TreeNode root) {
        return helper(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }
    private boolean helper(TreeNode root, double lower, double upper){
        if (root==null) return true;
        boolean ans;
        if (root.val>lower && root.val<upper) ans=true;
        else ans=false;
        boolean left = helper(root.left, lower, root.val);
        boolean right = helper(root.right, root.val, upper);
        return ans && left && right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
