package loginTest;

import InputAndOutput.SystemInOut;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import InputAndOutput.SystemInOut;
import OptionsPackage.UserOptionsController;
import UserFunctions.User;
import login.SignInController;
import login.WelcomePageController;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.*;
import java.util.Scanner;

import static org.junit.Assert.*;

public class WelcomePageControllerTest {

    SignInController signInController;
    User user;
    UserOptionsController userOption;
    SystemInOutTest inOut;
    WelcomePageController welcomePageController;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        {
            try {
                inOut = new SystemInOutTest("src/Test/loginTest/welcomePageInputs");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        user = new User("test1");
        signInController = new SignInController();
        userOption = new UserOptionsController(user);
        welcomePageController = new WelcomePageController();
    }

    @Test
    public void testWelcomePage() throws IOException {
        welcomePageController.userLoginDecision();
        assertThrows(IOException.class,() -> inOut.getInput());
        assertThrows(IOException.class,() -> inOut.getInput());
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
