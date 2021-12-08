package sign_in_test;

import delete_gateways.DeleteUserGateway;
import login.SetIDandPasswordsGateway;
import login.sign_in.SignInController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.io.IOException;

public class SignInControllerTest {

    SignInController signInController = new SignInController();
    SetIDandPasswordsGateway setIDandPasswords = new SetIDandPasswordsGateway();

    DeleteUserGateway deleteUserGateway = new DeleteUserGateway();

    @Before
    public void setUp() throws IOException, ClassNotFoundException {
        setIDandPasswords.setUsernamePasswordHash("SignInTest", "password");
    }

    @After
    public void takeDown(){
        deleteUserGateway.deleteUser("SignInTest");
    }

    @Test
    public void checkPassMatchTest() {
        setIDandPasswords.setUsernamePasswordHash("SignInTest", "password");
        assertTrue(signInController.checkPassMatch("SignInTest", "password"));
    }

    @Test
    public void checkPassMatchNoUserTest() {
        assertFalse(signInController.checkPassMatch("kshkajkd", "password"));
    }

    @Test
    public void checkPassMatchWrongPassTest() {
        assertFalse(signInController.checkPassMatch("SignInTest", "sdjkhjaksd"));
    }

}
