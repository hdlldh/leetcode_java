//One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #. 
//
// 
//     _9_
//    /   \
//   3     2
//  / \   / \
// 4   1  #  6
/// \ / \   / \
//# # # #   # #
// 
//
// For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node. 
//
// Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree. 
//
// Each comma separated value in the string must be either an integer or a character '#' representing null pointer. 
//
// You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3". 
//
// Example 1: 
//
// 
//Input: "9,3,4,#,#,1,#,#,2,#,6,#,#"
//Output: true 
//
// Example 2: 
//
// 
//Input: "1,#"
//Output: false
// 
//
// Example 3: 
//
// 
//Input: "9,#,#,1"
//Output: false Related Topics Stack


import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] strList = preorder.split(",");
        ArrayList<String> queue = new ArrayList<>();
        for (String str: strList){
            queue.add(str);
            while (queue.size()>=3 && queue.get(queue.size()-1).equals("#") && queue.get(queue.size()-2).equals("#") && !queue.get(queue.size()-3).equals("#")){
                queue.remove(queue.size()-1);
                queue.remove(queue.size()-1);
                queue.remove(queue.size()-1);
                queue.add("#");
            }
        }
        if (queue.size()==1 && queue.get(0).equals("#")) return true;
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
