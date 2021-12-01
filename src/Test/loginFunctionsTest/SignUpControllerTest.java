package loginFunctionsTest;

import inputOutputFunctions.SystemInOut;
import productFunctions.CreateProductController;
import settingsFunctions.DeleteUserGateway;
import userFunctions.User;
import loginFunctions.SignInController;
import loginFunctions.SignUpController;
import loginFunctions.SignUpGateway;
import org.junit.After;
import org.junit.Before;

import java.io.*;
import java.util.Scanner;

public class SignUpControllerTest {
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

//    @Test
//    public void getNewUsernameValidUsername() throws Exception {
//        SystemInOutTest testInOut = new SystemInOutTest("src/Test/loginTest/ SignUpControllerValidUsernameTestInputs");
//        //skip the header of the file
//        testInOut.getInput();
//
//        String newUsername = signup.getNewUsername(testInOut);
//        assertEquals(newUsername, "TestSignUpController");
//        // tests if a user that does not exist will be allowed to sign up
//    }
//
//    @Test
//    public void getNewUsernameInvalidUsername() throws Exception {
//        SystemInOutTest testInOut = new SystemInOutTest("src/Test/loginTest/SignUpControllerInvalidUsernameTestInputs");
//        //skip the header of the file
//        testInOut.getInput();
//
//        String newUsername = signup.getNewUsername();
//        assertEquals(newUsername, "TestSignUpController");
//        // tests if a user that does not exist will be allowed to sign up
//    }

//    @Test
//    public void getNewUsernameUsernameTakenTest() throws Exception {
//        SystemInOutTest testInOut = new SystemInOutTest("src/Test/ProductFunctionsTest/CreateProductTestInputs");
//        //skip the header of the file
//        testInOut.getInput();
//
//        String newUsername = signup.getNewUsername(testInOut);
//        assertEquals(newUsername, "getUsernameUsernameTakenTest");
//        // tests if a user that does not exist will be allowed to sign up
//    }

}