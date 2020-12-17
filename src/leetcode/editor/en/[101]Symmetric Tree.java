//Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center). 
//
// For example, this binary tree [1,2,2,3,4,4,3] is symmetric: 
//
// 
//    1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// But the following [1,2,2,null,3,null,3] is not: 
//
// 
//    1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// Note: 
//Bonus points if you could solve it both recursively and iteratively. 
// Related Topics Tree Depth-first Search Breadth-first Search



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
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    private boolean isMirror(TreeNode root1, TreeNode root2){
        if (root1==null && root2==null) return true;
        if (root1==null || root2==null) return false;
        return root1.val==root2.val && isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
