//Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x. 
//
// You should preserve the original relative order of the nodes in each of the two partitions. 
//
// Example: 
//
// 
//Input: head = 1->4->3->2->5->2, x = 3
//Output: 1->2->2->4->3->5
// 
// Related Topics Linked List Two Pointers



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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy0 = new ListNode(0);
        ListNode dummy1 = new ListNode(0);
        ListNode p0 = dummy0;
        ListNode p1 = dummy1;
        ListNode p = head;
        while (p!=null){
            if (p.val<x){
                p0.next = p;
                p0 = p0.next;
            }else{
                p1.next = p;
                p1 = p1.next;
            }
            p = p.next;
        }
        p1.next = null;
        p0.next = dummy1.next;
        return dummy0.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
