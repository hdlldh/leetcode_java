//In the "100 game," two players take turns adding, to a running total, any inte
//ger from 1..10. The player who first causes the running total to reach or exceed
// 100 wins. 
//
// What if we change the game so that players cannot re-use integers? 
//
// For example, two players might take turns drawing from a common pool of numbe
//rs of 1..15 without replacement until they reach a total >= 100. 
//
// Given an integer maxChoosableInteger and another integer desiredTotal, determ
//ine if the first player to move can force a win, assuming both players play opti
//mally. 
//
// You can always assume that maxChoosableInteger will not be larger than 20 and
// desiredTotal will not be larger than 300.
// 
//
// Example
// 
//Input:
//maxChoosableInteger = 10
//desiredTotal = 11
//
//Output:
//false
//
//Explanation:
//No matter which integer the first player choose, the first player will lose.
//The first player can choose an integer from 1 up to 10.
//If the first player choose 1, the second player can only choose integers from 
//2 up to 10.
//The second player will win by choosing 10 and get a total = 11, which is >= de
//siredTotal.
//Same with other integers chosen by the first player, the second player will al
//ways win.
// 
// Related Topics Dynamic Programming Minimax


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    HashMap<Integer, Boolean> mem;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger>=desiredTotal) return true;
        if ((maxChoosableInteger+1)*maxChoosableInteger/2<desiredTotal) return false;
        mem = new HashMap<>();
        return helper(maxChoosableInteger, desiredTotal, 0);
    }
    private boolean helper(int maxChoosableInteger, int desiredTotal, int used){
        if (desiredTotal<=0) return false;
        if (mem.containsKey(used)) return mem.get(used);
        for (int i=1; i<=maxChoosableInteger; i++){
            int cur = 1<<i;
            if ((used & cur) == 0){
                if (!helper(maxChoosableInteger, desiredTotal-i, used | cur)){
                    mem.put(used, true);
                    return true;
                }
            }
        }
        mem.put(used, false);
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
