package product_test;

import org.junit.Test;
import product.Product;

import static org.junit.Assert.*;

public class ProductTest {

    @Test
    public void createProductWithSizeTest() {
        Product actualProduct = new Product("shoes", "1", 5.0, "shoes", "2",1);

        assertEquals("shoes", actualProduct.getName());
        assertEquals("1", actualProduct.getId());
        assertEquals(5, actualProduct.getPrice(), 0.0);
        assertEquals("shoes", actualProduct.getCategory());
        assertEquals("2", actualProduct.getSizes());
        assertEquals(1, actualProduct.getQuantity());
    }

    @Test
    public void createProductWithoutSizeTest() {
        Product actualProduct = new Product("shoe", "1", 5.0, "shoes",1);
        assertEquals("shoe", actualProduct.getName());
        assertEquals("1", actualProduct.getId());
        assertEquals(5, actualProduct.getPrice(), 0.0);
        assertEquals("shoes", actualProduct.getCategory());
        assertEquals(1, actualProduct.getQuantity());
        assertNull(actualProduct.getSizes());
    }





    @Test
    public void toStringWithSizeTest() {
        Product actualProduct = new Product("shoe", "1", 5.0, "shoes", "2",1);
        String productString = actualProduct.toString();
        assertEquals("shoe (1): $5.0, 1 in stock, size: 2", productString);
    }

    @Test
    public void toStringWithoutSizeTest() {
        Product actualProduct = new Product("shoe", "1", 5.0, "shoes",1);
        String productString = actualProduct.toString();
        assertEquals("shoe (1): $5.0, 1 in stock", productString);
    }

    @Test
    public void getNameBasicTest() {
        Product actualProduct = new Product("shoe", "1", 5.0, "shoes", 1);
        assertEquals("shoe", actualProduct.getName());
    }

    @Test
    public void setNameBasicTest() {
        Product actualProduct = new Product("shoe", "1", 5.0, "shoes", "2",1);

        actualProduct.setName("pants");

        assertEquals("pants", actualProduct.getName());
        assertEquals("1", actualProduct.getId());
        assertEquals(5, actualProduct.getPrice(), 0.0);
        assertEquals("shoes", actualProduct.getCategory());
        assertEquals(1, actualProduct.getQuantity());
        assertEquals("2", actualProduct.getSizes());
    }

    @Test
    public void setNameEmptyStringTest() {
        Product actualProduct = new Product("shoe", "1", 5.0, "shoes", "2",1);
        actualProduct.setName("");

        assertNotEquals("", actualProduct.getName());
    }

    @Test
    public void getIDBasicTest() {
        Product actualProduct = new Product("shoe", "1", 5.0, "shoes", "2",1);

        assertEquals("1", actualProduct.getId());
    }

    @Test
    public void setIDBasicTest() {
        Product actualProduct = new Product("shoe", "1", 5.0, "shoes", "2",1);

        actualProduct.setId("5");
        assertEquals("5", actualProduct.getId());
    }

    @Test
    public void setIDNegativeIdTest() {
        Product actualProduct = new Product("shoe", "1", 5.0, "shoes", "2",1);
        actualProduct.setId("-500");
        assertEquals("-500", actualProduct.getId());
    }


    @Test
    public void getPriceBasicTest() {
        Product product = new Product("shoe", "1", 5.0, "shoes", "2",1);
        assertEquals(5.0, product.getPrice(), 0.0);
    }

    @Test
    public void setPriceBasicTest() {
        Product product = new Product("shoe", "1", 5.0, "shoes", "2",1);
        product.setPrice(25.0);
        assertEquals(25.0, product.getPrice(), 0.0);
    }

    @Test
    public void setPriceNegativeTest() {
        Product product = new Product("shoe", "1", 5.0, "shoes", "2",1);
        product.setPrice(-25.0);
        assertTrue(product.getPrice() >= 0);
    }

    @Test
    public void setPriceHigherTest() {
        Product product = new Product("shoe", "1", 5.0, "shoes", "2",1);
        product.setPrice(50.0);
        assertEquals(50.0, product.getPrice(), 0.0);
    }

    @Test
    public void setPriceLowerTest() {
        Product product = new Product("shoe", "1", 500.0, "shoes", "2",1);
        product.setPrice(2.0);
        assertEquals(2.0, product.getPrice(), 0.0);
    }

    @Test
    public void setPriceZeroTest() {
        Product product = new Product("shoe", "1", 500.0, "shoes", "2",1);
        product.setPrice(0.0);
        assertEquals(0.0, product.getPrice(), 0.0);
    }

    @Test
    public void setPriceDecimalTest() {
        Product product = new Product("shoe", "1", 500.0, "shoes", "2",1);
        product.setPrice(5.23);
        assertEquals(5.23, product.getPrice(), 0.0);
    }

    @Test
    public void setPriceLongDecimalTest() {
        Product product = new Product("shoe", "1", 500.0, "shoes", "2",1);
        product.setPrice(5.231326828189);
        assertEquals(5.23, product.getPrice(), 0.0);
    }

    @Test
    public void getCategoryBasicTest() {
        Product product = new Product("shoe", "1", 500.0, "shoes", "2",1);
        assertEquals("shoes", product.getCategory());
    }

    @Test
    public void setCategoryBasicTest() {
        Product product = new Product("shoe", "1", 500.0, "shoes", "2",1);
        product.setCategory("shirt");
        assertEquals("shirt", product.getCategory());

    }

    @Test
    public void getSizesWithSizeTest() {
        Product product = new Product("shoe", "1", 500.0, "shoes", "2",1);
        assertEquals("2", product.getSizes());
    }

    @Test
    public void getSizesNoSizeTest() {
        Product product = new Product("shoe", "1", 500.0, "shoes",1);
        assertNull(product.getSizes());
    }

    @Test
    public void setSizesBasicTest() {
        Product product = new Product("shoe", "1", 500.0, "shoes", "2",1);
        product.setSizes("10");
        assertEquals("10", product.getSizes());
    }

    @Test
    public void setSizesEmptyStringTest() {
        Product product = new Product("shoe", "1", 500.0, "shoes", "2",1);
        product.setSizes("");
        assertNull(product.getSizes());
    }

    @Test
    public void setSizesNoSizeStartTest() {
        Product product = new Product("shoe", "1", 500.0, "shoes",1);
        product.setSizes("5");
        assertEquals("5", product.getSizes());
    }

    @Test
    public void getQuantityBasicTest() {
        Product product = new Product("shoe", "1", 500.0, "shoes", "2",1);
        assertEquals(1, product.getQuantity());
    }

    @Test
    public void setQuantityBasicTest() {
        Product product = new Product("shoe", "1", 500.0, "shoes", "2",1);
        product.setQuantity(50);
        assertEquals(50, product.getQuantity());
    }

    @Test
    public void setQuantityNegativeTest() {
        Product product = new Product("shoe", "1", 500.0, "shoes", "2",1);
        product.setQuantity(-50);
        assertEquals(0, product.getQuantity());
    }

    @Test
    public void setQuantityZeroTest() {
        Product product = new Product("shoe", "1", 500.0, "shoes", "2",1);
        product.setQuantity(0);
        assertEquals(0, product.getQuantity());
    }

    @Test
    public void setQuantityHigherTest() {
        Product product = new Product("shoe", "1", 500.0, "shoes", "2",1);
        product.setQuantity(9000);
        assertEquals(9000, product.getQuantity());
    }

    @Test
    public void setQuantityLowerTest() {
        Product product = new Product("shoe", "1", 500.0, "shoes", "2",500);
        product.setQuantity(4);
        assertEquals(4, product.getQuantity());
    }

    @Test
    public void setQuantitySameTest(){
        Product product = new Product("shoe", "1", 500.0, "shoes", "2",500);
        product.setQuantity(500);
        assertEquals(500, product.getQuantity());
    }
}
