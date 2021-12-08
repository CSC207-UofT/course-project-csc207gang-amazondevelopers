package browse_test;

import options.browse.BrowseUseCase;
import options.post.Post;
import org.junit.Test;
import static org.junit.Assert.*;

import product.Product;
import user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BrowseUseCaseTest {
    User user  = new User("testBrowseUseCase");
    BrowseUseCase browseUseCase = new BrowseUseCase(user);
    // TODO: finish this
    @Test
    public void generateFeedTest() {
        HashMap<String, Object> users = new HashMap<>();
        List<String> followers = new ArrayList<>();
        User user1  = new User("followed1");
        User user2  = new User("followed2");

        Product product = new Product("test", "TEST", 5.0, "test", 1);
        Post post = new Post(product.toString(), "test", true, true, user1);
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(post);
        user1.setListPosts(posts);

        users.put("followed1", user1);
        users.put("followed2", user2);
        followers.add("followed1");
        followers.add("followed2");

        ArrayList<Post> feed = browseUseCase.generateFeed(users, followers);
        assertEquals(1, feed.size());
    }

    @Test
    public void generateFeedEmptyTest() {
        HashMap<String, Object> users = new HashMap<>();
        List<String> followers = new ArrayList<>();
        User user1  = new User("followed1");
        User user2  = new User("followed2");

        users.put("followed1", user1);
        users.put("followed2", user1);
        followers.add("followed1");
        followers.add("followed2");

        ArrayList<Post> feed = browseUseCase.generateFeed(users, followers);
        assertEquals(0, feed.size());
    }

}
