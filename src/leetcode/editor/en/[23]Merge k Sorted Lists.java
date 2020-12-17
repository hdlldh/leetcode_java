//Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity. 
//
// Example: 
//
// 
//Input:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//Output: 1->1->2->3->4->4->5->6
// 
// Related Topics Linked List Divide and Conquer Heap



//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparing((ListNode x)->x.val));
        for (int i=0; i<lists.length; i++){
            if (lists[i] != null) pq.offer(lists[i]);
        }
        while (!pq.isEmpty()){
            p.next = pq.poll();
            p = p.next;
            if (p.next!=null) pq.offer(p.next);
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
