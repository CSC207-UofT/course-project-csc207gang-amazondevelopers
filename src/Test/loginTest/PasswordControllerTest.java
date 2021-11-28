package loginTest;

import UserFunctions.User;
import login.PasswordController;
import org.junit.Test;

public class PasswordControllerTest {
    User user = new User("test1");
    PasswordController pass = new PasswordController();
    @Test
    public void test1(){
        pass.setUserPassword(user, "test1");
        assert pass.verifyPassword(user, "test1");
    }
}
