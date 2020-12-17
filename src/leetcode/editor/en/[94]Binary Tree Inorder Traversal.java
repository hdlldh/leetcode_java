//Given a binary tree, return the inorder traversal of its nodes' values. 
//
// Example: 
//
// 
//Input: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//Output: [1,3,2] 
//
// Follow up: Recursive solution is trivial, could you do it iteratively? 
// Related Topics Hash Table Stack Tree

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
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }
    private void helper(TreeNode root, List<Integer> ans){
        if (root==null) return;
        helper(root.left, ans);
        ans.add(root.val);
        helper(root.right, ans);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root==null) return ans;
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode cur = root;
        while (cur!=null || !queue.isEmpty()){
            while (cur!=null){
                queue.addLast(cur);
                cur = cur.left;
            }
            cur = queue.removeLast();
            ans.add(cur.val);
            cur = cur.right;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
