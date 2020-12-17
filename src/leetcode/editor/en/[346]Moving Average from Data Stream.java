//Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window. 
//
// Example: 
//
// 
//MovingAverage m = new MovingAverage(3);
//m.next(1) = 1
//m.next(10) = (1 + 10) / 2
//m.next(3) = (1 + 10 + 3) / 3
//m.next(5) = (10 + 3 + 5) / 3
// 
//
// 
// Related Topics Design Queue


import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class MovingAverage {
    int size;
    LinkedList<Integer> queue;
    int sum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        this.queue = new LinkedList<>();
        this.sum = 0;
    }
    
    public double next(int val) {
        if (queue.size()==size){
            int num = queue.removeFirst();
            sum -= num;
        }
        queue.addLast(val);
        sum += val;
        return Double.valueOf(sum)/queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
//leetcode submit region end(Prohibit modification and deletion)
