package loginTest;

import InputAndOutput.SystemInOut;
import InputAndOutput.SystemInOutTest;
import OptionsPackage.UserOptionsController;
import ProductFunctions.CreateProductController;
import ProductFunctionsTest.CreateProductControllerTest;
import Settings.DeleteUserGateway;
import UserFunctions.User;
import login.SignInController;
import login.SignUpGateway;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.Assert.*;

public class SignInControllerTest {
    SignInController signInController = new SignInController();
    User user;
    UserOptionsController userOption;
    SignUpGateway signUpGateway = new SignUpGateway();
    // create a new user profile to make products for
    User testUser = new User("TestCreateProductUser");
    DeleteUserGateway deleteUserGateway = new DeleteUserGateway();
    CreateProductController createProduct = new CreateProductController();

//    @Before
//    public void setUp() throws IOException, ClassNotFoundException {
//        // if there is a preexisting user TestCreateProductUser, delete it
////        deleteUserGateway.deleteUser("TestSignInControllerUser");
////        // create the new user profile before each test
////        SystemInOut standardInOut = new SystemInOut();
////        signUpGateway.allowSignUp(standardInOut,"TestSignInControllerUser", testUser);
//    }
//
//    @After
//    public void takeDown() throws IOException, ClassNotFoundException {
//        // delete the test user profile before each test, to delete all the products that were created during the test
////        deleteUserGateway.deleteUser("TestSignInControllerUser");
//    }

    //TODO: finish making mock user inputs
    @Test
    public void getUsernameValidUsernameTest() throws IOException {
        SystemInOutTest testInOut = new SystemInOutTest("src/Test/loginTest/SignInControllerValidUsernameTestInputs");

        // Skip the header in the file
        testInOut.getInput();
        String username = signInController.getUsername();
        assertEquals(username, "TestSignInControllerUser");
    }


    @Test
    public void getUsernameInvalidUsernameTest() throws IOException {
        SystemInOutTest testInOut = new SystemInOutTest("src/Test/loginTest/SignInControllerInvalidUsernameTestInputs");

        // Skip the header in the file
        testInOut.getInput();

        String username = signInController.getUsername();
        assertEquals(username, "TestSignInControllerUser");
    }


//    private static class SystemInOutTest extends SystemInOut {
//
//        private final Scanner reader;
//        /**
//         *
//         * @param fileName
//         * @throws FileNotFoundException
//         */
//        public SystemInOutTest(String fileName) throws FileNotFoundException {
//            File fileToRead = new File(fileName);
//            this.reader = new Scanner(fileToRead);
//        }
//
//        @Override
//        public String getInput() throws IOException {
//            if (reader.hasNextLine()) {
//                return this.reader.nextLine();
//            }
//            else{
//                return "";
//            }
//        }
//    }
}
