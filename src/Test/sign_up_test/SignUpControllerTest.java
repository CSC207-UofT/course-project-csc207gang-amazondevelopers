package sign_up_test;

import delete_gateways.DeleteUserGateway;
import login.GetUserGateway;
import login.SaveUserGateway;
import login.SetIDandPasswordsGateway;
import login.sign_up.SignUpController;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import user.User;

public class SignUpControllerTest {
    SignUpController signUpController = new SignUpController();

    @Test
    public void checkIdAndPassTest(){
        assertTrue(signUpController.checkIdAndPass("hi", "lol"));
    }

    @Test
    public void containsUsernameTrueTest(){
        SetIDandPasswordsGateway setIDandPasswordsGateway = new SetIDandPasswordsGateway();
        User user = new User("testSignUp");
        SaveUserGateway saveUserGateway = new SaveUserGateway();
        saveUserGateway.saveUser("testSignUp", user);
        setIDandPasswordsGateway.setUsernamePasswordHash("testSignUp", "password");

        assertTrue(signUpController.containsUsername("testSignUp"));

        DeleteUserGateway deleteUserGateway = new DeleteUserGateway();
        deleteUserGateway.deleteUser("testSignUp");
    }

    @Test
    public void setNewUserTest(){
        signUpController.setNewUser("testSignUp", "password");
        GetUserGateway getUserGateway = new GetUserGateway();
        assertEquals("testSignUp", getUserGateway.getUser("testSignUp").getUsername());
        DeleteUserGateway deleteUserGateway = new DeleteUserGateway();
        deleteUserGateway.deleteUser("testSignUp");
    }

}
