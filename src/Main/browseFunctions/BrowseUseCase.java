package browseFunctions;
import postFunctions.Post;
import userFunctions.User;
import java.util.ArrayList;
import java.util.List;

/**
 * User is the signed in user
 */
public class BrowseUseCase {

    User user;

    public BrowseUseCase(User user) {
        this.user = user;
    }

    /**
     * @return the feed (list of posts that the users that this user follow have posted) of the user.
     */
    public List<Post> getFeed() {
        return this.user.getFeed();
    }

    /**
     * Takes in a list of Posts and returns an arraylist of strings representing the ids of the product associated
     * with the list of posts.
     */
    public List<String> getlistIds(List<Post> userFeed) {
        ArrayList<String> stringProductList = new ArrayList<>();
        for (Post aPost: userFeed){
            String stringPost = aPost.getProductDescription();
            stringProductList.add(stringPost);
        }
        return stringProductList;
    }
}
