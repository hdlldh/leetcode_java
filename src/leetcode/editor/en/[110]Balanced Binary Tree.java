//Given a binary tree, determine if it is height-balanced. 
//
// For this problem, a height-balanced binary tree is defined as: 
//
// 
// a binary tree in which the left and right subtrees of every node differ in height by no more than 1. 
// 
//
// 
//
// Example 1: 
//
// Given the following tree [3,9,20,null,null,15,7]: 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
//
// Return true. 
// 
//Example 2: 
//
// Given the following tree [1,2,2,3,3,null,null,4,4]: 
//
// 
//       1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// Return false. 
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
class TreeInfo{
    boolean isBalanced;
    int height;
}
class Solution {
    public boolean isBalanced(TreeNode root) {
        TreeInfo treeInfo = helper(root);
        return treeInfo.isBalanced;
    }
    private TreeInfo helper(TreeNode root){
        TreeInfo treeInfo = new TreeInfo();
        if (root==null){
            treeInfo.isBalanced=true;
            treeInfo.height = 0;
            return treeInfo;
        }
        TreeInfo left = helper(root.left);
        TreeInfo right = helper(root.right);
        if (left.isBalanced && right.isBalanced && Math.abs(left.height-right.height)<=1){
            treeInfo.isBalanced = true;
            treeInfo.height = Math.max(left.height, right.height)+1;
        }else{
            treeInfo.isBalanced = false;
            treeInfo.height = -1;
        }
        return treeInfo;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
