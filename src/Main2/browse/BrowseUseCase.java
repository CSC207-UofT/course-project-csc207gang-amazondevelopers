package browse;
import post.Post;
import product.Product;
import user.User;
import java.util.ArrayList;
import java.util.HashMap;
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
     * Takes in a list of Posts and returns an arraylist of strings representing the ids of the product associated
     * with the list of posts.
     * @param userFeed The feed of the User given
     */
    public List<String> getlistProductID(ArrayList<Post> userFeed) {
        ArrayList<String> stringProductList = new ArrayList<>();
        for (Post aPost: userFeed){
            Product product = aPost.getProduct();
            String id = product.getId();
            stringProductList.add(id);
        }
        return stringProductList;
    }

    /**
     * Generates a feed given the user data given.
     * @param users A Hashmap generated by GetUserDictGateway
     * @param followers a list of usernames that a specific user follows
     * @return A list of posts
     */
    public ArrayList<Post> generateFeed(HashMap<String,User> users, List<String> followers){
        ArrayList<Post> feed = new ArrayList<>();
        for (String follower : followers) {
            User user1 = users.get(follower);
            feed.addAll(user1.getListPosts());
        }
        return feed;
    }
}