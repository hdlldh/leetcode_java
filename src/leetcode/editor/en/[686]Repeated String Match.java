//Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1. 
//
// For example, with A = "abcd" and B = "cdabcdab". 
//
// Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd"). 
//
// Note: 
//The length of A and B will be between 1 and 10000. 
// Related Topics String



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int repeatedStringMatch(String A, String B) {
        int q = 1;
        StringBuilder S = new StringBuilder(A);
        while (S.length() < B.length()){
            S.append(A);
            q++;
        }

        if (S.indexOf(B) >= 0) return q;
        if (S.append(A).indexOf(B) >= 0) return q+1;
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
