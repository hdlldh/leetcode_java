//Given an integer n, return 1 - n in lexicographical order. 
//
// For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9]. 
//
// Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000. 
//


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> lexicalOrder2(int n) {
        List<Integer> ans = new ArrayList<>();
        int cur = 1;
        for (int i=0; i<n; i++){
            ans.add(cur);
            if (cur*10<=n) cur*=10;
            else{
                if (cur>=n) cur/=10;
                cur++;
                while (cur%10==0) cur/=10;
            }
        }
        return ans;
    }
    public List<Integer> lexicalOrder(int n) {
        List<Integer>  ans = new ArrayList<>();
        for (int i=1; i<10; i++) dfs(i,n,ans);
        return ans;
    }
    private void dfs(int cur, int n, List ans){
        if (cur>n) return;
        ans.add(cur);
        for (int i=0; i<10; i++) dfs(10*cur+i, n, ans);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
