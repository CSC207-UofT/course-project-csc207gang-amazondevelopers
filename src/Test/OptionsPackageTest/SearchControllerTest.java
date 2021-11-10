package OptionsPackageTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import OptionsPackage.SearchController;

public class SearchControllerTest extends SearchController {
    SearchController searchController;

    @BeforeEach
    void setUp(){
        searchController = new SearchController();
    }

    @Test
    void testNotInSearch() throws IOException, ClassNotFoundException {
        String tag = new String("test1");
        ArrayList<Object> list = new ArrayList<>();
        assertEquals(searchController.searchProducts(tag), list);
    }

    void testThrowsException() throws IOException, ClassNotFoundException{
        ;
    }

    void testInSearch() throws IOException, ClassNotFoundException{
        ;
    }
}
