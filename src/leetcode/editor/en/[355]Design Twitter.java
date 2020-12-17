//Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods: 
//
// 
// 
// postTweet(userId, tweetId): Compose a new tweet. 
// getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. 
// follow(followerId, followeeId): Follower follows a followee. 
// unfollow(followerId, followeeId): Follower unfollows a followee. 
// 
// 
//
// Example:
// 
//Twitter twitter = new Twitter();
//
//// User 1 posts a new tweet (id = 5).
//twitter.postTweet(1, 5);
//
//// User 1's news feed should return a list with 1 tweet id -> [5].
//twitter.getNewsFeed(1);
//
//// User 1 follows user 2.
//twitter.follow(1, 2);
//
//// User 2 posts a new tweet (id = 6).
//twitter.postTweet(2, 6);
//
//// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
//// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
//twitter.getNewsFeed(1);
//
//// User 1 unfollows user 2.
//twitter.unfollow(1, 2);
//
//// User 1's news feed should return a list with 1 tweet id -> [5],
//// since user 1 is no longer following user 2.
//twitter.getNewsFeed(1);
// 
// Related Topics Hash Table Heap Design

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Twitter {
    int timeId;
    HashMap<Integer, ArrayList<int[]>> tweets;
    HashMap<Integer, HashSet<Integer>> followee;
    /** Initialize your data structure here. */
    public Twitter() {
        timeId = 0;
        tweets = new HashMap<>();
        followee = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        ArrayList<int[]> tweet = tweets.getOrDefault(userId, new ArrayList<>());
        int[] news = {timeId, tweetId};
        tweet.add(news);
        tweets.put(userId, tweet);
        timeId++;
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing((int[] x)->x[0]));
        if (tweets.containsKey(userId)){
            for (int[] news: tweets.get(userId)){
                pq.offer(news);
                if (pq.size()>10) pq.poll();
            }
        }
        if (followee.containsKey(userId)){
            for (int fid: followee.get(userId)){
                if (!tweets.containsKey(fid)) continue;
                for (int[] news: tweets.get(fid)){
                    pq.offer(news);
                    if (pq.size()>10) pq.poll();
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()){
            int[] news = pq.poll();
            ans.add(news[1]);
        }
        Collections.reverse(ans);
        return ans;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId!=followeeId){
            HashSet<Integer> fs = followee.getOrDefault(followerId, new HashSet<>());
            fs.add(followeeId);
            followee.put(followerId, fs);
        }
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (!followee.containsKey(followerId)) return;
        HashSet<Integer> fs = followee.get(followerId);
        if (fs.contains(followeeId)) fs.remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
//leetcode submit region end(Prohibit modification and deletion)
