package ProductFunctionsTest;

import InputAndOutput.InOut;
import InputAndOutput.SystemInOut;
import ProductFunctions.CreateProductController;
import UserFunctions.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CreateProductTest {

    private class TestSystemInOut implements InOut {

        BufferedReader reader;

        public TestSystemInOut() {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        // get user input
        public String getInput() throws IOException {
            return reader.readLine();
        }

        // send user a message they can respond to
        @Override
        public void sendOutput(Object s) {
            System.out.println(s);
        }
    }



    InOut testInOut = new TestSystemInOut();
    User testUser = new User("testUser");

    void createProductTest() throws Exception {
        // Product newProduct, String productId
        CreateProductController createProduct = new CreateProductController();
        createProduct.createNewProductFromInput(testInOut, testUser);
    }


    void addProductToRepoDuplicateProductsTest(){

    }




}
