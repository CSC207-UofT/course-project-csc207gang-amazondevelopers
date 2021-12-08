package postTest;

import login.SaveUserGateway;
import options.post.CreatePostController;
import options.post.Post;
import org.junit.Before;
import org.junit.Test;
import user.User;
import options.post.PostManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
public class CreatePostControllerTest {
    User user1 = new User("test1");
    CreatePostController createPostController = new CreatePostController(user1);

    @Test
    public void testCreatePost() throws IOException, ClassNotFoundException {

        ArrayList<String> info = new ArrayList<>();
        info.add("test");
        info.add("1.0");
        info.add("testCategory");
        info.add("1");
        info.add("testCaption");
        info.add("medium");
        info.add("true");
        info.add("true");

        createPostController.createPost(info);

        assertEquals(user1.getListPosts().get(0).getCaption(), new Post("test", "testCaption",
                true, true, user1).getCaption());
    }
}