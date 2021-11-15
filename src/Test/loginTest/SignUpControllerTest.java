package loginTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import InputAndOutput.SystemInOut;
import login.SignInController;
import login.SignUpController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class SignUpControllerTest extends SignUpController{
    SignInController signin;
    SignUpController signup;
    SystemInOut inOut;

    @BeforeEach
    void setUp() throws IOException, ClassNotFoundException {

        signin = new SignInController();
        signup = new SignUpController();
    }


    @Test
    void testSignUpWorks() throws IOException, ClassNotFoundException {
        ;
        // tests if a user that does not exist will be allowed to sign up and then sign in
    }

    @Test
    void testThrowsException1(){
        ;
        // exception should be thrown because empty username cannot exist
    }
    @Test
    void testThrowsException2(){
        ;
        // exception should be thrown because username already exists
    }
}
