//Given the root of a binary tree, each node in the tree has a distinct value. 
//
// After deleting all nodes with a value in to_delete, we are left with a forest
// (a disjoint union of trees). 
//
// Return the roots of the trees in the remaining forest. You may return the res
//ult in any order. 
//
// 
// Example 1: 
//
// 
//
// 
//Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
//Output: [[1,2,null,4],[6],[7]]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the given tree is at most 1000. 
// Each node has a distinct value between 1 and 1000. 
// to_delete.length <= 1000 
// to_delete contains distinct values between 1 and 1000. 
// Related Topics Tree Depth-first Search


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashSet;

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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans = new ArrayList<>();
        if (root==null) return ans;
        HashSet<Integer> to_del = new HashSet<>();
        for (int num: to_delete) to_del.add(num);
        root = dfs(root, to_del, ans);
        if (root!=null) ans.add(root);
        return ans;
    }
    private TreeNode dfs(TreeNode root, HashSet<Integer> to_del, List<TreeNode> ans){
        if (root==null) return root;
        root.left = dfs(root.left, to_del, ans);
        root.right = dfs(root.right, to_del, ans);
        if (!to_del.contains(root.val)) return root;
        if (root.left!=null) ans.add(root.left);
        if (root.right!=null) ans.add(root.right);
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
