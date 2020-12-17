//Given a linked list, swap every two adjacent nodes and return its head. 
//
// You may not modify the values in the list's nodes, only nodes itself may be changed. 
//
// 
//
// Example: 
//
// 
//Given 1->2->3->4, you should return the list as 2->1->4->3.
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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy0 = new ListNode(0);
        ListNode dummy1 = new ListNode(0);
        ListNode p0 = dummy0;
        ListNode p1 = dummy1;
        ListNode p = head;
        boolean odd = true;
        while (p!=null){
            if (odd){
                p0.next = p;
                p0 = p0.next;
                odd = false;
            }else{
                p1.next = p;
                p1 = p1.next;
                odd = true;
            }
            p = p.next;
        }
        p0.next = null;
        p1.next = null;
        ListNode dummy = new ListNode(0);
        p0 = dummy0.next;
        p1 = dummy1.next;
        p = dummy;
        odd = false;
        while (p0!=null && p1!=null){
            if (odd){
                p.next = p0;
                p0 = p0.next;
                odd = false;
            }else{
                p.next = p1;
                p1 = p1.next;
                odd = true;
            }
            p = p.next;
        }
        if (p0!=null) p.next = p0;
        if (p1!=null) p.next = p1;
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
