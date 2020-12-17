//We have a string S of lowercase letters, and an integer array shifts. 
//
// Call the shift of a letter, the next letter in the alphabet, (wrapping around
// so that 'z' becomes 'a'). 
//
// For example, shift('a') = 'b', shift('t') = 'u', and shift('z') = 'a'. 
//
// Now for each shifts[i] = x, we want to shift the first i+1 letters of S, x ti
//mes. 
//
// Return the final string after all such shifts to S are applied. 
//
// Example 1: 
//
// 
//Input: S = "abc", shifts = [3,5,9]
//Output: "rpl"
//Explanation: 
//We start with "abc".
//After shifting the first 1 letters of S by 3, we have "dbc".
//After shifting the first 2 letters of S by 5, we have "igc".
//After shifting the first 3 letters of S by 9, we have "rpl", the answer.
// 
//
// Note: 
//
// 
// 1 <= S.length = shifts.length <= 20000 
// 0 <= shifts[i] <= 10 ^ 9 
// 
// Related Topics String




//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String shiftingLetters(String S, int[] shifts) {
        int n = shifts.length;
        char[] ans = new char[n];
        int c = 0;
        for (int i=n-1; i>=0; i--){
            c += shifts[i]%26;
            ans[i] = (char) ('a' + (S.charAt(i) - 'a' + c)%26);
        }
        return String.valueOf(ans);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
