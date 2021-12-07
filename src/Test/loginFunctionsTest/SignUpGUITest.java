package loginFunctionsTest;

import inputOutputFunctions.SystemInOutTest;
import productFunctions.CreateProductController;
import serializationFunctions.DictionaryReadWriter;
import delete_gateways.DeleteUserGateway;
import userFunctions.User;
import loginFunctions.SignInController;
import loginFunctions.SignUpController;
import loginFunctions.SignUpGateway;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.*;
import java.util.HashMap;

public class SignUpGUITest {
    SignInController signin = new SignInController();
    SignUpController signup = new SignUpController();
    SignUpGateway signUpGateway = new SignUpGateway();

    User testUser = new User("TestSignUpControllerUser");
    DeleteUserGateway deleteUserGateway = new DeleteUserGateway();
    CreateProductController createProduct = new CreateProductController();

    @Before
    public void setUp() throws IOException, ClassNotFoundException {
        // if there is a preexisting user TestCreateProductUser, delete it
        deleteUserGateway.deleteUser("TestSignUpControllerUser");
        // create the new user profile before each test
        // signUpGateway.allowSignUp("TestSignUpControllerUser", testUser);
    }

    @After
    public void takeDown() throws IOException, ClassNotFoundException {
        // delete the test user profile before each test, to delete all the products that were created during the test
        deleteUserGateway.deleteUser("TestSignUpControllerUser");
    }

    @Test
    public void getNewUsernameValidUsername() throws Exception {
        SystemInOutTest testInOut = new SystemInOutTest("src/Test/loginTest/ SignUpControllerValidUsernameTestInputs");
        //skip the header of the file
        testInOut.getInput();

        signup.getNewUsername(testInOut);

        DictionaryReadWriter rw = new DictionaryReadWriter();
        HashMap<String, Object> userMap = rw.readFromFile("src/Main/user.ser");
        assertTrue(userMap.containsKey("TestSignUpController"));
    }

    @Test
    public void getNewUsernameInvalidUsername() throws Exception {
        SystemInOutTest testInOut = new SystemInOutTest("src/Test/loginTest/SignUpControllerInvalidUsernameTestInputs");
        //skip the header of the file
        testInOut.getInput();

        signup.getNewUsername(testInOut);

        DictionaryReadWriter rw = new DictionaryReadWriter();
        HashMap<String, Object> userMap = rw.readFromFile("src/Main/user.ser");
        assertFalse(userMap.containsKey("*"));
        assertFalse(userMap.containsKey(""));
        // tests if a user that does not exist will be allowed to sign up
    }

    @Test
    public void getNewUsernameUsernameTakenTest() throws Exception {
        SystemInOutTest testInOut = new SystemInOutTest("src/Test/ProductFunctionsTest/CreateProductTestInputs");
        //skip the header of the file
        testInOut.getInput();

        signup.getNewUsername(testInOut);

        DictionaryReadWriter rw = new DictionaryReadWriter();
        HashMap<String, Object> userMap = rw.readFromFile("src/Main/user.ser");
        assertTrue(userMap.containsKey("TestSignUpController"));
        // tests if a user that does not exist will be allowed to sign up
    }

}