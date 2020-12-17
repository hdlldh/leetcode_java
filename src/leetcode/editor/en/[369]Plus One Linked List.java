//Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer. 
//
// You may assume the integer do not contain any leading zero, except the number 0 itself. 
//
// The digits are stored such that the most significant digit is at the head of the list. 
//
// 
// Example : 
//
// 
//Input: [1,2,3]
//Output: [1,2,4]
// 
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
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        helper(dummy);
        if (dummy.val!=0) return dummy;
        return dummy.next;
    }
    private int helper(ListNode p){
        if (p==null) return 1;
        int sum = p.val+helper(p.next);
        p.val = sum%10;
        if (sum>=10) return 1;
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
