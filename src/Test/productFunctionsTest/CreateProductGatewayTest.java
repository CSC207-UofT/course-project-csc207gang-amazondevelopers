package productFunctionsTest;

import productFunctions.CreateProductGateway;
import productFunctions.GetProductGateway;
import productFunctions.Product;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;


public class CreateProductGatewayTest {
     CreateProductGateway createProductGateway = new CreateProductGateway();
     // ProductManager productManager = new ProductManager(createProductGateway);
     GetProductGateway getProductGateway = new GetProductGateway();


     @Test
     public void addProductToRepoNewProductBasicTest() throws IOException, ClassNotFoundException {

         Product expectedProduct = new Product("shoe", "1", 5.0, "shoes", "2",1);
         createProductGateway.addProductToRepo(expectedProduct, "!", "shoes");
         Product actualProduct = getProductGateway.getProduct("1");

         assertEquals("shoe", actualProduct.getName());
         assertEquals("1", actualProduct.getId());
         assertEquals(5, actualProduct.getPrice(), 0.0);
         assertEquals("shoes", actualProduct.getCategory());
         assertEquals(1, actualProduct.getQuantity());
         assertEquals("2", actualProduct.getSizes());

     }

     void addProductToRepoDuplicateProductsTest() throws IOException, ClassNotFoundException {
         Product product1 = new Product("shoe", "1", 5.0, "shoes", "2",1);
         Product product2 = new Product("shoe", "1", 5.0, "shoes", "2",1);
         createProductGateway.addProductToRepo(product1, "1", "shoes");
         createProductGateway.addProductToRepo(product2, "1", "shoes");



         Product actualProduct = getProductGateway.getProduct("1");

         assertSame("shoe", actualProduct.getName());
         assertSame("1", actualProduct.getId());
         assertEquals(5, actualProduct.getPrice(), 0.0);
         assertSame("shoes", actualProduct.getCategory());
         assertEquals(1, actualProduct.getQuantity());
         assertSame("2", actualProduct.getSizes());
     }

     void addProductToRepoProductNewTag(){
     }

     void addProductToRepoProductPreExistingTag(){
     }

     void addProductToRepoProductIdsDontMatch(){

     }


}
