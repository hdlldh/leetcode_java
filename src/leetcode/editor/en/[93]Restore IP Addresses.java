//Given a string containing only digits, restore it by returning all possible valid IP address combinations. 
//
// Example: 
//
// 
//Input: "25525511135"
//Output: ["255.255.11.135", "255.255.111.35"]
// 
// Related Topics String Backtracking



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        dfs(s, 0, 0, "", ans);
        return ans;
    }
    private void dfs(String s, int start, int id, String out, List<String> ans){
        if (start>=s.length()) return;
        if (id==3){
            String num = s.substring(start);
            if (num.length()>1 && num.charAt(0)=='0') return;
            if (num.length()>4 || Integer.valueOf(num)>255) return;
            ans.add(out+num);
        }else{
            for (int k=1; k<4; k++){
                if (start+k>=s.length()) return;
                String num = s.substring(start, start+k);
                if (num.length()>1 && num.charAt(0)=='0') return;
                if (Integer.valueOf(num)>255) return;
                dfs(s, start+k, id+1, out+num+".", ans);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
