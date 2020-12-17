//We are given a binary tree (with root node root), a target node, and an intege
//r value K. 
//
// Return a list of the values of all nodes that have a distance K from the targ
//et node. The answer can be returned in any order. 
//
// 
//
// 
// 
//
// 
// Example 1: 
//
// 
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
//
//Output: [7,4,1]
//
//Explanation: 
//The nodes that are a distance 2 from the target node (with value 5)
//have values 7, 4, and 1.
//
//
//
//Note that the inputs "root" and "target" are actually TreeNodes.
//The descriptions of the inputs above are just serializations of these objects.
//
// 
//
// 
//
// Note: 
//
// 
// The given tree is non-empty. 
// Each node in the tree has unique values 0 <= node.val <= 500. 
// The target node is a node in the tree. 
// 0 <= K <= 1000. 
// 
// 
// Related Topics Tree Depth-first Search Breadth-first Search




//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

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
    HashMap<Integer, HashSet<Integer>> graph;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        graph = new HashMap<>();
        buildGraph(null, root);
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(target.val);
        HashSet<Integer> visited = new HashSet<>();
        visited.add(target.val);
        List<Integer> ans = new ArrayList<>();
        int steps = 0;
        while (!queue.isEmpty()){
            if (steps==K) break;
            steps++;
            int size = queue.size();
            for (int i=0; i<size; i++){
                int u = queue.poll();
                if (!graph.containsKey(u)) continue;
                for (int v: graph.get(u)){
                    if (visited.contains(v)) continue;
                    queue.offer(v);
                    visited.add(v);
                }
            }
        }
        while (!queue.isEmpty()){
            int u = queue.poll();
            ans.add(u);
        }
        return ans;
    }
    private void buildGraph(TreeNode parent, TreeNode child ){
        if (parent!=null){
            graph.putIfAbsent(parent.val, new HashSet<>());
            HashSet<Integer> t = graph.get(parent.val);
            t.add(child.val);
            graph.putIfAbsent(child.val, new HashSet<>());
            t = graph.get(child.val);
            t.add(parent.val);
        }
        if (child.left!=null) buildGraph(child, child.left);
        if (child.right!=null) buildGraph(child, child.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
