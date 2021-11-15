package loginTest;

import InputAndOutput.SystemInOut;
import login.SignInController;
import login.SignUpController;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.*;
import java.util.Scanner;

import static org.junit.Assert.*;

public class SignUpControllerTest {
    SignInController signin;
    SignUpController signup;
    SystemInOutTest inOut;

    @BeforeEach
    void setUp() throws IOException, ClassNotFoundException {

        {
            try {
                inOut = new SystemInOutTest("src/Test/loginTest/SignUpControllerTestInputs");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        signin = new SignInController();
        signup = new SignUpController();
    }


    @Test
    public void testSignUpWorks() throws Exception {
        String newUsername = signup.getNewUsername();
        inOut.getInput();
        assertEquals(newUsername, "test1");

        // tests if a user that does not exist will be allowed to sign up
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

