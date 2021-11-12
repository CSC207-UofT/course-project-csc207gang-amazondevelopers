package UserFunctions;

import PostFunctions.Post;

import java.util.ArrayList;
import java.util.List;

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
     * Returns the user's feed.
     *
     * @return The user's feed
     */
    public List<Post> getFeedTotal(){
        return this.user.getFeed();
    }



}
