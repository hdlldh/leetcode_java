//There are N workers. The i-th worker has a quality[i] and a minimum wage expectation wage[i]. 
//
// Now we want to hire exactly K workers to form a paid group. When hiring a group of K workers, we must pay them according to the following rules: 
//
// 
// Every worker in the paid group should be paid in the ratio of their quality compared to other workers in the paid group. 
// Every worker in the paid group must be paid at least their minimum wage expectation. 
// 
//
// Return the least amount of money needed to form a paid group satisfying the above conditions. 
//
// 
//
// 
// 
//
// 
// Example 1: 
//
// 
//Input: quality = [10,20,5], wage = [70,50,30], K = 2
//Output: 105.00000
//Explanation: We pay 70 to 0-th worker and 35 to 2-th worker.
// 
//
// 
// Example 2: 
//
// 
//Input: quality = [3,1,10,10,1], wage = [4,8,2,2,7], K = 3
//Output: 30.66667
//Explanation: We pay 4 to 0-th worker, 13.33333 to 2-th and 3-th workers seperately. 
// 
//
// 
//
// Note: 
//
// 
// 1 <= K <= N <= 10000, where N = quality.length = wage.length 
// 1 <= quality[i] <= 10000 
// 1 <= wage[i] <= 10000 
// Answers within 10^-5 of the correct answer will be considered correct. 
// 
// 
// 
// Related Topics Heap


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Pair{
    double ratio;
    int quality;
    Pair(double ratio, int quality){
        this.ratio = ratio;
        this.quality = quality;
    }
}
class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int n = quality.length;
        Pair[] workers = new Pair[n];
        for (int i=0; i<n; i++){
            workers[i] = new Pair(Double.valueOf(wage[i])/quality[i], quality[i]);
        }

        Arrays.sort(workers, Comparator.comparing((Pair x)-> x.ratio));
        for(int i=0; i<n; i++){
            System.out.println(workers[i].quality);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparing((x)->-x));
        int qsum = 0;
        double ans = Double.MAX_VALUE;
        for (int i=0; i<n; i++){
            Pair p = workers[i];
            double ratio = p.ratio;
            int q = p.quality;
            pq.offer(q);
            qsum += q;
            if (pq.size()>K){
                q = pq.poll();
                qsum -= q;
            }
            if (pq.size()==K){
                ans = Math.min(ans, ratio*qsum);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
