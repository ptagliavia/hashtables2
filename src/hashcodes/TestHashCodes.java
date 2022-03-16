package hashcodes;

public class TestHashCodes
{
    public static void main(String[] args)
    {
        TwitterTweet[] tweets = {
            new TwitterTweet("Hello world?"),
            new TwitterTweet("How are you?"),
            new TwitterTweet("Hi everyone!"),
            new TwitterTweet("Hello!"),
            new TwitterTweet("!olleH")
        };

        for (TwitterTweet tweet : tweets)
        {
            System.out.println(tweet.getMessage() + " - hashcode: " + tweet.hashCode());
        }
    }
}
