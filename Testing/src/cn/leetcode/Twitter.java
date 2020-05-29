package cn.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Iterator;
import java.util.LinkedList;

public class Twitter {
	
	
	LinkedList<HashMap<Integer, Integer>> tweetList;
	HashMap<Integer,HashSet<Integer>> user;
	
	
    /** Initialize your data structure here. */
    public Twitter() {
    	tweetList= new LinkedList<HashMap<Integer, Integer>>();
    	user = new HashMap<Integer,HashSet<Integer>> ();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
    	HashMap<Integer, Integer> tweet = new HashMap<Integer, Integer>();
    	tweet.put(userId, tweetId);
    	tweetList.add(tweet);
    	tweetList.get(tweetList.size()-1);

    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
    	
    	List<Integer> res = new ArrayList <Integer>();
    	if(!tweetList.isEmpty()) {
    		Iterator<HashMap<Integer, Integer>> iter =tweetList.descendingIterator();
    		while(iter.hasNext()) {
    		
    			HashMap<Integer, Integer> tweet =iter.next();
    			Map.Entry<Integer, Integer>entry=tweet.entrySet().iterator().next();
    	
    			if(entry.getKey()==userId && res.size()<10) {
    				res.add(entry.getValue());
    			}else if(user.containsKey(userId)&&user.get(userId).contains(entry.getKey())&& res.size()<10) {
    				res.add(entry.getValue());
    			}
    		}
    	}
    	return res;

    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
    	if(user.containsKey(followerId)) {
    		HashSet<Integer> followeeSet=user.get(followerId);
        	followeeSet.add(followeeId);
    	}else {
    		 HashSet<Integer> followee=new HashSet<Integer>();
             followee.add(followeeId);
    		user.put(followerId, followee);
    	}
    	

    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
    	if(user.containsKey(followerId)) {
    		HashSet<Integer> followeeSet=user.get(followerId);
        	followeeSet.remove(followeeId);
    	}
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