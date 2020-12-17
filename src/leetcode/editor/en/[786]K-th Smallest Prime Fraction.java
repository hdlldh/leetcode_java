//A sorted list A contains 1, plus some number of primes. Then, for every p < q in the list, we consider the fraction p/q. 
//
// What is the K-th smallest fraction considered? Return your answer as an array of ints, where answer[0] = p and answer[1] = q. 
//
// 
//Examples:
//Input: A = [1, 2, 3, 5], K = 3
//Output: [2, 5]
//Explanation:
//The fractions to be considered in sorted order are:
//1/5, 1/3, 2/5, 1/2, 3/5, 2/3.
//The third fraction is 2/5.
//
//Input: A = [1, 7], K = 1
//Output: [1, 7]
// 
//
// Note: 
//
// 
// A will have length between 2 and 2000. 
// Each A[i] will be between 1 and 30000. 
// K will be between 1 and A.length * (A.length - 1) / 2. 
// Related Topics Binary Search Heap



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        int n = A.length;
        double low = 0.0;
        double high = 1.0;
        while ((high-low)>1e-9){
            double mid = (low+high)*0.5;
            int[] t = under(A, mid);
            if (t[0]>K) high = mid;
            else if (t[0]<K) low = mid;
            else return new int[]{A[t[1]], A[t[2]]};
        }
        return new int[2];
    }
    private int[] under(int[] A, double m){
        double best =0.0;
        int best_i=0;
        int best_j=0;
        int count = 0;
        int j= 1;
        int n = A.length;
        for (int i=0; i<n; i++){
            while (j < n && A[i]>A[j]*m) j++;
            if (j==n) break;
            count += n-j;
            if (A[i]>A[j]*best){
                best = Double.valueOf(A[i])/Double.valueOf(A[j]);
                best_i = i;
                best_j = j;
            }
        }
        return new int[]{count, best_i, best_j};
    }
}
//leetcode submit region end(Prohibit modification and deletion)
