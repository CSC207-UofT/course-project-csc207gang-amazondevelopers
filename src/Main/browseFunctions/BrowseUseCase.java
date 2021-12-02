package browseFunctions;
import postFunctions.Post;
import productFunctions.Product;
import userFunctions.User;
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
     */
    public List<String> getlistProductID(List<Post> userFeed) {
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
    public List<Post> generateFeed(HashMap<String,User> users, List<String> followers){
        List<Post> feed = new ArrayList<>();
        for (int c = 0; c < followers.size(); c++){
            User user1 = users.get(followers.get(c));
            feed.addAll(user1.getListPosts());
        }
        return feed;
    }
}
