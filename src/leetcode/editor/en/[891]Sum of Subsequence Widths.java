//Given an array of integers A, consider all non-empty subsequences of A. 
//
// For any sequence S, let the width of S be the difference between the maximum 
//and minimum element of S. 
//
// Return the sum of the widths of all subsequences of A. 
//
// As the answer may be very large, return the answer modulo 10^9 + 7. 
//
// 
// 
//
// Example 1: 
//
// 
//Input: [2,1,3]
//Output: 6
//Explanation:
//Subsequences are [1], [2], [3], [2,1], [2,3], [1,3], [2,1,3].
//The corresponding widths are 0, 0, 0, 1, 1, 2, 2.
//The sum of these widths is 6.
// 
//
// 
//
// Note: 
//
// 
// 1 <= A.length <= 20000 
// 1 <= A[i] <= 20000 
// 
// 
// Related Topics Array Math




//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int sumSubseqWidths(int[] A) {
        int n = A.length;
        if (n==0) return 0;
        long kmod = 1000000000L +7L;
        Arrays.sort(A);
        long ans = 0;
        long p = 1;
        for (int i=0; i<n; i++){
            ans = (ans+(A[i]-A[n-i-1])*p) % kmod;
            p = (p*2) % kmod;
        }
        return (int) ((ans+kmod) % kmod);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
