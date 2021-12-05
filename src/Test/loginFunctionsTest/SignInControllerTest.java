package loginFunctionsTest;

import login_functions.SetIDandPasswords;
import login_functions.SignInController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;

public class SignInControllerTest {

    SignInController signInController = new SignInController();
    SetIDandPasswords setIDandPasswords = new SetIDandPasswords();

    @Before
    public void setUp() throws IOException, ClassNotFoundException {
        setIDandPasswords.setUsernamePasswordHash("SignInTest", "password");
    }

    @After
    public void takeDown(){

    }

    @Test
    public void checkPassMatchTest() throws IOException, ClassNotFoundException {
        setIDandPasswords.setUsernamePasswordHash("SignInTest", "password");
        assertTrue(signInController.checkPassMatch("SignInTest", "password"));
    }

    @Test
    public void checkPassMatchNoUserTest() throws IOException, ClassNotFoundException {
        assertFalse(signInController.checkPassMatch("kshkajkd", "password"));
    }

    @Test
    public void checkPassMatchWrongPassTest() throws IOException, ClassNotFoundException {
        assertFalse(signInController.checkPassMatch("SignInTest", "sdjkhjaksd"));
    }

    @Test
    public void getUserTest() throws IOException, ClassNotFoundException {
        // User user = signInController.getUser("SignInTest");
    }

}
