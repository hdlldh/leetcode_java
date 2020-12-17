//Given a binary tree, return all duplicate subtrees. For each kind of duplicate
// subtrees, you only need to return the root node of any one of them. 
//
// Two trees are duplicate if they have the same structure with same node values
//. 
//
// Example 1: 
//
// 
//        1
//       / \
//      2   3
//     /   / \
//    4   2   4
//       /
//      4
// 
//
// The following are two duplicate subtrees: 
//
// 
//      2
//     /
//    4
// 
//
// and 
//
// 
//    4
// 
//Therefore, you need to return above trees' root in the form of a list. Related
// Topics Tree




//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        HashMap<String, Integer> mem = new HashMap<>();
        serialize(root, mem, ans);
        return ans;
    }
    private String serialize(TreeNode root, HashMap<String, Integer> mem, List<TreeNode> ans){
        if (root==null) return "#";
        String key = String.valueOf(root.val) +","+ serialize(root.left, mem, ans) +","+serialize(root.right, mem, ans);
        mem.put(key, mem.getOrDefault(key, 0)+1);
        if (mem.get(key)==2) ans.add(root);
        return key;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
