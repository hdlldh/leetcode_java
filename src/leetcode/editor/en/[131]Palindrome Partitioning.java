//Given a string s, partition s such that every substring of the partition is a palindrome. 
//
// Return all possible palindrome partitioning of s. 
//
// Example: 
//
// 
//Input: "aab"
//Output:
//[
//  ["aa","b"],
//  ["a","a","b"]
//]
// 
// Related Topics Backtracking



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> partition(String s) {
        boolean[][] mem = findPalindrome(s);
        List<List<String>> ans = new ArrayList<>();
        dfs(s, 0, mem, new ArrayList<String>(), ans);
        return ans;
    }
    private boolean[][] findPalindrome(String s){
        boolean[][] ans = new boolean[s.length()][s.length()];
        for (int i=0; i<s.length(); i++) Arrays.fill(ans[i], false);
        for (int i=0; i<s.length(); i++){
            int left = i;
            int right = i;
            while (left>=0 && right<s.length()){
                if (s.charAt(left)==s.charAt(right)) ans[left][right]=true;
                else break;
                left--;
                right++;
            }
        }
        for (int i=1; i<s.length(); i++){
            int left = i-1;
            int right = i;
            while (left>=0 && right<s.length()){
                if (s.charAt(left)==s.charAt(right)) ans[left][right]=true;
                else break;
                left--;
                right++;
            }
        }
        return ans;
    }
    private void dfs(String s, int start, boolean[][] mem, List<String> out, List<List<String>> ans){
        if (start==s.length()){
            ans.add(new ArrayList<String>(out));
            return;
        }
        for (int i=start; i<s.length(); i++){
            if (mem[start][i]){
                out.add(s.substring(start, i+1));
                dfs(s, i+1, mem, out, ans);
                out.remove(out.size()-1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
