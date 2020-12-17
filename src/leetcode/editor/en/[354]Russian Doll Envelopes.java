//You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope. 
//
// What is the maximum number of envelopes can you Russian doll? (put one inside other) 
//
// Note: 
//Rotation is not allowed. 
//
// Example: 
//
// 
// 
//Input: [[5,4],[6,4],[6,7],[2,3]]
//Output: 3 
//Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
// 
// 
// Related Topics Binary Search Dynamic Programming



//leetcode submit region begin(Prohibit modification and deletion)
import java.util.*;
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (int[] x, int[] y)-> x[0]-y[0]==0?y[1]-x[1]:x[0]-y[0]);
        int n = envelopes.length;
        ArrayList<Integer>  arr = new ArrayList<>();
        for (int i=0; i<n; i++){
            int k = arr.size();
            int low = 0;
            int high = k-1;
            while (low<=high){
                int mid = low + (high-low)/2;
                if (arr.get(mid)>=envelopes[i][1]) high = mid -1;
                else low = mid +1;
            }
            if (low==k) arr.add(envelopes[i][1]);
            else arr.set(low, envelopes[i][1]);
        }
        return arr.size();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
