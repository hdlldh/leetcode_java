//Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive. 
//
// The update(i, val) function modifies nums by updating the element at index i to val. 
//
// Example: 
//
// 
//Given nums = [1, 3, 5]
//
//sumRange(0, 2) -> 9
//update(1, 2)
//sumRange(0, 2) -> 8
// 
//
// Note: 
//
// 
// The array is only modifiable by the update function. 
// You may assume the number of calls to update and sumRange function is distributed evenly. 
// 
// Related Topics Binary Indexed Tree Segment Tree



//leetcode submit region begin(Prohibit modification and deletion)
class NumArray {
    int size;
    int[] data;
    public NumArray(int[] nums) {
        size = nums.length;
        data = new int[size*2];
        for (int i=0; i<size; i++) data[i+size] = nums[i];
        for (int i=size-1; i>0; i--) data[i] = data[2*i] + data[2*i+1];
    }
    
    public void update(int i, int val) {
        i += size;
        data[i] = val;
        while (i/2>0){
            int j = (i%2==0)?i+1:i-1;
            data[i/2] = data[i] + data[j];
            i /= 2;
        }
    }
    
    public int sumRange(int i, int j) {
        i += size;
        j += size;
        int ans = 0;
        while (i<=j){
            if (i%2!=0){
                ans += data[i];
                i++;
            }
            i /= 2;
            if (j%2==0){
                ans += data[j];
                j--;
            }
            j /=2;
        }
        return ans;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
//leetcode submit region end(Prohibit modification and deletion)
