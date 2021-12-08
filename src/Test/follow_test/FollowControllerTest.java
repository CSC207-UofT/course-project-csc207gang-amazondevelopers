package follow_test;
import login.SaveUserGateway;
import options.follow_users.FollowController;
import org.junit.Before;
import org.junit.Test;
import user.User;

import java.io.IOException;

import static org.junit.Assert.*;

public class FollowControllerTest {

    User follower = new User("follower");
    User toFollow = new User("toFollow");

    FollowController followController = new FollowController(follower);
    SaveUserGateway saveUserGateway = new SaveUserGateway();


    @Before
    public void setUp() throws IOException, ClassNotFoundException {
        saveUserGateway.saveUser("follower", follower);
        saveUserGateway.saveUser("toFollow", toFollow);
    }

    @Before
    public void takeDown(){

    }

    @Test
    public void canFollowTest() throws IOException, ClassNotFoundException {
        assertTrue(followController.canFollow("toFollow"));
    }

    @Test
    public void canFollowEmptyStringTest() throws IOException, ClassNotFoundException {
        assertFalse(followController.canFollow(""));

    }

    @Test
    public void canFollowAlreadyFollowedTest() throws IOException, ClassNotFoundException {
        assertTrue(followController.canFollow("toFollow"));
        assertFalse(followController.canFollow("toFollow"));
    }

    @Test
    public void canFollowDoesNotExistTest() throws IOException, ClassNotFoundException {
        assertFalse(followController.canFollow("dsjhjkhjksdhjdajhsdjahdakj"));
    }





}
