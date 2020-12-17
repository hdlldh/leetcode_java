//Given a 2D board and a list of words from the dictionary, find all words in the board. 
//
// Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word. 
//
// 
//
// Example: 
//
// 
//Input: 
//board = [
//  ['o','a','a','n'],
//  ['e','t','a','e'],
//  ['i','h','k','r'],
//  ['i','f','l','v']
//]
//words = ["oath","pea","eat","rain"]
//
//Output: ["eat","oath"]
// 
//
// 
//
// Note: 
//
// 
// All inputs are consist of lowercase letters a-z. 
// The values of words are distinct. 
// 
// Related Topics Backtracking Trie


import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class TrieNode {
    char ch;
    HashMap<Character, TrieNode> children=new HashMap<>();
    boolean isEnd=false;
}
class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public void insert(String word) {
        TrieNode p = root;
        for(char ch: word.toCharArray()){
            p = p.children.computeIfAbsent(ch, c->new TrieNode());
        }
        p.children.put('$', new TrieNode());
    }
    public boolean startsWith(String s){
        TrieNode p = root;
        for(char ch: s.toCharArray()){
            if (!p.children.containsKey(ch)) return false;
            p = p.children.get(ch);
        }
        return true;
    }
    public boolean search(String s){
        TrieNode p = root;
        for(char ch: s.toCharArray()){
            if (!p.children.containsKey(ch)) return false;
            p = p.children.get(ch);
        }
        if (p.children.containsKey('$')) return true;
        return false;
    }

}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        if (m==0) return new ArrayList<>();
        int n = board[0].length;
        Trie trie = new Trie();
        for(String s: words) trie.insert(s);
        HashSet<String> ans = new HashSet<>();
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                dfs(board, i, j, trie, "", ans);
            }
        }
        List<String> ans1 = new ArrayList<>();
        for (String s:ans) ans1.add(s);
        return ans1;
    }
    private void dfs(char[][] board, int i, int j, Trie trie, String s, HashSet ans){
        int m = board.length;
        int n = board[0].length;
        if (i<0 || i>=m || j<0 || j>=n) return;
        s += board[i][j];
        if (!trie.startsWith(s)) return;
        if (trie.search(s)) ans.add(s);
        char tmp = board[i][j];
        board[i][j] = '#';
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        for (int k=0; k<4; k++){
            dfs(board, i+dx[k], j+dy[k], trie, s, ans);
        }
        board[i][j] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
