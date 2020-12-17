//Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level). 
//
// 
//For example: 
//Given binary tree [3,9,20,null,null,15,7], 
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
// 
// 
//return its level order traversal as: 
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics Tree Breadth-first Search


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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root==null) return ans;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()){
            int qSize = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i=0; i<qSize; i++){
                TreeNode node = queue.removeFirst();
                level.add(node.val);
                if (node.left!=null) queue.addLast(node.left);
                if (node.right!=null) queue.addLast(node.right);
            }
            ans.add(level);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
