package Heaps;

import java.util.*;

public class TwitterSol {

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 4); // User 1 posts a new tweet (id = 5).
        twitter.postTweet(2, 5); // User 1 posts a new tweet (id = 5).

//        System.out.println("NewsFeed : ");
//        twitter.getNewsFeed(1).forEach(System.out::println);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]

        twitter.unfollow(1, 2);
        twitter.follow(1, 2);


        System.out.println("NewsFeed : ");
        twitter.getNewsFeed(1).forEach(System.out::println);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]

//        twitter.unfollow(1, 2);  // User 1 unfollows user 2.
//
//        System.out.println("NewsFeed : ");
//        twitter.getNewsFeed(1).forEach(System.out::println);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
    }

    static class Twitter {

        Map<Integer, Set<Integer>> followMap;
        Map<Integer, List<Tweet>> feedMap;
        static Integer counter = 0;

        public Twitter() {
            followMap = new HashMap<>();
            feedMap = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            if (!feedMap.containsKey(userId)) feedMap.put(userId, new ArrayList<>());

            Tweet tweet = new Tweet().setUserId(userId).setTweetId(tweetId).setTweetCount(++counter);

            /* add for self */
            feedMap.get(userId).add(tweet);
        }

        public void follow(int followerId, int followeeId) {
            if (!followMap.containsKey(followerId)) {
                followMap.put(followerId, new HashSet<>());
            }
            followMap.get(followerId).add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            if (followMap.containsKey(followerId)) followMap.get(followerId).remove(followeeId);
        }

        public List<Integer> getNewsFeed(int userId) {

            List<Integer> res = new ArrayList<>();
            List<Tweet> resTweetList = new ArrayList<>();
            PriorityQueue<Tweet> pq = new PriorityQueue<>((t1, t2) -> t2.tweetCount - t1.tweetCount);

            if (!followMap.containsKey(userId)) {
                followMap.put(userId, new HashSet<>());
            }
            followMap.get(userId).add(userId);

            var followSet = followMap.get(userId);

            for (Integer follower : followSet) {
                List<Tweet> tweetList = feedMap.get(follower);
                if (tweetList != null && !tweetList.isEmpty()) {

                    resTweetList.addAll(tweetList);

                }
            }


            resTweetList.sort((t1, t2) -> t2.tweetCount - t1.tweetCount);

            int count = 0;
            for (Tweet tweet : resTweetList) {
                if (count >= 10) {
                    break; // We only need the top 10
                }
                res.add(tweet.tweetId);
                count++;
            }

//        while (!pq.isEmpty() && res.size() < 10) {
//            res.add(pq.poll().tweetId);
//        }

            return res;
        }

    }

    static class Tweet {

        public Integer userId;
        public Integer tweetId;
        public Integer tweetCount;

        public Tweet setUserId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public Tweet setTweetId(Integer tweetId) {
            this.tweetId = tweetId;
            return this;
        }

        public Tweet setTweetCount(Integer tweetCount) {
            this.tweetCount = tweetCount;
            return this;
        }


    }

}
