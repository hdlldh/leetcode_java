//Write a function that takes a string as input and reverse only the vowels of a string. 
//
// Example 1: 
//
// 
//Input: "hello"
//Output: "holle"
// 
//
// 
// Example 2: 
//
// 
//Input: "leetcode"
//Output: "leotcede" 
// 
//
// Note: 
//The vowels does not include the letter "y". 
//
// 
// Related Topics Two Pointers String



//leetcode submit region begin(Prohibit modification and deletion)
import java.util.*;
class Solution {
    public String reverseVowels(String s) {
        int n = s.length();
        if (n==0) return s;
        char[] ans = s.toCharArray();
        ArrayList<Character> vowels = new ArrayList<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        int i =0;
        int j = n-1;
        while (i<j){
            while (i<j && !vowels.contains(ans[i])) i++;
            while (i<j && !vowels.contains(ans[j])) j--;
            if (i<j){
                char t = ans[i];
                ans[i] = ans[j];
                ans[j] = t;
                i++;
                j--;
            }
        }
        return new String(ans);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
