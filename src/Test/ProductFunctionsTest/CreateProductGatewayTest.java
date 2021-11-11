package ProductFunctionsTest;

import InputAndOutput.InOut;
import ProductFunctions.CreateProductGateway;
import ProductFunctions.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CreateProductGatewayTest {
    CreateProductGateway createProductGateway = new CreateProductGateway();
    Product product = new Product("prod", 1, 20, "shoes", 5);
    // String name, String id, Double price, String category, int quantity

    void addProductToRepoTest() throws IOException, ClassNotFoundException {
        // Product newProduct, String productId
        createProductGateway.addProductToRepo(product, "1");
    }


    void addProductToRepoDuplicateProductsTest(){

    }


}
