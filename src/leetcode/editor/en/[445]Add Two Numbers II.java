//You are given two non-empty linked lists representing two non-negative integer
//s. The most significant digit comes first and each of their nodes contain a sing
//le digit. Add the two numbers and return it as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the nu
//mber 0 itself. 
//
// Follow up: 
//What if you cannot modify the input lists? In other words, reversing the lists
// is not allowed.
// 
//
// 
//Example:
// 
//Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 8 -> 0 -> 7
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
import java.util.*;
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1!=null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2!=null){
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        int sum = 0;
        ListNode prev = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()){
            int a1 = (stack1.isEmpty())?0:stack1.pop();
            int a2 = (stack2.isEmpty())?0:stack2.pop();
            sum = a1 + a2 + carry;
            ListNode curr = new ListNode(sum %10);
            curr.next = prev;
            prev = curr;
            carry = sum / 10;
        }
        if (carry!=0){
            ListNode curr = new ListNode(carry);
            curr.next = prev;
            prev = curr;
        }
        return prev;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
