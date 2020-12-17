//Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty. 
//
// 
//
// Example: 
//
// 
//Input: [1,2,3,4,5]
//  
//          1
//         / \
//        2   3
//       / \     
//      4   5    
//
//Output: [[4,5,3],[2],[1]]
// 
//
// 
//
// Explanation: 
//
// 1. Removing the leaves [4,5,3] would result in this tree: 
//
// 
//          1
//         / 
//        2          
// 
//
// 
//
// 2. Now removing the leaf [2] would result in this tree: 
//
// 
//          1          
// 
//
// 
//
// 3. Now removing the leaf [1] would result in the empty tree: 
//
// 
//          []         
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
    public List<List<Integer>> findLeaves(TreeNode root) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        int maxLevel = helper(root, map);
        for (int i=maxLevel; i>0; i--){
            ans.add(map.get(i));
        }
        return ans;
    }
    private int helper(TreeNode root, HashMap<Integer, ArrayList<Integer>> map){
        if (root==null) return 0;
        if (root.left==null && root.right==null){
            ArrayList<Integer> tmp = map.getOrDefault(1, new ArrayList<Integer>());
            tmp.add(root.val);
            map.put(1, tmp);
            return 1;
        }
        int left = helper(root.left, map);
        int right = helper(root.right, map);
        int level = Math.max(left, right)+1;
        ArrayList<Integer> tmp = map.getOrDefault(level, new ArrayList<Integer>());
        tmp.add(root.val);
        map.put(level, tmp);
        return level;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
