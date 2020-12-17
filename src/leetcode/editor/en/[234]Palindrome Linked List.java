//Given a singly linked list, determine if it is a palindrome. 
//
// Example 1: 
//
// 
//Input: 1->2
//Output: false 
//
// Example 2: 
//
// 
//Input: 1->2->2->1
//Output: true 
//
// Follow up: 
//Could you do it in O(n) time and O(1) space? 
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
    public boolean isPalindrome(ListNode head) {
        if (head==null || head.next==null) return true;
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2.next!=null && p2.next.next!=null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        ListNode head2 = p1.next;
        p1.next = null;

        ListNode pre = head2;
        ListNode cur = head2.next;
        while (cur!=null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        head2.next = null;

        ListNode p = head;
        ListNode q = pre;
        while (p!=null && q!=null){
            if (p.val!=q.val) return false;
            p = p.next;
            q = q.next;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
