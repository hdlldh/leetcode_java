//A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null. 
//
// Return a deep copy of the list. 
//
// 
//
// Example 1: 
//
// 
//
// 
//Input:
//{"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
//
//Explanation:
//Node 1's value is 1, both of its next and random pointer points to Node 2.
//Node 2's value is 2, its next pointer points to null and its random pointer points to itself.
// 
//
// 
//
// Note: 
//
// 
// You must return the copy of the given head as a reference to the cloned list. 
// 
// Related Topics Hash Table Linked List


import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> mem = new HashMap<>();
        return dfs(head, mem);

    }
    private Node dfs(Node head, HashMap<Node, Node> mem){
        if (head==null) return null;
        if (mem.containsKey(head)) return mem.get(head);
        Node node = new Node();
        mem.put(head, node);
        node.val = head.val;
        node.next = dfs(head.next, mem);
        node.random = dfs(head.random, mem);
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
