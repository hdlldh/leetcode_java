//Given a binary tree where all the right nodes are either leaf nodes with a sib
//ling (a left node that shares the same parent node) or empty, flip it upside dow
//n and turn it into a tree where the original right nodes turned into left leaf n
//odes. Return the new root. 
//
// Example: 
//
// 
//Input: [1,2,3,4,5]
//
//    1
//   / \
//  2   3
// / \
//4   5
//
//Output: return the root of the binary tree [4,5,2,#,#,3,1]
//
//   4
//  / \
// 5   2
//    / \
//   3   1  
// 
//
// Clarification: 
//
// Confused what [4,5,2,#,#,3,1] means? Read more below on how binary tree is se
//rialized on OJ. 
//
// The serialization of a binary tree follows a level order traversal, where '#'
// signifies a path terminator where no node exists below. 
//
// Here's an example: 
//
// 
//   1
//  / \
// 2   3
//    /
//   4
//    \
//     5
// 
//
// The above binary tree is serialized as [1,2,3,#,#,4,#,#,5]. 
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
class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root==null || root.left==null) return root;
        TreeNode node = upsideDownBinaryTree(root.left);
        TreeNode l = root.left;
        TreeNode r = root.right;
        l.left = r;
        l.right = root;
        root.left = null;
        root.right = null;
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
