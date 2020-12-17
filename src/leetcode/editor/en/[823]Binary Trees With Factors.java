//Given an array of unique integers, each integer is strictly greater than 1. 
//
// We make a binary tree using these integers and each number may be used for an
//y number of times. 
//
// Each non-leaf node's value should be equal to the product of the values of it
//'s children. 
//
// How many binary trees can we make? Return the answer modulo 10 ** 9 + 7. 
//
// Example 1: 
//
// 
//Input: A = [2, 4]
//Output: 3
//Explanation: We can make these trees: [2], [4], [4, 2, 2] 
//
// Example 2: 
//
// 
//Input: A = [2, 4, 5, 10]
//Output: 7
//Explanation: We can make these trees: [2], [4], [5], [10], [4, 2, 2], [10, 2, 
//5], [10, 5, 2]. 
//
// 
//
// Note: 
//
// 
// 1 <= A.length <= 1000. 
// 2 <= A[i] <= 10 ^ 9. 
// 
//


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numFactoredBinaryTrees(int[] A) {
        int n = A.length;
        Arrays.sort(A);
        int kmod = 1000000007;
        HashMap<Integer, Long> dp = new HashMap<>();
        for (int i=0; i<n; i++){
            long count =1;
            for (int j=0; j<i; j++){
                if (A[i]%A[j]==0 && dp.containsKey(A[i]/A[j])){
                    count += dp.get(A[j])*dp.get(A[i]/A[j]) % kmod;
                }
            }
            dp.put(A[i], count);
        }
        long ans = 0L;
        for (long v: dp.values()){
            ans += v % kmod;
        }
        return (int) (ans % kmod);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
