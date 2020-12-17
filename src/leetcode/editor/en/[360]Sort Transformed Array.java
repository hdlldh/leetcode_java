//Given a sorted array of integers nums and integer values a, b and c. Apply a q
//uadratic function of the form f(x) = ax2 + bx + c to each element x in the array
//. 
//
// The returned array must be in sorted order. 
//
// Expected time complexity: O(n) 
//
// 
// Example 1: 
//
// 
//Input: nums = [-4,-2,2,4], a = 1, b = 3, c = 5
//Output: [3,9,15,33]
// 
//
// 
// Example 2: 
//
// 
//Input: nums = [-4,-2,2,4], a = -1, b = 3, c = 5
//Output: [-23,-5,1,7]
// 
// 
// Related Topics Math Two Pointers




//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] ans = new int[n];
        int l = 0;
        int r = n-1;
        if (a==0) {
            if (b >= 0) {
                for (int i = 0; i < n; i++) ans[i] = calc(nums[i], 0, b, c);
            } else {
                for (int i = 0; i < n; i++) ans[i] = calc(nums[n - i - 1], 0, b, c);
            }
        }else{
            if (a>0){
                int k = n-1;
                while (l<=r){
                    if (calc(nums[l], a, b, c)<=calc(nums[r], a, b, c)){
                        ans[k] = calc(nums[r],a, b, c);
                        r--;
                        k--;
                    }
                    else{
                        ans[k] = calc(nums[l],a, b, c);
                        l++;
                        k--;
                    }
                }
            }else{
                int k = 0;
                while (l<=r) {
                    if (calc(nums[l], a, b, c) <= calc(nums[r], a, b, c)) {
                        ans[k] = calc(nums[l], a, b, c);
                        l++;
                        k++;
                    } else {
                        ans[k] = calc(nums[r], a, b, c);
                        r--;
                        k++;
                    }
                }
            }
        }
        return ans;
    }
    private int calc(int x, int a, int b, int c){
        return a*x*x + b*x + c;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
