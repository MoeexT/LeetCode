package util;

public class Tweet {
    public int userId;
    public int tweetId;

    public Tweet(int userId, int tweetId) {
        this.userId = userId;
        this.tweetId = tweetId;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "userId=" + userId +
                ", tweetId=" + tweetId +
                '}';
    }
}
