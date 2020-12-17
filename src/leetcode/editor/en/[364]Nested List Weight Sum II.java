//Given a nested list of integers, return the sum of all integers in the list weighted by their depth. 
//
// Each element is either an integer, or a list -- whose elements may also be integers or other lists. 
//
// Different from the previous question where weight is increasing from root to leaf, now the weight is defined from bottom up. i.e., the leaf level integers have weight 1, and the root level integers have the largest weight. 
//
// Example 1: 
//
// 
// 
//Input: [[1,1],2,[1,1]]
//Output: 8 
//Explanation: Four 1's at depth 1, one 2 at depth 2.
// 
//
// 
// Example 2: 
//
// 
//Input: [1,[4,[6]]]
//Output: 17 
//Explanation: One 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17.
// 
// 
// 
// Related Topics Depth-first Search



//leetcode submit region begin(Prohibit modification and deletion)
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    int maxDepth;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        HashMap<Integer, Integer> map = new HashMap<>();
        maxDepth = 0;
        helper(nestedList, 0, map);
        int ans = 0;
        for (int d:map.keySet()) ans += map.get(d) * (maxDepth-d+1);
        return ans;
    }
    private void helper(List<NestedInteger> nestedList, int depth, HashMap<Integer, Integer> map){
        maxDepth = Math.max(maxDepth, depth);
        for (NestedInteger l: nestedList){
            if (l.isInteger()) map.put(depth, map.getOrDefault(depth, 0) + l.getInteger());
            else helper(l.getList(), depth+1, map);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
