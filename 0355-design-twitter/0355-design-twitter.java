import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Twitter {

    class Tweet{
        int userId;
        int tweetId;

        Tweet(int userId, int tweetId){
            this.userId = userId;
            this.tweetId = tweetId;
        }
    }

    HashMap<Integer, Set> users;
    List<Tweet> tweets;

    public Twitter() {
        users = new HashMap<>();
        tweets = new ArrayList<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.add(new Tweet(userId, tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        int i = tweets.size() - 1;
        while(i >= 0){
            if(result.size() == 10 || tweets.isEmpty())
                return result;
            Tweet current = tweets.get(i);
            if(current.userId == userId || users.containsKey(userId) && (users.get(userId).contains(current.userId)))
                result.add(current.tweetId);
            i--;
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!users.containsKey(followerId))
            users.put(followerId, new HashSet<>());
        users.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!users.containsKey(followerId))
            return;
        users.get(followerId).remove(followeeId);
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