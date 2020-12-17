//Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom. 
//
// Example: 
//
// 
//Input: [1,2,3,null,5,null,4]
//Output: [1, 3, 4]
//Explanation:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
// Related Topics Tree Depth-first Search Breadth-first Search



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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root==null) return ans;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int t=0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0; i<size; i++){
                root = queue.remove();
                t = root.val;
                if (root.left!=null) queue.add(root.left);
                if (root.right!=null) queue.add(root.right);
            }
            ans.add(t);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
