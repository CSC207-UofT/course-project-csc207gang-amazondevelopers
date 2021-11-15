package OptionsPackageTest;
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
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import OptionsPackage.SearchController;
import OptionsPackage.ListOfProductsPresenter;

public class ListOfProductsPresenterTest {
    User user = new User("test1");
    ListOfProductsPresenter LOPP;

    @BeforeEach
    void setUp(){
        LOPP = new ListOfProductsPresenter();
    }

    @Test
    public void testForEmpty() throws IOException, ClassNotFoundException {
        List<String> list = Collections.emptyList();
        LOPP.presentTagList(list);
    }

    @Test
    public void testWithProduct() throws IOException, ClassNotFoundException {
        List<String> list = new ArrayList<String>("test1");
        LOPP.presentTagList(list);
    }

}
//