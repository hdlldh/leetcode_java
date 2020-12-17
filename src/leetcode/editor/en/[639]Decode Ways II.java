//
//A message containing letters from A-Z is being encoded to numbers using the fo
//llowing mapping way:
// 
//
// 
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 
//Beyond that, now the encoded string can also contain the character '*', which 
//can be treated as one of the numbers from 1 to 9.
// 
//
//
// 
//Given the encoded message containing digits and the character '*', return the 
//total number of ways to decode it.
// 
//
// 
//Also, since the answer may be very large, you should return the output mod 109
// + 7.
// 
//
// Example 1: 
// 
//Input: "*"
//Output: 9
//Explanation: The encoded message can be decoded to the string: "A", "B", "C", 
//"D", "E", "F", "G", "H", "I".
// 
// 
//
// Example 2: 
// 
//Input: "1*"
//Output: 9 + 9 = 18
// 
// 
//
// Note: 
// 
// The length of the input string will fit in range [1, 105]. 
// The input string will only contain the character '*' and digits '0' - '9'. 
// 
// Related Topics Dynamic Programming


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        long[] dp = new long[n+1];
        int kmod = 1000000007;
        dp[0] = 1L;
        if (s.charAt(0)=='*') dp[1] = 9L;
        else if (s.charAt(0)!='0') dp[1] = 1L;
        for (int i=1; i<n; i++){
            dp[i+1] = (helper1(s.charAt(i))*dp[i]+helper2(s.charAt(i-1),s.charAt(i))*dp[i-1]) %kmod;
        }
        return (int) dp[n];
    }
    private int helper1(char ch){
        if (ch=='*') return 9;
        if (ch=='0') return 0;
        return 1;
    }
    private int helper2(char ch1, char ch2){
        if (ch1=='*' && ch2=='*') return 15;
        if (ch1=='*'){
            if (ch2>='0' && ch2<='6') return 2;
            else return 1;
        }
        if (ch2=='*'){
            if (ch1=='1') return 9;
            if (ch1=='2') return 6;
            else return 0;
        }
        int cnt = (ch1-'0')*10 + ch2-'0';
        if (cnt>=10 && cnt<=26) return 1;
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
