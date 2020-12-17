//In an exam room, there are N seats in a single row, numbered 0, 1, 2, ..., N-1
//. 
//
// When a student enters the room, they must sit in the seat that maximizes the 
//distance to the closest person. If there are multiple such seats, they sit in th
//e seat with the lowest number. (Also, if no one is in the room, then the student
// sits at seat number 0.) 
//
// Return a class ExamRoom(int N) that exposes two functions: ExamRoom.seat() re
//turning an int representing what seat the student sat in, and ExamRoom.leave(int
// p) representing that the student in seat number p now leaves the room. It is gu
//aranteed that any calls to ExamRoom.leave(p) have a student sitting in seat p. 
//
// 
//
// Example 1: 
//
// 
//Input: ["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[]
//,[],[4],[]]
//Output: [null,0,9,4,2,null,5]
//Explanation:
//ExamRoom(10) -> null
//seat() -> 0, no one is in the room, then the student sits at seat number 0.
//seat() -> 9, the student sits at the last seat number 9.
//seat() -> 4, the student sits at the last seat number 4.
//seat() -> 2, the student sits at the last seat number 2.
//leave(4) -> null
//seat() -> 5, the student sits at the last seat number 5.
// 
//
// 
//
// Note: 
//
// 
// 1 <= N <= 10^9 
// ExamRoom.seat() and ExamRoom.leave() will be called at most 10^4 times across
// all test cases. 
// Calls to ExamRoom.leave(p) are guaranteed to have a student currently sitting
// in seat number p. 
// 
// Related Topics Ordered Map

import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class ExamRoom {
    List<Integer> seats;
    int N;
    public ExamRoom(int N) {
        seats = new ArrayList<>();
        this.N = N;
    }
    
    public int seat() {
        if (seats.size() == 0){
            seats.add(0);
            return 0;
        }
        int dmax = -1;
        int s = 0;
        if (seats.get(0)!=0){
            int d = seats.get(0);
            if (d>dmax){
                dmax = d;
                s = 0;
            }
        }
        for (int i=1; i<seats.size(); i++){
            if (seats.get(i-1)+1==seats.get(i)) continue;
            int d = (seats.get(i)-seats.get(i-1))/2;
            if (d>dmax){
                dmax = d;
                s = (seats.get(i)+seats.get(i-1))/2;
            }
        }
        if (seats.get(seats.size()-1)!=N-1){
            int d = N-1 - seats.get(seats.size()-1);
            if (d>dmax){
                dmax = d;
                s = N-1;
            }
        }
        int idx = Collections.binarySearch(seats, s);
        if (idx < 0 ) idx = -idx -1;
        seats.add(idx, s);
        return s;
    }
    
    public void leave(int p) {
        int idx = Collections.binarySearch(seats, p);
        if (idx<0) idx = -idx -1;
        if (idx < seats.size() && seats.get(idx)==p){
            List<Integer> t = seats.subList(0, idx);
            t.addAll(seats.subList(idx+1, seats.size()));
            seats = t;
        }
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
//leetcode submit region end(Prohibit modification and deletion)
