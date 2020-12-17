//Given a nested list of integers represented as a string, implement a parser to deserialize it. 
//
// Each element is either an integer, or a list -- whose elements may also be integers or other lists. 
//
// Note:
//You may assume that the string is well-formed:
// 
// String is non-empty. 
// String does not contain white spaces. 
// String contains only digits 0-9, [, - ,, ]. 
// 
// 
//
// Example 1:
// 
//Given s = "324",
//
//You should return a NestedInteger object which contains a single integer 324.
// 
// 
//
// Example 2:
// 
//Given s = "[123,[456,[789]]]",
//
//Return a NestedInteger object containing a nested list with 2 elements:
//
//1. An integer containing value 123.
//2. A nested list containing two elements:
//    i.  An integer containing value 456.
//    ii. A nested list with one element:
//         a. An integer containing value 789.
// 
// Related Topics String Stack



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
    public NestedInteger deserialize(String s) {
        Stack<NestedInteger> stack = new Stack<>();
        if (s.isEmpty()) return new NestedInteger();
        if (s.charAt(0)!='[') return new NestedInteger(Integer.parseInt(s));
        int start = 1;
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i)=='['){
                stack.add(new NestedInteger());
                start = i+1;
            }else if (s.charAt(i) == ',' || s.charAt(i) == ']'){
                if (i>start) stack.peek().add(new NestedInteger(Integer.parseInt(s.substring(start,i))));
                start = i+1;
                if (s.charAt(i)==']' && stack.size()>1){
                    NestedInteger t = stack.pop();
                    stack.peek().add(t);
                }
            }
        }
        return stack.peek();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
