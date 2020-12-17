//In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the i-th domino. (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.) 
//
// We may rotate the i-th domino, so that A[i] and B[i] swap values. 
//
// Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same. 
//
// If it cannot be done, return -1. 
//
// 
//
// Example 1: 
//
// 
//
// 
//Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
//Output: 2
//Explanation: 
//The first figure represents the dominoes as given by A and B: before we do any rotations.
//If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.
// 
//
// Example 2: 
//
// 
//Input: A = [3,5,1,2,3], B = [3,6,3,3,4]
//Output: -1
//Explanation: 
//In this case, it is not possible to rotate the dominoes to make one row of values equal.
// 
//
// 
//
// Note: 
//
// 
// 1 <= A[i], B[i] <= 6 
// 2 <= A.length == B.length <= 20000 
// 
// Related Topics Array Greedy


import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int n = A.length;
        int target = 0;
        int maxCnt = 0;
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i=0; i<n; i++){
            count.put(A[i], count.getOrDefault(A[i], 0) +1);
            if (count.get(A[i])>maxCnt) {
                target = A[i];
                maxCnt = count.get(A[i]);
            }
            count.put(B[i], count.getOrDefault(B[i], 0) +1);
            if (count.get(B[i])>maxCnt) {
                target = B[i];
                maxCnt = count.get(B[i]);
            }
        }
        if (maxCnt <n) return -1;
        int a_swap = 0;
        int b_swap = 0;
        for (int i=0; i<n; i++){
            if (A[i]==B[i]){
                if (A[i]== target) continue;
                else return -1;
            }else{
                if (A[i]== target) b_swap++;
                else if (B[i]== target) a_swap++;
                else return -1;
            }
        }
        return Math.min(a_swap, b_swap);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
