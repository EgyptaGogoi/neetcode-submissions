

class Twitter {
    
    static int timestamp = 0;

    Map<Integer, User> userMap; // containsKey about a user's data wrt user_id(int)

    class Tweet{
        int id;
        int time;
        Tweet next;

        public Tweet(int id){
            this.id = id;
            this.time = timestamp++;
            next = null;
        }   
    }

    class User{
        public int user_id;
        public Tweet tweetHead;
        public Set<Integer> following;


        public User(int user_id){
            this.user_id = user_id;
            following = new HashSet<>();
            follow(user_id);
            tweetHead = null;
        }

        public void follow(int user_id){
            following.add(user_id);
        }

        public void unfollow(int user_id){
            following.remove(user_id);
        }

        public void post(int tweetId){  // 5->3->x 5 = tweethead(latest tweet)
            Tweet tweet = new Tweet(tweetId);
            tweet.next = tweetHead;
            tweetHead = tweet;
        }
    }

    public Twitter() {
        userMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId)){
            User user = new User(userId); 
            userMap.put(userId, user);
        }

        userMap.get(userId).post(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<>();
        if(!userMap.containsKey(userId))
            return res;

        Set<Integer> users = userMap.get(userId).following;
        // creating a max-heap for a time-based newsfeed of user_id
        PriorityQueue<Tweet> pq = new PriorityQueue<>(users.size(), (a,b)-> Integer.compare(b.time, a.time));

        for(int user: users){
            Tweet tweetH = userMap.get(user).tweetHead;
            if(tweetH != null)
                pq.add(tweetH);
        }

        int n = 0;
        while(!pq.isEmpty() && n<10){
            Tweet tweet = pq.poll();

            res.add(tweet.id);
            n++;
            
            if(tweet.next != null)
                pq.add(tweet.next); // add the next tweet of the tweetlist of user's following
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)){
            User user = new User(followerId); 
            userMap.put(followerId, user);
        }
        if(!userMap.containsKey(followeeId)){
            User user = new User(followeeId); 
            userMap.put(followeeId, user);
        }

        userMap.get(followerId).follow(followeeId); // Its a set so no double following
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId) || followerId == followeeId)
            return ;
        userMap.get(followerId).unfollow(followeeId);
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

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna