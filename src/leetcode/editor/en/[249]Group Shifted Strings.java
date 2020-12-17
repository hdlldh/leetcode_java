//Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence: 
//
// 
//"abc" -> "bcd" -> ... -> "xyz" 
//
// Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence. 
//
// Example: 
//
// 
//Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
//Output: 
//[
//  ["abc","bcd","xyz"],
//  ["az","ba"],
//  ["acef"],
//  ["a","z"]
//]
// 
// Related Topics Hash Table String


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> ans = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for (String str: strings){
            String sig = "0";
            if (str.length()>1) {
                for (int i = 1; i < str.length(); i++) {
                    sig += ((str.charAt(i) - str.charAt(i - 1)+26) % 26);
                }
            }
            List<String> t;
            if (map.containsKey(sig)) t = map.get(sig);
            else t = new ArrayList<>();
            t.add(str);
            map.put(sig, t);
            }

        for (List<String> m: map.values()){
            ans.add(m);
        }
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
