//Suppose we abstract our file system by a string in the following manner: 
//
// The string "dir
//\tsubdir1
//\tsubdir2
//\t\tfile.ext" represents: 
//
// dir
//    subdir1
//    subdir2
//        file.ext
// 
//
// The directory dir contains an empty sub-directory subdir1 and a sub-directory
// subdir2 containing a file file.ext. 
//
// The string "dir
//\tsubdir1
//\t\tfile1.ext
//\t\tsubsubdir1
//\tsubdir2
//\t\tsubsubdir2
//\t\t\tfile2.ext" represents: 
//
// dir
//    subdir1
//        file1.ext
//        subsubdir1
//    subdir2
//        subsubdir2
//            file2.ext
// 
//
// The directory dir contains two sub-directories subdir1 and subdir2. subdir1 c
//ontains a file file1.ext and an empty second-level sub-directory subsubdir1. sub
//dir2 contains a second-level sub-directory subsubdir2 containing a file file2.ex
//t. 
//
// We are interested in finding the longest (number of characters) absolute path
// to a file within our file system. For example, in the second example above, the
// longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its length is 
//32 (not including the double quotes). 
//
// Given a string representing the file system in the above format, return the l
//ength of the longest absolute path to file in the abstracted file system. If the
//re is no file in the system, return 0. 
//
// Note: 
// 
// The name of a file contains at least a . and an extension. 
// The name of a directory or sub-directory will not contain a .. 
// 
// 
//
// Time complexity required: O(n) where n is the size of the input string. 
//
// Notice that a/aa/aaa/file1.txt is not the longest file path, if there is anot
//her path aaaaaaaaaaaaaaaaaaaaa/sth.png.


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthLongestPath(String input) {
        HashMap<Integer, Integer> mem = new HashMap<>();
        mem.put(0, 0);
        int ans = 0;
        for (String s: input.split("\n")){
            int level = (s.contains("\t"))?s.lastIndexOf('\t')+1:0;
            int len = s.substring(level).length();
            if (s.contains(".")){
                ans = Math.max(ans, mem.get(level)+len);
            }else{
                mem.put(level+1, mem.get(level)+len+1);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
