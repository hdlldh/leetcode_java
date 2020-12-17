//There are two sorted arrays nums1 and nums2 of size m and n respectively. 
//
// Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)). 
//
// You may assume nums1 and nums2 cannot be both empty. 
//
// Example 1: 
//
// 
//nums1 = [1, 3]
//nums2 = [2]
//
//The median is 2.0
// 
//
// Example 2: 
//
// 
//nums1 = [1, 2]
//nums2 = [3, 4]
//
//The median is (2 + 3)/2 = 2.5
// 
// Related Topics Array Binary Search Divide and Conquer



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m>n){
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
            int t = m;
            m = n;
            n = t;
        }
        int low = 0;
        int high = m;
        int leftMax1 = Integer.MIN_VALUE;
        int leftMax2 = Integer.MIN_VALUE;
        int rightMin1 = Integer.MAX_VALUE;
        int rightMin2 = Integer.MAX_VALUE;
        while (low<=high) {
            int mid = low + (high - low) / 2;
            int mid2 = (m + n) / 2 - mid;
            leftMax1 = (mid > 0) ? nums1[mid - 1] : Integer.MIN_VALUE;
            leftMax2 = (mid2 > 0) ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            rightMin1 = (mid < m) ? nums1[mid] : Integer.MAX_VALUE;
            rightMin2 = (mid2 < n) ? nums2[mid2] : Integer.MAX_VALUE;
            if (leftMax1 > rightMin2) high = mid - 1;
            else if (leftMax2 > rightMin1) low = mid + 1;
            else break;
        }
        if ((m+n)%2==0){
            return (Math.max(leftMax1,leftMax2) + Math.min(rightMin1, rightMin2))*0.5;
        }
        else{
            return Math.min(rightMin1, rightMin2)*1.0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
