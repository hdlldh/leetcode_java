//Given a non-empty array of integers, return the k most frequent elements. 
//
// Example 1: 
//
// 
//Input: nums = [1,1,1,2,2,3], k = 2
//Output: [1,2]
// 
//
// 
// Example 2: 
//
// 
//Input: nums = [1], k = 1
//Output: [1] 
// 
//
// Note: 
//
// 
// You may assume k is always valid, 1 ≤ k ≤ number of unique elements. 
// Your algorithm's time complexity must be better than O(n log n), where n is the array's size. 
// 
// Related Topics Hash Table Heap


import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int num: nums) counter.put(num, counter.getOrDefault(num, 0)+1);
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(pair->pair.count));
        for (int num: counter.keySet()){
            int count = counter.get(num);
            pq.offer(new Pair(num, count));
            if (pq.size() > k) pq.poll();
        }
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            ans.add(p.num);
        }
        Collections.reverse(ans);
        return ans;
    }
}
class Pair{
    int num;
    int count;
    public Pair(int num, int count){
        this.num = num;
        this.count = count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
