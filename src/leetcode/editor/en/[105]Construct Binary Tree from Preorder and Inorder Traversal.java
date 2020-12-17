//Given preorder and inorder traversal of a tree, construct the binary tree. 
//
// Note: 
//You may assume that duplicates do not exist in the tree. 
//
// For example, given 
//
// 
//preorder = [3,9,20,15,7]
//inorder = [9,3,15,20,7] 
//
// Return the following binary tree: 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        if (preStart>preEnd || inStart>inEnd) return null;
        int val = preorder[preStart];
        TreeNode root = new TreeNode(val);
        int k = 0;
        for (int i=inStart; i<=inEnd; i++){
            if (inorder[i]==val) {
                k = i;
                break;
            }
        }
        root.left = helper(preorder, preStart+1, preStart+k-inStart, inorder, inStart, k-1);
        root.right = helper(preorder, preEnd+k-inEnd+1, preEnd, inorder, k+1, inEnd);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
