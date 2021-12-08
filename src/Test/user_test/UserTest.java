package user_test;

import org.junit.Test;
import user.User;

import static org.junit.Assert.*;


public class UserTest {

    @Test
    public void createUserTest(){
        User user = new User("Yasmin");
        assertEquals("Yasmin", user.getUsername());
    }

}
