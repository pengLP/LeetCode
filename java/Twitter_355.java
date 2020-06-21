import java.util.*;

/**
 * 355. 设计推特
 * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：
 * postTweet(userId, tweetId): 创建一条新的推文
 * getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。
 * 推文必须按照时间顺序由最近的开始排序。
 * follow(followerId, followeeId): 关注一个用户
 * unfollow(followerId, followeeId): 取消关注一个用户
 */
public class Twitter_355 {

    class Tweet {
        Integer tweetId;
        Integer time;

        public Tweet(Integer tweetId) {
            this.tweetId = tweetId;
            count++;
        }
    }

    /**
     * 用户关注列表
     */
    private Map<Integer, Set<Integer>> follows;

    /**
     * 用户推文列表
     */
    private Map<Integer, LinkedList<Tweet>> tweets;

    /**
     * 优先级队列，用来合并排序队列
     */
    private PriorityQueue<Tweet> maxHeap;

    /**
     * 时间戳
     */
    private Integer count;

    public Twitter_355() {
        follows = new HashMap<>();
        tweets = new HashMap<>();
        maxHeap = new PriorityQueue<>(new Comparator<Tweet>() {
            @Override
            public int compare(Tweet o1, Tweet o2) {
                return o2.time - o1.time;
            }
        });
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        if (tweets.containsKey(userId)) {
            LinkedList<Tweet> tweet = tweets.get(userId);
            tweet.add(new Tweet(tweetId));
        } else {
            LinkedList<Tweet> tweet = new LinkedList<>();
            tweet.add(new Tweet(tweetId));
            tweets.put(userId, tweet);
        }

    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        maxHeap.clear();
        Set<Integer> follow = follows.get(userId);
        if (follow != null && follow.size() > 0) {
            for (Integer follower : follow) {
                LinkedList<Tweet> t = tweets.get(follower);
                if (t != null) {

                }
            }
        }
        return null;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (followeeId == followerId)
            return;
        Set<Integer> set = follows.get(followeeId);
        if (set == null) {
            set = new HashSet<>();
            set.add(followeeId);
            follows.put(followeeId, set);
        } else {
            if (set.contains(followerId)) {
                return;
            }
            set.add(followeeId);
        }
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (followeeId == followerId)
            return;
        Set<Integer> set = follows.get(followerId);
        if (set == null)
            return;
        set.remove(followeeId);
    }

    public static void main(String[] args) {
        Twitter_355 twitter_355 = new Twitter_355();
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.remove());
        System.out.println(list);
    }
}
