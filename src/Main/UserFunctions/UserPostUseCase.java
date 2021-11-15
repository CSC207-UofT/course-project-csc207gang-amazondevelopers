package UserFunctions;
import PostFunctions.Post;
import java.util.List;

/**
 * Class used to add specific posts to a users post list, or feed
 */
public class UserPostUseCase {
    private User user;

    public UserPostUseCase(User user) {
        this.user = user;
    }


    /**
     * Method that takes in a Post and adds the Post to User's list of posts.
     *
     * @param postToAdd Post to add to user's list of posts.
     */
    public void addToPostList(Post postToAdd){
        List<Post> currentListPosts = this.user.getListPosts();
        currentListPosts.add(postToAdd);
        user.setListPosts(currentListPosts);
    }


    /**
     * Method that takes in a Post and adds the Post to User's feed;
     * @param post Post to add to user's feed.
     */
    public void addToFeed(Post post){
        List<Post> currentFeed = this.user.getFeed();
        currentFeed.add(post);
        user.setFeed(currentFeed);
    }

}
