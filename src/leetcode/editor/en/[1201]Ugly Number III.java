//Write a program to find the n-th ugly number. 
//
// Ugly numbers are positive integers which are divisible by a or b or c. 
//
// 
// Example 1: 
//
// 
//Input: n = 3, a = 2, b = 3, c = 5
//Output: 4
//Explanation: The ugly numbers are 2, 3, 4, 5, 6, 8, 9, 10... The 3rd is 4. 
//
// Example 2: 
//
// 
//Input: n = 4, a = 2, b = 3, c = 4
//Output: 6
//Explanation: The ugly numbers are 2, 3, 4, 6, 8, 9, 10, 12... The 4th is 6.
// 
//
// Example 3: 
//
// 
//Input: n = 5, a = 2, b = 11, c = 13
//Output: 10
//Explanation: The ugly numbers are 2, 4, 6, 8, 10, 11, 12, 13... The 5th is 10.
//
// 
//
// Example 4: 
//
// 
//Input: n = 1000000000, a = 2, b = 217983653, c = 336916467
//Output: 1999999984
// 
//
// 
// Constraints: 
//
// 
// 1 <= n, a, b, c <= 10^9 
// 1 <= a * b * c <= 10^18 
// It's guaranteed that the result will be in range [1, 2 * 10^9] 
// 
// Related Topics Math Binary Search




//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long ab = lcm((long) a, (long) b);
        long ac = lcm((long) a, (long) c);
        long bc = lcm((long) b, (long) c);
        long abc = lcm((long) ab, (long) c);
        System.out.println(ab+","+bc+","+ac);
        int low = 0;
        int high = Integer.MAX_VALUE;
        while (low<=high){
            int mid = low + (high-low)/2;
            long count = mid/a + mid/b + mid/c - mid/ab - mid/bc - mid/ac + mid/abc;
            if (count>=n) high = mid -1;
            else low = mid +1;
        }
        return low;
    }
    private long gcd(long a, long b){
        if (b==0) return a;
        return gcd(b, a%b);
    }
    private long lcm(long a, long b){
        return a*b/gcd(a, b);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
