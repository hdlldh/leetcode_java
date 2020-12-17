//Sort a linked list in O(n log n) time using constant space complexity. 
//
// Example 1: 
//
// 
//Input: 4->2->1->3
//Output: 1->2->3->4
// 
//
// Example 2: 
//
// 
//Input: -1->5->3->4->0
//Output: -1->0->3->4->5 
// Related Topics Linked List Sort



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
    public ListNode sortList(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode midNode = getMidNode(head);
        ListNode p1 = head;
        ListNode p2 = midNode.next;
        midNode.next = null;
        p1 = sortList(p1);
        p2 = sortList(p2);
        return mergeList(p1, p2);
    }
    private ListNode getMidNode(ListNode head){
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2.next!=null && p2.next.next!=null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }
    private ListNode mergeList(ListNode p1, ListNode p2){
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (p1!=null && p2!=null){
            if (p1.val <= p2.val){
                p.next = p1;
                p1 = p1.next;
            }else{
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1!=null) p.next = p1;
        if (p2!=null) p.next = p2;
        return dummy.next;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
