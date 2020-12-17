//Reverse a linked list from position m to n. Do it in one-pass. 
//
// Note: 1 ≤ m ≤ n ≤ length of list. 
//
// Example: 
//
// 
//Input: 1->2->3->4->5->NULL, m = 2, n = 4
//Output: 1->4->3->2->5->NULL
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;
        ListNode cur1 = null;
        ListNode pre1 = null;
        int id = 1;
        while (id<=n){
            if (id==m){
                cur1 = cur;
                pre1 = pre;
            }
            if(id<=m){
                pre = cur;
                cur = cur.next;
            }else{
                ListNode tmp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = tmp;
            }
            id++;
        }
        pre1.next = pre;
        cur1.next = cur;
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
