//Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index. 
//
// According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each." 
//
// Example: 
//
// 
//Input: citations = [3,0,6,1,5]
//Output: 3 
//Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had 
//             received 3, 0, 6, 1, 5 citations respectively. 
//             Since the researcher has 3 papers with at least 3 citations each and the remaining 
//             two with no more than 3 citations each, her h-index is 3. 
//
// Note: If there are several possible values for h, the maximum one is taken as the h-index. 
// Related Topics Hash Table Sort



//leetcode submit region begin(Prohibit modification and deletion)
import java.util.*;
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int low = 0;
        int high = n-1;
        while (low<=high){
            int mid = low + (high-low)/2;
            if (citations[mid]>=n-mid) high=mid-1;
            else low = mid+1;
        }
        return n-low;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
