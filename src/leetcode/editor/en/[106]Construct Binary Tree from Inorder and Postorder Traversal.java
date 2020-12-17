//Given inorder and postorder traversal of a tree, construct the binary tree. 
//
// Note: 
//You may assume that duplicates do not exist in the tree. 
//
// For example, given 
//
// 
//inorder = [9,3,15,20,7]
//postorder = [9,15,7,20,3] 
//
// Return the following binary tree: 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics Array Tree Depth-first Search



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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    private TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd){
        if (inStart>inEnd || postStart>postEnd) return null;
        int val = postorder[postEnd];
        TreeNode root = new TreeNode(val);
        int k = 0;
        for (int i=inStart; i<=inEnd; i++){
            if (inorder[i]==val) {
                k = i;
                break;
            }
        }
        root.left = helper(inorder, inStart, k-1, postorder, postStart, postStart+k-inStart-1);
        root.right = helper(inorder, k+1, inEnd, postorder, postEnd-inEnd+k, postEnd-1);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
