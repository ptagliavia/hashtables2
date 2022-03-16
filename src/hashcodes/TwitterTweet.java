package hashcodes;

public class TwitterTweet
{
    private String message;

    public TwitterTweet(String message)
    {
        this.message = message;
    }

    public String getMessage()
    {
        return message;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TwitterTweet email = (TwitterTweet) o;

        if (message != null ? !message.equals(email.message) : email.message != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        char[] characters = message.toCharArray();
        int sum = 0;

        for (int i = 0; i < characters.length; i++)
        {
            sum += characters[i] * i;
        }

        return sum;
    }
}
