//Design a Snake game that is played on a device with screen size = width x height. Play the game online if you are not familiar with the game. 
//
// The snake is initially positioned at the top left corner (0,0) with length = 1 unit. 
//
// You are given a list of food's positions in row-column order. When a snake eats the food, its length and the game's score both increase by 1. 
//
// Each food appears one by one on the screen. For example, the second food will not appear until the first food was eaten by the snake. 
//
// When a food does appear on the screen, it is guaranteed that it will not appear on a block occupied by the snake. 
//
// Example: 
//
// 
//Given width = 3, height = 2, and food = [[1,2],[0,1]].
//
//Snake snake = new Snake(width, height, food);
//
//Initially the snake appears at position (0,0) and the food at (1,2).
//
//|S| | |
//| | |F|
//
//snake.move("R"); -> Returns 0
//
//| |S| |
//| | |F|
//
//snake.move("D"); -> Returns 0
//
//| | | |
//| |S|F|
//
//snake.move("R"); -> Returns 1 (Snake eats the first food and right after that, the second food appears at (0,1) )
//
//| |F| |
//| |S|S|
//
//snake.move("U"); -> Returns 1
//
//| |F|S|
//| | |S|
//
//snake.move("L"); -> Returns 2 (Snake eats the second food)
//
//| |S|S|
//| | |S|
//
//snake.move("U"); -> Returns -1 (Game over because snake collides with border)
// 
// Related Topics Design Queue


import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class SnakeGame {
    int width;
    int height;
    LinkedList<int[]> food;
    LinkedList<int[]> trace;
    HashSet<int[]> body;
    int score;

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = new LinkedList<>();
        for (int i=0; i<food.length; i++) this.food.add(food[i]);
        this.trace = new LinkedList<>();
        this.trace.add(new int[]{0,0});
        this.score = 0;
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int[] first = trace.peekFirst();
        int[] head = new int[2];
        head[0] =  first[0];
        head[1] = first[1];
        if (direction.equals("U")) head[0]--;
        else if (direction.equals("D")) head[0]++;
        else if (direction.equals("L")) head[1]--;
        else head[1]++;
        if (head[0]<0 || head[0]>=height || head[1]<0 || head[1]>=width) return -1;
        int[] tail = trace.pollLast();
        for (int i=0; i< trace.size(); i++){
            int[] t = trace.get(i);
            if (head[0]==t[0] && head[1]==t[1]) return -1;
        }
        if (!food.isEmpty()){
            int[] fd = food.peekFirst();
            if (fd[0] == head[0] && fd[1]==head[1]){
                food.pollFirst();
                trace.addLast(tail);
                score++;
            }
        }
        trace.addFirst(head);
        return score;

        
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
//leetcode submit region end(Prohibit modification and deletion)
