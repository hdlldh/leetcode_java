//Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST. 
//
// Calling next() will return the next smallest number in the BST. 
//
// 
//
// 
// 
//
// Example: 
//
// 
//
// 
//BSTIterator iterator = new BSTIterator(root);
//iterator.next();    // return 3
//iterator.next();    // return 7
//iterator.hasNext(); // return true
//iterator.next();    // return 9
//iterator.hasNext(); // return true
//iterator.next();    // return 15
//iterator.hasNext(); // return true
//iterator.next();    // return 20
//iterator.hasNext(); // return false
// 
//
// 
//
// Note: 
//
// 
// next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree. 
// You may assume that next() call will always be valid, that is, there will be at least a next smallest number in the BST when next() is called. 
// 
// Related Topics Stack Tree Design

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
class BSTIterator {
    LinkedList<TreeNode> queue;
    public BSTIterator(TreeNode root) {
        queue = new LinkedList<>();
        while (root!=null){
            queue.addLast(root);
            root = root.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        if (hasNext()){
            TreeNode root = queue.removeLast();
            int ans = root.val;
            if (root.right!=null){
                root = root.right;
                while (root!=null){
                    queue.addLast(root);
                    root = root.left;
                }
            }
            return ans;
        }
        return -1;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
//leetcode submit region end(Prohibit modification and deletion)
