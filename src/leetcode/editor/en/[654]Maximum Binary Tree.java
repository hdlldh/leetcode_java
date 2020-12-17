//
//Given an integer array with no duplicates. A maximum tree building on this arr
//ay is defined as follow:
// 
// The root is the maximum number in the array. 
// The left subtree is the maximum tree constructed from left part subarray divi
//ded by the maximum number. 
// The right subtree is the maximum tree constructed from right part subarray di
//vided by the maximum number. 
// 
// 
//
// 
//Construct the maximum tree by the given array and output the root node of this
// tree.
// 
//
// Example 1: 
// 
//Input: [3,2,1,6,0,5]
//Output: return the tree root node representing the following tree:
//
//      6
//    /   \
//   3     5
//    \    / 
//     2  0   
//       \
//        1
// 
// 
//
// Note: 
// 
// The size of the given array will be in the range [1,1000]. 
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
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
    private TreeNode helper(int[] nums, int l, int r){
        if (l>r) return null;
        int mx = Integer.MIN_VALUE;
        int mk = 0;
        for (int i=l; i<=r; i++){
            if (nums[i]>mx){
                mx = nums[i];
                mk = i;
            }
        }
        TreeNode node = new TreeNode(mx);
        node.left = helper(nums, l, mk-1);
        node.right = helper(nums, mk+1, r);
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
