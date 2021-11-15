package OptionsPackageTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
//
import InputAndOutput.SystemInOut;
import PostFunctions.Post;
import ProductFunctions.Product;
import loginTest.SignInControllerTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import UserFunctions.User;
import OptionsPackage.UserOptionsController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import OptionsPackage.SearchController;

public class SearchControllerTest{
    SearchController searchController;
    User user;
    SystemInOutTest inOut;


    @BeforeEach
    void setUp(){
        user = new User("test1");
        searchController = new SearchController(user);
        {
            try {
                inOut = new SystemInOutTest("src/Test/OptionsPackageTest/UserOptionsTest");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testNotInSearch() throws IOException, ClassNotFoundException {
        searchController.allowSearch();
        inOut.getInput();
    }
    @Test
    public void testInSearch() throws IOException, ClassNotFoundException{
        Product product = new Product("test1", "test1", 1.0, "test1", 1);
        Post post = new Post(product, "test1", false, true);
        searchController.allowSearch();
        inOut.getInput();
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
