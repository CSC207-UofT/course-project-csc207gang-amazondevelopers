package ProductFunctionsTest;

import InputAndOutput.SystemInOut;
import ProductFunctions.Product;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ProductTest {

//     @Test
//     void createProductWithSizeTest() {
//         Product actualProduct = new Product("shoe", "1", 5.0, "shoes", "2",1);

//         assertTrue(actualProduct.getName() == "shoe");
//         assertTrue(actualProduct.getId() == "1");
//         assertTrue(actualProduct.getPrice() == 5);
//         assertTrue(actualProduct.getCategory() == "shoes");
//         assertTrue(actualProduct.getQuantity() == 1);
//         assertTrue(actualProduct.getSizes() == "2");
//     }

//     @Test
//     void createProductWithoutSizeTest() {
//         Product actualProduct = new Product("shoe", "1", 5.0, "shoes",1);
//         assertTrue(actualProduct.getName() == "shoe");
//         assertTrue(actualProduct.getId() == "1");
//         assertTrue(actualProduct.getPrice() == 5);
//         assertTrue(actualProduct.getCategory() == "shoes");
//         assertTrue(actualProduct.getQuantity() == 1);
//         assertTrue(actualProduct.getSizes() == null);
//     }





//     @Test
//     void toStringWithSizeTest() {
//         Product actualProduct = new Product("shoe", "1", 5.0, "shoes", "2",1);
//         String productString = actualProduct.toString();
//         assertTrue(productString.equals("shoe (1): $5.0, 1 in stock, 2"));
//     }

//     @Test
//     void toStringWithoutSizeTest() {
//         Product actualProduct = new Product("shoe", "1", 5.0, "shoes",1);
//         String productString = actualProduct.toString();
//         assertTrue(productString.equals("shoe (1): $5.0, 1 in stock"));
//     }






//     @Test
//     void getNameBasicTest() {
//         Product actualProduct = new Product("shoe", "1", 5.0, "shoes", 1);
//         assertTrue(actualProduct.getName().equals("shoe"));
//     }

//     @Test
//     void setNameBasicTest() {
//         Product actualProduct = new Product("shoe", "1", 5.0, "shoes", "2",1);

//         assertTrue(actualProduct.getName() == "shoe");
//         assertTrue(actualProduct.getId() == "1");
//         assertTrue(actualProduct.getPrice() == 5);
//         assertTrue(actualProduct.getCategory() == "shoes");
//         assertTrue(actualProduct.getQuantity() == 1);
//         assertTrue(actualProduct.getSizes() == "2");
//     }

//     @Test
//     void setNameEmptyStringTest() {
//         Product actualProduct = new Product("shoe", "1", 5.0, "shoes", "2",1);
//         actualProduct.setName("");

//         assertTrue(actualProduct.getName() != "");
//     }





//     @Test
//     void getIDBasicTest() {
//         Product actualProduct = new Product("shoe", "1", 5.0, "shoes", "2",1);

//         assertTrue(actualProduct.getId() == "1");
//     }

//     @Test
//     void setIDBasicTest() {
//         Product actualProduct = new Product("shoe", "1", 5.0, "shoes", "2",1);

//         actualProduct.setId("5");
//         assertTrue(actualProduct.getId() == "5");
//     }

//     @Test
//     void setIDNegativeIdTest() {
//         Product actualProduct = new Product("shoe", "1", 5.0, "shoes", "2",1);
//         actualProduct.setId("-500");
//         assertTrue(actualProduct.getId() != "-500");
//     }

//     @Test
//     void setIdDuplicateIdsTest() {
//         Product product1 = new Product("shoe", "1", 5.0, "shoes", "2",1);
//         Product product2 = new Product("dress", "50", 5.0, "dress", "2",1);
//         product2.setId("1");
//         assertTrue(!product1.getId().equals(product2.getId()));
//     }





//     @Test
//     void getPriceBasicTest() {
//         Product product = new Product("shoe", "1", 5.0, "shoes", "2",1);
//         assertTrue(product.getPrice() == 5.0);
//     }

//     @Test
//     void setPriceBasicTest() {
//         Product product = new Product("shoe", "1", 5.0, "shoes", "2",1);
//         product.setPrice(25.0);
//         assertTrue(product.getPrice() == 25.0);
//     }

//     @Test
//     void setPriceNegativeTest() {
//         Product product = new Product("shoe", "1", 5.0, "shoes", "2",1);
//         product.setPrice(-25.0);
//         assertTrue(product.getPrice() >= 0);
//     }

//     @Test
//     void setPriceHigherTest() {
//         Product product = new Product("shoe", "1", 5.0, "shoes", "2",1);
//         product.setPrice(50.0);
//         assertTrue(product.getPrice() == 50.0);
//     }

//     @Test
//     void setPriceLowerTest() {
//         Product product = new Product("shoe", "1", 500.0, "shoes", "2",1);
//         product.setPrice(2.0);
//         assertTrue(product.getPrice() == 2.0);
//     }






//     @Test
//     void getCategoryBasicTest() {
//         Product product = new Product("shoe", "1", 500.0, "shoes", "2",1);
//         assertTrue(product.getCategory() == "shoes");

//     }

//     @Test
//     void setCategoryBasicTest() {
//         Product product = new Product("shoe", "1", 500.0, "shoes", "2",1);
//         product.setCategory("shirt");
//         assertTrue(product.getCategory() == "shirt");

//     }




//     @Test
//     void getSizesWithSizeTest() {
//         Product product = new Product("shoe", "1", 500.0, "shoes", "2",1);
//         assertTrue(product.getSizes() == "2");
//     }

//     @Test
//     void getSizesNoSizeTest() {
//         Product product = new Product("shoe", "1", 500.0, "shoes",1);
//         assertTrue(product.getSizes() == null);
//     }

//     @Test
//     void setSizesBasicTest() {
//         Product product = new Product("shoe", "1", 500.0, "shoes", "2",1);
//         product.setSizes("10");
//         assertTrue(product.getSizes() == "10");
//     }

//     @Test
//     void setSizesEmptyStringTest() {
//         Product product = new Product("shoe", "1", 500.0, "shoes", "2",1);
//         product.setSizes("");
//         assertTrue(product.getSizes() == null);
//     }

//     @Test
//     void setSizesNoSizeStartTest() {
//         Product product = new Product("shoe", "1", 500.0, "shoes",1);
//         product.setSizes("5");
//         assertTrue(product.getSizes() == "5");
//     }






//     @Test
//     void getQuantityBasicTest() {
//         Product product = new Product("shoe", "1", 500.0, "shoes", "2",1);
//         assertTrue(product.getQuantity() == 1);
//     }

//     @Test
//     void setQuantityBasicTest() {
//         Product product = new Product("shoe", "1", 500.0, "shoes", "2",1);
//         product.setQuantity(50);
//         assertTrue(product.getQuantity() == 50);
//     }

//     @Test
//     void setQuantityNegativeTest() {
//         Product product = new Product("shoe", "1", 500.0, "shoes", "2",1);
//         product.setQuantity(-50);
//         assertTrue(product.getQuantity() == 0);
//     }

//     @Test
//     void setQuantityZeroTest() {
//         Product product = new Product("shoe", "1", 500.0, "shoes", "2",1);
//         product.setQuantity(0);
//         assertTrue(product.getQuantity() == 0);
//     }

//     @Test
//     void setQuantityHigherTest() {
//         Product product = new Product("shoe", "1", 500.0, "shoes", "2",1);
//         product.setQuantity(9000);
//         assertTrue(product.getQuantity() == 9000);
//     }

//     @Test
//     void setQuantityLowerTest() {
//         Product product = new Product("shoe", "1", 500.0, "shoes", "2",500);
//         product.setQuantity(4);
//         assertTrue(product.getQuantity() == 4);
//     }

//     @Test
//     void setQuantitySameTest(){
//         Product product = new Product("shoe", "1", 500.0, "shoes", "2",500);
//         product.setQuantity(500);
//         assertTrue(product.getQuantity() == 500);
//     }
}
