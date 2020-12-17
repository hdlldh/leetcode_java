//Given a binary tree, return the values of its boundary in anti-clockwise direc
//tion starting from root. Boundary includes left boundary, leaves, and right boun
//dary in order without duplicate nodes. (The values of the nodes may still be dup
//licates.) 
//
// Left boundary is defined as the path from root to the left-most node. Right b
//oundary is defined as the path from root to the right-most node. If the root doe
//sn't have left subtree or right subtree, then the root itself is left boundary o
//r right boundary. Note this definition only applies to the input binary tree, an
//d not applies to any subtrees. 
//
// The left-most node is defined as a leaf node you could reach when you always 
//firstly travel to the left subtree if exists. If not, travel to the right subtre
//e. Repeat until you reach a leaf node. 
//
// The right-most node is also defined by the same way with left and right excha
//nged. 
//
// Example 1 
//
// 
//Input:
//  1
//   \
//    2
//   / \
//  3   4
//
//Ouput:
//[1, 3, 4, 2]
//
//Explanation:
//The root doesn't have left subtree, so the root itself is left boundary.
//The leaves are node 3 and 4.
//The right boundary are node 1,2,4. Note the anti-clockwise direction means you
// should output reversed right boundary.
//So order them in anti-clockwise without duplicates and we have [1,3,4,2].
// 
//
// 
//
// Example 2 
//
// 
//Input:
//    ____1_____
//   /          \
//  2            3
// / \          / 
//4   5        6   
//   / \      / \
//  7   8    9  10  
//       
//Ouput:
//[1,2,4,7,8,9,10,6,3]
//
//Explanation:
//The left boundary are node 1,2,4. (4 is the left-most node according to defini
//tion)
//The leaves are node 4,7,8,9,10.
//The right boundary are node 1,3,6,10. (10 is the right-most node).
//So order them in anti-clockwise without duplicate nodes we have [1,2,4,7,8,9,1
//0,6,3].
// 
//
// 
// Related Topics Tree

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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root==null) return ans;
        ans.add(root.val);
        if (isLeaf(root)) return ans;
        leftBoundary(root.left, ans);
        leaves(root, ans);
        rightBoundary(root.right, ans);
        return ans;
    }
    private boolean isLeaf(TreeNode root){
        return root.left==null && root.right==null;
    }
    private void leftBoundary(TreeNode root, List<Integer> ans){
        if (root==null || isLeaf(root)) return;
        ans.add(root.val);
        if (root.left==null) leftBoundary(root.right, ans);
        else leftBoundary(root.left, ans);
    }
    private void rightBoundary(TreeNode root, List<Integer> ans){
        if (root==null || isLeaf(root)) return;
        if (root.right==null) rightBoundary(root.left, ans);
        else rightBoundary(root.right, ans);
        ans.add(root.val);
    }
    private void leaves(TreeNode root, List<Integer> ans){
        if (root==null) return;
        if (isLeaf(root)) ans.add(root.val);
        leaves(root.left, ans);
        leaves(root.right, ans);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
