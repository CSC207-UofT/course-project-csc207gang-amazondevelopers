package post_test;

import login.SaveUserGateway;
import options.post.Post;
import options.post.PostManager;
import org.junit.Test;
import user.User;

import static org.junit.Assert.*;

public class PostManagerTest{

    User user1 = new User("test1");
    Post post = new Post("test1", "test", true, true, user1);
    Post post1 = new Post("test1", "test", false, false, user1);
    SaveUserGateway saveUserGateway = new SaveUserGateway();
    PostManager postManager = new PostManager(saveUserGateway);

    @Test
    public void testCreatePost(){

        assertEquals(postManager.createPostWithRateComment("1", "test", true,
                true, user1).getCaption(), new Post("test1", "test", true, true, user1).getCaption());
    }

    @Test
    public void testRate(){
        assertTrue(postManager.rate(post, 2f));
        assertEquals(post.getRatings().indexOf(2f), 0);
        //for some reason post.getRatings().get(0) gives an error, that's why I'm using index of 1f instead
        // just checking if 1f is the first item in the list of ratings
        assertFalse(postManager.rate(post1, 2f));

        postManager.changeRateSettings(post, false);
        postManager.changeRateSettings(post1, true);

        assertTrue(postManager.rate(post1, 2f));
        assertFalse(postManager.rate(post, 2f));
        assertEquals(post1.getRatings().indexOf(2f), 0);

    }

    @Test
    public void testLikes(){
        postManager.like(post);
        assertEquals(post.getLikes(), 1);
    }

    @Test
    public void testComment(){
        assertTrue(postManager.comment(post, "test"));
        assertEquals(post.getComments().get(0), "test");
        assertFalse(postManager.comment(post1, "test"));

        postManager.changeCommentSettings(post, false);
        postManager.changeCommentSettings(post1, true);

        assertFalse(postManager.comment(post, "test"));
        assertTrue(postManager.comment(post1, "test"));
        assertEquals(post1.getComments().get(0), "test");
    }

    @Test
    public void testPostToString(){
        post.setProduct("shoes");
        postManager.comment(post, "test");
        postManager.rate(post, 2f);

        String actual = "Post made by: test1\nProduct its about: shoes\nCaption: test\nComments: \n" +
                "test\nRatings are: 2.0\n";
        assertEquals(postManager.postToString(post), actual);
    }

}

