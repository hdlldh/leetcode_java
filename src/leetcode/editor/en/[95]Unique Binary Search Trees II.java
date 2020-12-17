//Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n. 
//
// Example: 
//
// 
//Input: 3
//Output:
//[
//  [1,null,3,2],
//  [3,2,null,1],
//  [3,1,null,null,2],
//  [2,1,3],
//  [1,null,2,null,3]
//]
//Explanation:
//The above output corresponds to the 5 unique BST's shown below:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
// 
// Related Topics Dynamic Programming Tree

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
    public List<TreeNode> generateTrees(int n) {
        if (n==0) return new ArrayList<TreeNode>();
        int[] nums = new int[n];
        for (int i=1; i<=n; i++) nums[i-1] = i;
        List<TreeNode> ans = new ArrayList<>();
        return helper(nums, 0, n-1);
    }
    private List<TreeNode> helper(int[] nums, int start, int end){
        List<TreeNode> ans = new ArrayList<>();
        if (start>end) {
            ans.add(null);
            return ans;
        }
        if (start==end){
            ans.add(new TreeNode(nums[start]));
            return ans;
        }
        for (int i=start; i<=end; i++){
            List<TreeNode> left = helper(nums, start, i-1);
            List<TreeNode> right = helper(nums, i+1, end);
            for (TreeNode l: left){
                for (TreeNode r: right){
                    TreeNode node = new TreeNode(nums[i]);
                    node.left = l;
                    node.right = r;
                    ans.add(node);
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
