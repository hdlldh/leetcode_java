//Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. 
//
// A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters. 
//
// 
//
// Example: 
//
// 
//Input: "23"
//Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// Note: 
//
// Although the above answer is in lexicographical order, your answer could be in any order you want. 
// Related Topics String Backtracking


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.isEmpty()) return ans;
        HashMap<Character, String> mem = new HashMap<>();
        mem.put('2',"abc");
        mem.put('3',"def");
        mem.put('4',"ghi");
        mem.put('5',"jkl");
        mem.put('6',"mno");
        mem.put('7',"pqrs");
        mem.put('8',"tuv");
        mem.put('9',"wxyz");
        dfs(digits, 0, mem, "", ans);
        return ans;
    }
    private void dfs(String digits, int start, HashMap<Character,String> mem, String out, List<String> ans){
        if (out.length()==digits.length()){
            ans.add(out);
            return;
        }
        for (int i=start; i<digits.length(); i++){
            String t = mem.get(digits.charAt(i));
            for (char ch: t.toCharArray()){
                dfs(digits, i+1, mem, out+ch, ans);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
