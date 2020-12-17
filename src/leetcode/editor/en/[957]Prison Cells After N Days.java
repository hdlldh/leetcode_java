//There are 8 prison cells in a row, and each cell is either occupied or vacant.
// 
//
// Each day, whether the cell is occupied or vacant changes according to the fol
//lowing rules: 
//
// 
// If a cell has two adjacent neighbors that are both occupied or both vacant, t
//hen the cell becomes occupied. 
// Otherwise, it becomes vacant. 
// 
//
// (Note that because the prison is a row, the first and the last cells in the r
//ow can't have two adjacent neighbors.) 
//
// We describe the current state of the prison in the following way: cells[i] ==
// 1 if the i-th cell is occupied, else cells[i] == 0. 
//
// Given the initial state of the prison, return the state of the prison after N
// days (and N such changes described above.) 
//
// 
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
//Input: cells = [0,1,0,1,1,0,0,1], N = 7
//Output: [0,0,1,1,0,0,0,0]
//Explanation: 
//The following table summarizes the state of the prison on each day:
//Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
//Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
//Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
//Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
//Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
//Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
//Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
//Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
//
// 
//
// 
// Example 2: 
//
// 
//Input: cells = [1,0,0,1,0,0,1,0], N = 1000000000
//Output: [0,0,1,1,1,1,1,0]
// 
//
// 
//
// Note: 
//
// 
// cells.length == 8 
// cells[i] is in {0, 1} 
// 1 <= N <= 10^9 
// 
// 
// 
// Related Topics Hash Table


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int first = -1;
        int period = -1;
        int[] cells1;
        for (int i=1; i<=N; i++){
            cells1 = new int[8];
            int state = 0;
            for (int l=1;l<7;l++){
                cells1[l] = (cells[l-1]==cells[l+1])?1:0;
                if (cells[l-1]==cells[l+1]) state |= 1<<l;
            }
            cells = cells1;
            if (!hmap.containsKey(state)) hmap.put(state, i);
            else{
                first = hmap.get(state);
                period = i - first;
                break;
            }
        }
        if (first==-1) return cells;
        N = (N-first)%period;
        for (int i=1; i<=N; i++) {
            cells1 = new int[8];
            int state = 0;
            for (int l = 1; l < 7; l++) {
                cells1[l] = (cells[l - 1] == cells[l + 1]) ? 1 : 0;
                if (cells[l - 1] == cells[l + 1]) state |= 1 << l;
            }
            cells = cells1;
        }
        return cells;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
