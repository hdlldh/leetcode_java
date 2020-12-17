//Given an array of integers A, a move consists of choosing any A[i], and increm
//enting it by 1. 
//
// Return the least number of moves to make every value in A unique. 
//
// 
//
// Example 1: 
//
// 
//Input: [1,2,2]
//Output: 1
//Explanation:  After 1 move, the array could be [1, 2, 3].
// 
//
// 
// Example 2: 
//
// 
//Input: [3,2,1,2,1,7]
//Output: 6
//Explanation:  After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
//It can be shown with 5 or less moves that it is impossible for the array to ha
//ve all unique values.
// 
//
// 
// 
//
// Note: 
//
// 
// 0 <= A.length <= 40000 
// 0 <= A[i] < 40000 
// 
//
// 
// 
// Related Topics Array


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minIncrementForUnique(int[] A) {
        LinkedList<Integer> queue = new LinkedList<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num: A) count.put(num, count.getOrDefault(num, 0) + 1);
        int ans = 0;
        for (int i=0; i<100000; i++){
            count.putIfAbsent(i, 0);
            if (count.get(i)>=2){
                while (count.get(i)>=2){
                    queue.offer(i);
                    count.put(i, count.get(i)-1);
                }
            }else if(!queue.isEmpty() && count.get(i)==0){
                ans += i - queue.poll();
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
