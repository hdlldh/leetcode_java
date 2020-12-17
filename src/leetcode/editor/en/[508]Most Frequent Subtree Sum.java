//
//Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
// 
//
// Examples 1 
//Input:
// 
//  5
// /  \
//2   -3
// 
//return [2, -3, 4], since all the values happen only once, return all of them in any order.
// 
//
// Examples 2 
//Input:
// 
//  5
// /  \
//2   -5
// 
//return [2], since 2 happens twice, however -5 only occur once.
// 
//
// Note:
//You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
// Related Topics Hash Table Tree



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
    int maxFreq;
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        maxFreq = 0;
        helper(root, map);
        for (int val: map.keySet()){
            if (map.get(val)==maxFreq) ans.add(val);
        }
        int[] ans1 = new int[ans.size()];
        for (int i=0; i<ans.size(); i++) ans1[i] = ans.get(i);
        return ans1;
    }
    private int helper(TreeNode root, HashMap<Integer, Integer> map){
        if (root==null) return 0;
        int left = helper(root.left, map);
        int right = helper(root.right, map);
        int val = left+right+root.val;
        map.put(val,map.getOrDefault(val, 0)+1);
        maxFreq = Math.max(maxFreq, map.get(val));
        return val;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
