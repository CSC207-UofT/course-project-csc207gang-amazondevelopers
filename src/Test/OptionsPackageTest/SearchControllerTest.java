package OptionsPackageTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
//
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import UserFunctions.User;
import OptionsPackage.UserOptionsController;

import java.io.IOException;
import java.util.ArrayList;

import OptionsPackage.SearchController;

public class SearchControllerTest{
    SearchController searchController;
    User user;
    UserOptionsController userOption;

    @BeforeEach
    void setUp(){
        user = new User("test1");
        searchController = new SearchController(user);
        userOption = new UserOptionsController(user);
    }

    @Test
    public void testNotInSearch() throws IOException, ClassNotFoundException {
        ;
    }


    void testThrowsException() throws IOException, ClassNotFoundException{
        ;
    }

    void testInSearch() throws IOException, ClassNotFoundException{
        ;
    }
}
