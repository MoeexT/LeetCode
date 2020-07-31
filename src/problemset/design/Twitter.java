package problemset.design;

/*
 * @date_time: 2020-04-13 11:50
 * @author: MoeexT
 * @problem: 355
 * @url: https://leetcode-cn.com/problems/design-twitter/
 */

import util.Tweet;

import java.util.*;

public class Twitter {
    /**
     * 你问我还有哪里需要改？
     * 我可去你m的吧，获取推文要倒序，但是不能在要返回的List里执行add(0,Id),
     * 因为逻辑不对，自己想草泥马
     * 需要插入推文的时候直接插入到链表头，但是addFirst我tm用不对，也没深究（ctm我也不想深究）
     * 全写一个文件里真是太麻烦了，加个时间戳也好，要不把上述逻辑实现了也行，我是不想写了ctm！
     */

    // 我发的推
//    private Map<Integer, LinkedList<Tweet>> userTweets = new HashMap<>();
    // 我发的推和我能看到的推
    private Map<Integer, LinkedList<Tweet>> timeLines;
    // 我关注的人
    private Map<Integer, HashSet<Integer>> following;
    // 关注我的人
    private Map<Integer, HashSet<Integer>> followed;

    private List<Tweet> timeLine;


    public Twitter() {
        timeLines = new HashMap<>();
        following = new HashMap<>();
        followed = new HashMap<>();
        timeLine = new LinkedList<>();
    }

    /**
     * 我发推文，关注我的人应该都能看到，
     * 需要把我的推文加到他们的时间线里去
     */
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(userId, tweetId);
        timeLine.add(tweet);

//        userTweets.getOrDefault(userId, new LinkedList<>()).add(tweet);
        addTweetToTimelines(userId, tweet);
        if (following.containsKey(userId)) {
            for (Integer follower : following.get(userId)) {
                addTweetToTimelines(follower, tweet);
            }
        }
        System.out.println(timeLine);
    }

    /**
     * 把推文加到某用户的时间线里
     */
    private void addTweetToTimelines(int userId, Tweet tweet) {
        if (timeLines.containsKey(userId)) {
            timeLines.get(userId).add(tweet);
        } else {
            LinkedList<Tweet> myTimeLine = new LinkedList<>();
            myTimeLine.add(0, tweet);
            timeLines.put(userId, myTimeLine);
        }
    }

    /**
     * 获取某人最近的十条推文
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new LinkedList<>();

        int newsCount = 10;

        if (timeLines.containsKey(userId)) {
            for (Tweet tweet : timeLines.get(userId)) {
                newsFeed.add(0, tweet.tweetId);
                if (newsCount-- == 0) {
                    break;
                }
            }
        }
        return newsFeed;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            // 自己关注自己，傻p
            return;
        }
        // 我关注了谁
        if (following.containsKey(followerId)) {
            following.get(followerId).add(followeeId);
        } else {
            HashSet<Integer> myFollowing = new HashSet<>();
            myFollowing.add(followeeId);
            following.put(followerId, myFollowing);
        }

        // 谁关注了我
        if (followed.containsKey(followeeId)) {
            followed.get(followeeId).add(followerId);
        } else {
            HashSet<Integer> myFollowed = new HashSet<>();
            myFollowed.add(followerId);
            followed.put(followeeId, myFollowed);
        }
        flushMyTimeLine(followerId);
    }

    /**
     * 当关注了一个人后，从总时间线里重新获取一遍关注人的推文，
     * 然后把这些推文加到我的时间线里
     */
    private void flushMyTimeLine(int userId) {
        LinkedList<Tweet> myTimeLine = new LinkedList<>();
        timeLines.put(userId, myTimeLine);
        for (Tweet cur : timeLine) {
            if (following.get(userId).contains(cur.userId) || cur.userId == userId) {
                myTimeLine.add(cur);
            }
        }
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            // 自己取关自己
            return;
        }
        if (following.containsKey(followerId) && !following.get(followerId).isEmpty()) {
            following.get(followerId).remove(followeeId);
        }

        if (followed.containsKey(followeeId) && !followed.get(followeeId).isEmpty()) {
            followed.get(followeeId).remove(followerId);
        }
        flushMyTimeLine(followerId);
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        /*twitter.postTweet(1, 1);
        System.out.println(twitter.getNewsFeed(1)); // [1]
        System.out.println(twitter.getNewsFeed(2)); // []
        twitter.follow(2, 1);
        System.out.println(twitter.getNewsFeed(2)); // [1]
        twitter.unfollow(2, 1);
        System.out.println(twitter.getNewsFeed(2)); // []*/

        twitter.postTweet(1, 5);
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        System.out.println(twitter.getNewsFeed(1));
        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1));

    }
}

