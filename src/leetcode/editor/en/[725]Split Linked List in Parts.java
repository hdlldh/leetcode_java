//Given a (singly) linked list with head node root, write a function to split th
//e linked list into k consecutive linked list "parts".
// 
//The length of each part should be as equal as possible: no two parts should ha
//ve a size differing by more than 1. This may lead to some parts being null.
// 
//The parts should be in order of occurrence in the input list, and parts occurr
//ing earlier should always have a size greater than or equal parts occurring late
//r.
// 
//Return a List of ListNode's representing the linked list parts that are formed
//.
// 
//
//Examples
//1->2->3->4, k = 5 // 5 equal parts
//[ [1], 
//[2],
//[3],
//[4],
//null ]
//
// Example 1: 
// 
//Input: 
//root = [1, 2, 3], k = 5
//Output: [[1],[2],[3],[],[]]
//Explanation:
//The input and each element of the output are ListNodes, not arrays.
//For example, the input root has root.val = 1, root.next.val = 2, \root.next.ne
//xt.val = 3, and root.next.next.next = null.
//The first element output[0] has output[0].val = 1, output[0].next = null.
//The last element output[4] is null, but it's string representation as a ListNo
//de is [].
// 
// 
//
// Example 2: 
// 
//Input: 
//root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
//Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
//Explanation:
//The input has been split into consecutive parts with size difference at most 1
//, and earlier parts are a larger size than the later parts.
// 
// 
//
// Note:
// The length of root will be in the range [0, 1000]. 
// Each value of a node in the input will be an integer in the range [0, 999]. 
// k will be an integer in the range [1, 50]. 
// Related Topics Linked List




//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int n = 0;
        ListNode cur = root;
        while (cur!=null){
            n++;
            cur = cur.next;
        }
        int l = n/k;
        int r = n%k;
        ListNode[] ans = new ListNode[k];
        cur = root;
        ListNode prev = null;
        for (int i=0; i<k; i++){
            ans[i] = cur;
            int l0 = (r>0)?l+1:l;
            r--;
            for (int j=0; j<l0; j++){
                prev = cur;
                cur = cur.next;
            }
            if (prev!=null) prev.next = null;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
