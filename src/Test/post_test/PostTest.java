package post_test;

import options.post.Post;
import org.junit.Test;
import user.User;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PostTest {

    User user1 = new User("test1");
    Post post = new Post("test1", "test", true, true, user1);


    @Test
    public void testPostComment() {
        post.addComment("test1");
        assertEquals(post.getComments().get(0), "test1");
    }

    @Test
    public void testPostComments() {
        post.addComment("test1");
        post.addComment("test2");
        post.addComment("test3");
        post.addComment("test4");

        List<String> comments = new ArrayList<>();
        comments.add("test1");
        comments.add("test2");
        comments.add("test3");
        comments.add("test4");

        assertEquals(post.getComments(), comments);
    }

    @Test
    public void testPostRating() {
        post.addRating(1f);
        assertEquals(post.getRatings().indexOf(1f), 0);
        //for some reason post.getRatings().get(0) gives an error, that's why I'm using index of 1f instead
        // just checking if 1f is the first item in the list of ratings
    }

    @Test
    public void testPostRatings() {
        post.addRating(1f);
        post.addRating(2f);
        post.addRating(3f);
        post.addRating(4f);
        List<Float> ratings = new ArrayList<>();
        ratings.add(1f);
        ratings.add(2f);
        ratings.add(3f);
        ratings.add(4f);
        assertEquals(post.getRatings(), ratings);
    }

    @Test
    public void testPostLikes() {
        post.addlike(1);
        assertEquals(post.getLikes(), 1);
    }

    @Test
    public void testPostCaption() {
        assertEquals(post.getCaption(), "test");
    }

    @Test
    public void testPostProduct(){
        assertEquals(post.getProduct(), "test1");
    }

    @Test public void testGetSetProduct(){
        post.setProduct("shoes");
        assertEquals(post.getProduct(), "shoes");
    }
}
