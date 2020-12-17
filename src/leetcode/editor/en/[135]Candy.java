//There are N children standing in a line. Each child is assigned a rating value. 
//
// You are giving candies to these children subjected to the following requirements: 
//
// 
// Each child must have at least one candy. 
// Children with a higher rating get more candies than their neighbors. 
// 
//
// What is the minimum candies you must give? 
//
// Example 1: 
//
// 
//Input: [1,0,2]
//Output: 5
//Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
// 
//
// Example 2: 
//
// 
//Input: [1,2,2]
//Output: 4
//Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
//             The third child gets 1 candy because it satisfies the above two conditions.
// 
// Related Topics Greedy



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] l2r = new int[n];
        int[] r2l = new int[n];

        l2r[0] = 1;
        int i = 1;
        while (i<n){
            l2r[i] = 1;
            if (ratings[i] > ratings[i-1]){
                l2r[i] = l2r[i-1]+1;
            }
            i++;
        }

        r2l[n-1] = 1;
        i = n-2;
        while (i>=0){
            r2l[i] = 1;
            if (ratings[i] > ratings[i+1]){
                r2l[i] = r2l[i+1]+1;
            }
            i--;
        }

        i = 0;
        int ans = 0;
        while (i<n){
            System.out.println(l2r[i] + ',' +r2l[i]);
            if (l2r[i]>r2l[i])
                ans += l2r[i];
            else
                ans += r2l[i];
            i++;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
