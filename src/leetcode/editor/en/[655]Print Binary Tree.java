//Print a binary tree in an m*n 2D string array following these rules: 
//
// 
// The row number m should be equal to the height of the given binary tree. 
// The column number n should always be an odd number. 
// The root node's value (in string format) should be put in the exactly middle 
//of the first row it can be put. The column and the row where the root node belon
//gs will separate the rest space into two parts (left-bottom part and right-botto
//m part). You should print the left subtree in the left-bottom part and print the
// right subtree in the right-bottom part. The left-bottom part and the right-bott
//om part should have the same size. Even if one subtree is none while the other i
//s not, you don't need to print anything for the none subtree but still need to l
//eave the space as large as that for the other subtree. However, if two subtrees 
//are none, then you don't need to leave space for both of them. 
// Each unused space should contain an empty string "". 
// Print the subtrees following the same rules. 
// 
//
// Example 1: 
// 
//Input:
//     1
//    /
//   2
//Output:
//[["", "1", ""],
// ["2", "", ""]]
// 
// 
//
//
// Example 2: 
// 
//Input:
//     1
//    / \
//   2   3
//    \
//     4
//Output:
//[["", "", "", "1", "", "", ""],
// ["", "2", "", "", "", "3", ""],
// ["", "", "4", "", "", "", ""]]
// 
// 
//
// Example 3: 
// 
//Input:
//      1
//     / \
//    2   5
//   / 
//  3 
// / 
//4 
//Output:
//
//[["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
// ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
// ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
// ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
// 
// 
//
// Note:
//The height of binary tree is in the range of [1, 10].
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
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        int width = (1<<height) -1;
        List<List<String>> ans = new ArrayList<>();
        for (int i=0; i<height; i++) {
            ArrayList<String> t = new ArrayList<>();
            for (int j = 0; j < width; j++) {
                t.add("");
            }
            ans.add(t);
        }
        fill(root, ans, 0, 0, width-1);
        return ans;
    }
    private int getHeight(TreeNode root){
        if (root==null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) +1;
    }
    private void fill(TreeNode root, List<List<String>> ans, int h, int l, int r){
        if (root==null) return;
        int mid = (l+r)/2;
        ans.get(h).set(mid, String.valueOf(root.val));
        fill(root.left, ans, h+1, l, mid-1);
        fill(root.right, ans, h+1, mid+1, r);
        return;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
