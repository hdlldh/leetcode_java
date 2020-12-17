//Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results. 
//
// Note: The input string may contain letters other than the parentheses ( and ). 
//
// Example 1: 
//
// 
//Input: "()())()"
//Output: ["()()()", "(())()"]
// 
//
// Example 2: 
//
// 
//Input: "(a)())()"
//Output: ["(a)()()", "(a())()"]
// 
//
// Example 3: 
//
// 
//Input: ")("
//Output: [""]
// Related Topics Depth-first Search Breadth-first Search

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        LinkedList<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        queue.add(s);
        visited.add(s);
        if (isValid(s)){
            ans.add(s);
            return ans;
        }
        boolean found = false;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0; i<size; i++){
                String cur = queue.removeFirst();
                for (int j=0; j<cur.length(); j++){
                    if (cur.charAt(j)!='(' && cur.charAt(j)!=')') continue;
                    String next = cur.substring(0,j) + cur.substring(j+1);
                    if (visited.contains(next)) continue;
                    if (isValid(next)){
                        ans.add(next);
                        found = true;
                    }
                    queue.add(next);
                    visited.add(next);
                }
            }
            if (found) return ans;
        }
        return ans;
    }
    private boolean isValid(String s){
        int cnt = 0;
        for (char ch: s.toCharArray()){
            if (ch=='(') cnt++;
            else if (ch==')'){
                cnt--;
                if (cnt<0) return false;
            }
        }
        return cnt==0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
