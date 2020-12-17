//Given an input string , reverse the string word by word. 
//
// Example: 
//
// 
//Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
//Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"] 
//
// Note: 
//
// 
// A word is defined as a sequence of non-space characters. 
// The input string does not contain leading or trailing spaces. 
// The words are always separated by a single space. 
// 
//
// Follow up: Could you do it in-place without allocating extra space? 
// Related Topics String



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void reverseWords(char[] s) {
        int n = s.length;
        int i = -1;
        int j = 0;
        while (j<n){
            if (s[j]==' '){
                reverse(s, i+1, j-1);
                i = j;
            }
            j++;
        }
        reverse(s, i+1, n-1);
        reverse(s, 0, n-1);
        
    }
    private void reverse(char[] s, int start, int end){
        int left = start;
        int right = end;
        while (left<right){
            char t = s[left];
            s[left] = s[right];
            s[right] = t;
            left++;
            right--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
