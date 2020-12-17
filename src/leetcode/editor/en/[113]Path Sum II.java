//Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum. 
//
// Note: A leaf is a node with no children. 
//
// Example: 
//
// Given the below binary tree and sum = 22, 
//
// 
//      5
//     / \
//    4   8
//   /   / \
//  11  13  4
// /  \    / \
//7    2  5   1
// 
//
// Return: 
//
// 
//[
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics Tree Depth-first Search

import java.util.*;

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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(root, sum, new ArrayList<>(), ans);
        return ans;
    }
    private void helper(TreeNode root, int sum, List<Integer> path, List<List<Integer>> ans){
        if (root==null) return;
        if (root.left==null && root.right==null && root.val==sum){
            List<Integer> tmp = new ArrayList<>();
            tmp.addAll(path);
            tmp.add(root.val);
            ans.add(tmp);
        }
        path.add(root.val);
        helper(root.left, sum-root.val, path, ans);
        helper(root.right, sum-root.val, path, ans);
        path.remove(path.size()-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
