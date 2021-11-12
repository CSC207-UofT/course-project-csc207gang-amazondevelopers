package ProductFunctionsTest;

import InputAndOutput.InOut;
import OptionsPackage.TagInterestItemsPresenter;
import ProductFunctions.CreateProductGateway;
import ProductFunctions.GetProductGateway;
import ProductFunctions.Product;
import ProductFunctions.ProductManager;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.Assert.*;


public class CreateProductGatewayTest {
//     CreateProductGateway createProductGateway = new CreateProductGateway();
//     // ProductManager productManager = new ProductManager(createProductGateway);
//     GetProductGateway getProductGateway = new GetProductGateway();
//     TagInterestItemsPresenter tagPresenter = new TagInterestItemsPresenter();


//     @Test
//     void addProductToRepoNewProductBasicTest() throws IOException, ClassNotFoundException {

//         Product expectedProduct = new Product("shoe", "1", 5.0, "shoes", "2",1);
//         createProductGateway.addProductToRepo(expectedProduct, "!", "shoes");
//         Product actualProduct = getProductGateway.getProduct("1");

//         assertSame("shoe", actualProduct.getName());
//         assertSame("1", actualProduct.getId());
//         assertEquals(5, (double) actualProduct.getPrice(), 0.0);
//         assertSame("shoes", actualProduct.getCategory());
//         assertEquals(1, actualProduct.getQuantity());
//         assertSame("2", actualProduct.getSizes());

//     }

//     void addProductToRepoDuplicateProductsTest() throws IOException, ClassNotFoundException {
//         Product product1 = new Product("shoe", "1", 5.0, "shoes", "2",1);
//         Product product2 = new Product("shoe", "1", 5.0, "shoes", "2",1);
//         createProductGateway.addProductToRepo(product1, "1", "shoes");
//         createProductGateway.addProductToRepo(product2, "1", "shoes");



//         tagPresenter.presentTagList();

//         Product actualProduct = getProductGateway.getProduct("1");

//         assertSame("shoe", actualProduct.getName());
//         assertSame("1", actualProduct.getId());
//         assertEquals(5, (double) actualProduct.getPrice(), 0.0);
//         assertSame("shoes", actualProduct.getCategory());
//         assertEquals(1, actualProduct.getQuantity());
//         assertSame("2", actualProduct.getSizes());
//     }

//     void addProductToRepoProductNewTag(){
//     }

//     void addProductToRepoProductPreExistingTag(){
//     }

//     void addProductToRepoProductIdsDontMatch(){

//     }


}
