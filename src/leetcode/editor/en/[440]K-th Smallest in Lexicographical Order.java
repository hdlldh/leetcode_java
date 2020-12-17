//Given integers n and k, find the lexicographically k-th smallest integer in the range from 1 to n. 
//
// Note: 1 ≤ k ≤ n ≤ 109. 
//
// Example:
// 
//Input:
//n: 13   k: 2
//
//Output:
//10
//
//Explanation:
//The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10.
// 
// 
//



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthNumber(int n, int k) {
        int cur = 1;
        k--;
        int gap;
        while (k>0){
            gap = findGap(cur, cur+1, n);
            if (gap<=k){
                k -= gap;
                cur++;
            }else {
                k--;
                cur*=10;
            }
        }
        return cur;
        
    }
    private int findGap(long p, long q, int n){
        int gap = 0;
        while (p<=n){
            gap += Math.max(0, Math.min(n+1, q)-p);
            p *= 10;
            q *= 10;
        }
        return gap;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
