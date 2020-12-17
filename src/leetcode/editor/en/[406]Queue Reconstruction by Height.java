//Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue. 
//
// Note: 
//The number of people is less than 1,100. 
// 
//
// Example 
//
// 
//Input:
//[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
//
//Output:
//[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
// 
//
// 
// Related Topics Greedy


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, Comparator.comparing((int[] x)->-x[0]).thenComparing((int[] x)->x[1]));
        ArrayList<int[]> ans = new ArrayList<>();
        int n = people.length;
        for (int i=0; i<n; i++){
            ans.add(people[i][1],people[i]);
        }
        int[][] res = new int[ans.size()][2];
        for (int i=0; i< ans.size(); i++){
            res[i] = ans.get(i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
