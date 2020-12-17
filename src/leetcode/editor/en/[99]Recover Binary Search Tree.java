//Two elements of a binary search tree (BST) are swapped by mistake. 
//
// Recover the tree without changing its structure. 
//
// Example 1: 
//
// 
//Input: [1,3,null,null,2]
//
//   1
//  /
// 3
//  \
//   2
//
//Output: [3,1,null,null,2]
//
//   3
//  /
// 1
//  \
//   2
// 
//
// Example 2: 
//
// 
//Input: [3,1,4,null,null,2]
//
//  3
// / \
//1   4
//   /
//  2
//
//Output: [2,1,4,null,null,3]
//
//  2
// / \
//1   4
//   /
//  3
// 
//
// Follow up: 
//
// 
// A solution using O(n) space is pretty straight forward. 
// Could you devise a constant space solution? 
// 
// Related Topics Tree Depth-first Search



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
    public void recoverTree(TreeNode root) {
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<TreeNode> addrs = new ArrayList<>();
        helper(root, nums, addrs);
        Collections.sort(nums);
        for (int i=0; i<nums.size(); i++){
            addrs.get(i).val = nums.get(i);
        }
    }
    private void helper(TreeNode root, ArrayList<Integer> nums, ArrayList<TreeNode> addrs){
        if (root==null) return;
        helper(root.left, nums, addrs);
        nums.add(root.val);
        addrs.add(root);
        helper(root.right, nums, addrs);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
