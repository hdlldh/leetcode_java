//On a single threaded CPU, we execute some functions. Each function has a uniqu
//e id between 0 and N-1. 
//
// We store logs in timestamp order that describe when a function is entered or 
//exited. 
//
// Each log is a string with this format: "{function_id}:{"start" | "end"}:{time
//stamp}". For example, "0:start:3" means the function with id 0 started at the be
//ginning of timestamp 3. "1:end:2" means the function with id 1 ended at the end 
//of timestamp 2. 
//
// A function's exclusive time is the number of units of time spent in this func
//tion. Note that this does not include any recursive calls to child functions. 
//
// The CPU is single threaded which means that only one function is being execut
//ed at a given time unit. 
//
// Return the exclusive time of each function, sorted by their function id. 
//
// 
//
// Example 1: 
//
// 
//
// 
//Input:
//n = 2
//logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
//Output: [3, 4]
//Explanation:
//Function 0 starts at the beginning of time 0, then it executes 2 units of time
// and reaches the end of time 1.
//Now function 1 starts at the beginning of time 2, executes 4 units of time and
// ends at time 5.
//Function 0 is running again at the beginning of time 6, and also ends at the e
//nd of time 6, thus executing for 1 unit of time. 
//So function 0 spends 2 + 1 = 3 units of total time executing, and function 1 s
//pends 4 units of total time executing.
// 
//
// 
//
// Note: 
//
// 
// 1 <= n <= 100 
// Two functions won't start or end at the same time. 
// Functions will always log when they exit. 
// 
//
// 
// Related Topics Stack


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        int prev = 0;
        int cur = 0;
        Stack<Integer> stack = new Stack<>();
        for (String log: logs){
            String[] log_arr= log.split(":");
            int fid = Integer.valueOf(log_arr[0]);
            String action = log_arr[1];
            cur = Integer.valueOf(log_arr[2]);
            if (action.charAt(0)=='s'){
                if (!stack.empty()){
                    ans[stack.peek()] += cur - prev;
                }
                stack.push(fid);
                prev = cur;
            }else{
                ans[stack.peek()] += cur - prev + 1;
                stack.pop();
                prev = cur+1;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
