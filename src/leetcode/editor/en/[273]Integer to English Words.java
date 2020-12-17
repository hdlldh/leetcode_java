//Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1. 
//
// Example 1: 
//
// 
//Input: 123
//Output: "One Hundred Twenty Three"
// 
//
// Example 2: 
//
// 
//Input: 12345
//Output: "Twelve Thousand Three Hundred Forty Five" 
//
// Example 3: 
//
// 
//Input: 1234567
//Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
// 
//
// Example 4: 
//
// 
//Input: 1234567891
//Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
// 
// Related Topics Math String



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String numberToWords(int num) {
        if (num==0) return "Zero";
        int billion = num / 1000000000;
        int million = (num - billion * 1000000000) / 1000000;
        int thousand = (num - billion * 1000000000 - million * 1000000) / 1000;
        int rest = num - billion * 1000000000 - million * 1000000 - thousand * 1000;

        String ans = "";
        if (billion!=0) ans += three(billion) + " Billion";
        if (million!=0){
            if (ans.length()!=0) ans += " ";
            ans += three(million) + " Million";
        }
        if (thousand!=0){
            if (ans.length()!=0) ans += " ";
            ans += three(thousand) + " Thousand";;
        }
        if (rest!=0){
            if (ans.length()!=0) ans += " ";
            ans += three(rest);
        }
        return ans;
    }
    public String oneDigit(int num) {
        switch(num) {
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
            default: return "";
        }
    }

    public String twoDigit(int num) {
        switch(num) {
            case 10: return "Ten";
            case 11: return "Eleven";
            case 12: return "Twelve";
            case 13: return "Thirteen";
            case 14: return "Fourteen";
            case 15: return "Fifteen";
            case 16: return "Sixteen";
            case 17: return "Seventeen";
            case 18: return "Eighteen";
            case 19: return "Nineteen";
            default: return "";
        }
    }

    public String tenDigit(int num) {
        switch(num) {
            case 2: return "Twenty";
            case 3: return "Thirty";
            case 4: return "Forty";
            case 5: return "Fifty";
            case 6: return "Sixty";
            case 7: return "Seventy";
            case 8: return "Eighty";
            case 9: return "Ninety";
            default: return "";
        }
    }

    public String two(int num){
        if (num <10) return oneDigit(num);
        else if(num<20) return twoDigit(num);
        else{
            int tens = num/10;
            int rest = num -tens*10;
            if (rest==0) return tenDigit(tens);
            else return tenDigit(tens) + " "+ oneDigit(rest);
        }
    }

    public String three(int num){
        int hundreds = num/100;
        int rest = num - hundreds*100;
        String ans = "";
        if (hundreds!=0) ans += oneDigit(hundreds) + " Hundred";
        if (rest != 0){
            if (ans.length()!=0) ans += " ";
            ans += two(rest);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
