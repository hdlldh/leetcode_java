//Given a singly linked list L: L0→L1→…→Ln-1→Ln, 
//reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→… 
//
// You may not modify the values in the list's nodes, only nodes itself may be changed. 
//
// Example 1: 
//
// 
//Given 1->2->3->4, reorder it to 1->4->2->3. 
//
// Example 2: 
//
// 
//Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
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
    public void reorderList(ListNode head) {
        if (head==null || head.next==null) return;
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2!=null && p2.next!=null){
            p2 = p2.next.next;
            p1 = p1.next;
        }
        ListNode head2 = p1.next;
        p1.next = null;
        head2 = reverse(head2);
        head = merge(head, head2);
    }
    private ListNode reverse(ListNode head){
        if (head==null || head.next==null) return head;
        ListNode pre = head;
        ListNode cur = head.next;
        head.next = null;
        while (cur!=null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
    private ListNode merge(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        boolean choice = true;
        while (head1!=null && head2!=null){
            if (choice){
                p.next = head1;
                head1 = head1.next;
                choice = false;
            }else{
                p.next = head2;
                head2 = head2.next;
                choice = true;
            }
            p = p.next;
        }
        if (head1!=null) p.next = head1;
        if (head2!=null) p.next = head2;
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
