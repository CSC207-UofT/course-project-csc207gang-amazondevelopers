package loginTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import InputAndOutput.SystemInOut;
import UserFunctions.User;
import login.SignInController;
import login.SignUpController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class SignInControllerTest extends SignInController{

    SignInController signin;
    SignUpController signup;
    User user;
    SystemInOut inOut;

    @BeforeEach
    void setUp() throws IOException, ClassNotFoundException {

        signin = new SignInController();
        signup = new SignUpController();
        signup.allowSignUp("test1");
        user = new User("test1");
    }

    @Test
    void testSignInReal() throws IOException, ClassNotFoundException {
        assertEquals(signin.allowSignIn("test1", inOut).getUsername(), "test1");
        // tests if a user that exists will be allowed to sign in
    }

    @Test
    void testSignInFake() throws IOException, ClassNotFoundException{
        assertEquals(signin.allowSignIn("test2", inOut).getUsername(), "");
        // tests if a user that does not exist will be not be allowed to sign in
    }
}
