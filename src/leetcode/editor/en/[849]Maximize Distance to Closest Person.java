//In a row of seats, 1 represents a person sitting in that seat, and 0 represent
//s that the seat is empty. 
//
// There is at least one empty seat, and at least one person sitting. 
//
// Alex wants to sit in the seat such that the distance between him and the clos
//est person to him is maximized. 
//
// Return that maximum distance to closest person. 
//
// 
// Example 1: 
//
// 
//Input: [1,0,0,0,1,0,1]
//Output: 2
//Explanation: 
//If Alex sits in the second open seat (seats[2]), then the closest person has d
//istance 2.
//If Alex sits in any other open seat, the closest person has distance 1.
//Thus, the maximum distance to the closest person is 2. 
//
// 
// Example 2: 
//
// 
//Input: [1,0,0,0]
//Output: 3
//Explanation: 
//If Alex sits in the last seat, the closest person is 3 seats away.
//This is the maximum distance possible, so the answer is 3.
// 
//
// Note: 
//
// 
// 1 <= seats.length <= 20000 
// seats contains only 0s or 1s, at least one 0, and at least one 1. 
// 
// 
// 
// Related Topics Array


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        ArrayList<Integer> occupied = new ArrayList<>();
        for (int i=0; i<n; i++){
            if (seats[i]==1) occupied.add(i);
        }
        int ans = 0;
        ans = Math.max(ans, occupied.get(0));
        ans = Math.max(ans, n - occupied.get(occupied.size()-1) -1);
        for (int i=1; i<occupied.size(); i++){
            ans = Math.max(ans, (occupied.get(i)-occupied.get(i-1))/2);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
