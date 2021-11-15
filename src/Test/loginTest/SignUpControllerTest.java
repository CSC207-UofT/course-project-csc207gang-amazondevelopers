package loginTest;

import InputAndOutput.SystemInOut;
import ProductFunctions.CreateProductController;
import ProductFunctionsTest.CreateProductControllerTest;
import Settings.DeleteUserGateway;
import UserFunctions.User;
import login.SignInController;
import login.SignUpController;
import login.SignUpGateway;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.Assert.*;

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

    @Test
    public void getNewUsernameValidUsername() throws Exception {
        SystemInOutTest testInOut = new SystemInOutTest("src/Test/loginTest/ SignUpControllerValidUsernameTestInputs");
        //skip the header of the file
        testInOut.getInput();

        String newUsername = signup.getNewUsername(testInOut);
        assertEquals(newUsername, "TestSignUpController");
        // tests if a user that does not exist will be allowed to sign up
    }

    @Test
    public void getNewUsernameInvalidUsername() throws Exception {
        SystemInOutTest testInOut = new SystemInOutTest("src/Test/loginTest/SignUpControllerInvalidUsernameTestInputs");
        //skip the header of the file
        testInOut.getInput();

        String newUsername = signup.getNewUsername(testInOut);
        assertEquals(newUsername, "TestSignUpController");
        // tests if a user that does not exist will be allowed to sign up
    }

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


    private static class SystemInOutTest extends SystemInOut {

        private final Scanner reader;

        /**
         *
         * @param fileName
         * @throws FileNotFoundException
         */
        public SystemInOutTest(String fileName) throws FileNotFoundException {
            File fileToRead = new File(fileName);
            this.reader = new Scanner(fileToRead);
        }

        @Override
        public String getInput() throws IOException {
            if (reader.hasNextLine()) {
                return this.reader.nextLine();
            }
            else{
                return "";
            }
        }
    }

}