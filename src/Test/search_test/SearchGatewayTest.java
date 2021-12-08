package search_test;

import delete_gateways.DeleteProductsGateway;
import options.search.SearchGateway;
import org.junit.Test;
import product.GetProductGateway;
import product.Product;
import product.SaveProductGateway;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class SearchGatewayTest {
    SearchGateway searchGateway = new SearchGateway();
    SaveProductGateway saveProductGateway = new SaveProductGateway();
    GetProductGateway getProductGateway = new GetProductGateway();
    DeleteProductsGateway deleteProductsGateway = new DeleteProductsGateway();

    @Test
    public void searchProductsBasicTest() throws IOException, ClassNotFoundException {
        Product newProduct = new Product("shoe", "123", 5.0, "shoes", "2",1);
        saveProductGateway.addProductToRepo(newProduct, "123", "shoes");
        ArrayList<String> actualItemsUnderCategory = searchGateway.searchProducts("shoes");

        ArrayList<String> expectedArrayList = new ArrayList<>();
        Product prod = getProductGateway.getProduct("123");
        expectedArrayList.add(prod.getId());

        assertEquals(expectedArrayList.get(0), actualItemsUnderCategory.get(actualItemsUnderCategory.size() - 1));
    }
}
