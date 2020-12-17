//Given a sorted linked list, delete all duplicates such that each element appear only once. 
//
// Example 1: 
//
// 
//Input: 1->1->2
//Output: 1->2
// 
//
// Example 2: 
//
// 
//Input: 1->1->2->3->3
//Output: 1->2->3
// 
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head ==null || head.next==null) return head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p2!=null){
            if (p1.val != p2.val){
                p1.next = p2;
                p1 = p2;
            }
            p2 = p2.next;
        }
        p1.next = null;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
