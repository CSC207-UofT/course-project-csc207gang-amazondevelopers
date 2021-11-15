package loginTest;

import InputAndOutput.SystemInOut;
import OptionsPackage.UserOptionsController;
import UserFunctions.User;
import login.SignInController;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.*;
import java.util.Scanner;

import static org.junit.Assert.*;

public class SignInControllerTest {
    SignInController signInController;
    User user;
    UserOptionsController userOption;
    SystemInOutTest inOut;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        {
            try {
                inOut = new SignInControllerTest.SystemInOutTest("src/Test/loginTest/SignUpController" +
                        "TestInputs");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        user = new User("test1");
        signInController = new SignInController();
        userOption = new UserOptionsController(user);
    }

    @Test
    public void testValidUsername() throws IOException {
        String newUsername = signInController.getUsername();
        inOut.getInput();
        assertEquals(newUsername, "test1");
    }
    
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
