//Given an array of strings, group anagrams together. 
//
// Example: 
//
// 
//Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
//Output:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// Note: 
//
// 
// All inputs will be in lowercase. 
// The order of your output does not matter. 
// 
// Related Topics Hash Table String


import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String str: strs){
            String sig = getSignature(str);
            ArrayList<String> t;
            if (map.containsKey(sig)){
                t = map.get(sig);
            }else{
                t = new ArrayList<>();
            }
            t.add(str);
            map.put(sig, t);
        }
        List<List<String>> ans = new ArrayList<>();
        for (String sig: map.keySet()){
            ans.add(map.get(sig));
        }
        return ans;
        
    }
    private String getSignature(String str){
        int[] sig = new int[26];
        Arrays.fill(sig, 0);
        for (char ch: str.toCharArray()) sig[ch-'a']++;
        String ans = "";
        for (int num: sig) ans += num;
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
