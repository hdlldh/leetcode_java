//
//Given a string S, find the number of different non-empty palindromic subsequen
//ces in S, and return that number modulo 10^9 + 7.
// 
//A subsequence of a string S is obtained by deleting 0 or more characters from 
//S.
// 
//A sequence is palindromic if it is equal to the sequence reversed.
// 
//Two sequences A_1, A_2, ... and B_1, B_2, ... are different if there is some i
// for which A_i != B_i.
// 
//
// Example 1: 
// 
//Input: 
//S = 'bccb'
//Output: 6
//Explanation: 
//The 6 different non-empty palindromic subsequences are 'b', 'c', 'bb', 'cc', '
//bcb', 'bccb'.
//Note that 'bcb' is counted only once, even though it occurs twice.
// 
// 
//
// Example 2: 
// 
//Input: 
//S = 'abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba'
//Output: 104860361
//Explanation: 
//There are 3104860382 different non-empty palindromic subsequences, which is 10
//4860361 modulo 10^9 + 7.
// 
// 
//
// Note:
// The length of S will be in the range [1, 1000]. 
// Each character S[i] will be in the set {'a', 'b', 'c', 'd'}. 
// Related Topics String Dynamic Programming


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countPalindromicSubsequences(String S) {
        int n = S.length();
        long[] mem = new long[n*n];
        return (int) helper(S.toCharArray(), 0, n-1, mem);
    }
    private long helper(char[] S, int start, int end, long[] mem){
        if (start>end) return 0L;
        int n = S.length;
        int index = start*n+end;
        if (mem[index]>0) return mem[index];
        if (start==end){
            mem[index]= 1;
            return 1L;
        }
        long ans = 0L;
        if (S[start] == S[end]){
            int l = start+1;
            int r = end -1;
            while (l<=r && S[l]!=S[start]) l++;
            while (l<=r && S[r]!=S[start]) r--;
            if (l>r) ans = 2*helper(S, start+1, end-1, mem) +2;
            else if (l==r)  ans = 2*helper(S, start+1, end-1, mem) +1;
            else ans = 2*helper(S, start+1, end-1, mem) - helper(S, l+1, r-1, mem);
        }else{
            ans = helper(S, start, end-1, mem) + helper(S, start+1, end, mem) - helper(S, start+1, end-1, mem);
        }
        mem[index] =  (ans + 1000000007) % 1000000007;
        return mem[index];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
