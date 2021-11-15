package OptionsPackageTest;

import InputAndOutput.SystemInOut;

import OptionsPackage.UserOptionsUseCase;

import UserFunctions.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.Assert.*;

public class UserOptionsUseCaseTest {
    UserOptionsUseCase useCase;
    User user;

    @BeforeEach
    void setUp() throws FileNotFoundException {

        user = new User("test1");
        useCase = new UserOptionsUseCase(user);
    }

    @Test
    public void testThrowsException(){
        assertThrows(IOException.class, () -> useCase.userInput("6"));
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