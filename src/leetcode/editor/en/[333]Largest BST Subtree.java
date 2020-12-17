//Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it. 
//
// Note: 
//A subtree must include all of its descendants. 
//
// Example: 
//
// 
//Input: [10,5,15,1,8,null,7]
//
//   10 
//   / \ 
//  5  15 
// / \   \ 
//1   8   7
//
//Output: 3
//Explanation: The Largest BST Subtree in this case is the highlighted one.
//             The return value is the subtree's size, which is 3.
// 
//
// Follow up: 
//Can you figure out ways to solve it with O(n) time complexity? 
// Related Topics Tree



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
    boolean isBST;
    int size;
    int min;
    int max;
}
class Solution {
    public int largestBSTSubtree(TreeNode root) {
        TreeInfo treeInfo = helper(root);
        return treeInfo.size;
    }
    private TreeInfo helper(TreeNode root){
        TreeInfo treeInfo = new TreeInfo();
        if (root==null){
            treeInfo.isBST = true;
            treeInfo.size = 0;
            treeInfo.min = Integer.MAX_VALUE;
            treeInfo.max = Integer.MIN_VALUE;
            return treeInfo;
        }
        TreeInfo left = helper(root.left);
        TreeInfo right = helper(root.right);
        if (left.isBST && right.isBST && root.val>left.max && root.val < right.min){
            treeInfo.isBST = true;
            treeInfo.size = left.size+right.size+1;
            treeInfo.min = Math.min(left.min, root.val);
            treeInfo.max = Math.max(right.max, root.val);
            return treeInfo;
        }
        treeInfo.isBST = false;
        treeInfo.size = Math.max(left.size, right.size);
        return treeInfo;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
