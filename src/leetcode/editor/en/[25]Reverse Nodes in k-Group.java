//Given a linked list, reverse the nodes of a linked list k at a time and return its modified list. 
//
// k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is. 
//
// 
// 
//
// Example: 
//
// Given this linked list: 1->2->3->4->5 
//
// For k = 2, you should return: 2->1->4->3->5 
//
// For k = 3, you should return: 3->2->1->4->5 
//
// Note: 
//
// 
// Only constant extra memory is allowed. 
// You may not alter the values in the list's nodes, only nodes itself may be changed. 
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k==1) return head;
        return helper(head, k);
    }
    private ListNode helper(ListNode head, int k){
        if (head==null || head.next==null) return head;
        int cnt = 0;
        ListNode p = head;
        while (p!=null){
            cnt++;
            if (cnt==k) break;
            p = p.next;
        }
        if (cnt<k) return head;
        ListNode pre = head;
        ListNode cur = head.next;
        while (true){
            cnt--;
            if (cnt==0) break;
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        head.next = helper(cur, k);
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
