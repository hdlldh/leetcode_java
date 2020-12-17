//Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining. 
//
// 
//The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image! 
//
// Example: 
//
// 
//Input: [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6 
// Related Topics Array Two Pointers Stack



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] l2r = new int[n];
        int[] r2l = new int[n];

        int i = 1;
        while (i<n){
            l2r[i] = Math.max(l2r[i-1],height[i-1]);
            i++;
        }
        i = n-2;
        while (i>=0){
            r2l[i] = Math.max(r2l[i+1],height[i+1]);
            i--;
        }
        i = 1;
        int ans = 0;
        while (i<n-1){
            ans += Math.max(0,Math.min(l2r[i],r2l[i]) - height[i]);
            i++;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
