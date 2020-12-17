//Given a binary tree rooted at root, the depth of each node is the shortest dis
//tance to the root. 
//
// A node is deepest if it has the largest depth possible among any node in the 
//entire tree. 
//
// The subtree of a node is that node, plus the set of all descendants of that n
//ode. 
//
// Return the node with the largest depth such that it contains all the deepest 
//nodes in its subtree. 
//
// 
//
// Example 1: 
//
// 
//Input: [3,5,1,6,2,0,8,null,null,7,4]
//Output: [2,7,4]
//Explanation:
//
//
//
//We return the node with value 2, colored in yellow in the diagram.
//The nodes colored in blue are the deepest nodes of the tree.
//The input "[3, 5, 1, 6, 2, 0, 8, null, null, 7, 4]" is a serialization of the 
//given tree.
//The output "[2, 7, 4]" is a serialization of the subtree rooted at the node wi
//th value 2.
//Both the input and output have TreeNode type.
// 
//
// 
//
// Note: 
//
// 
// The number of nodes in the tree will be between 1 and 500. 
// The values of each node are unique. 
// 
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
class Pair{
    TreeNode tree;
    int depth;
}
class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Pair t = helper(root);
        return t.tree;
    }

    private Pair helper(TreeNode root){
        Pair t= new Pair();
        if (root==null) {
            t.tree = null;
            t.depth = -1;
            return t;
        }
        Pair left = helper(root.left);
        Pair right = helper(root.right);
        if (left.depth==right.depth){
            t.tree = root;
            t.depth = left.depth+1;
            return t;
        }
        if (left.depth>right.depth){
            t.tree = left.tree;
            t.depth = left.depth+1;
        }else{
            t.tree = right.tree;
            t.depth = right.depth +1;
        }
        return t;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
