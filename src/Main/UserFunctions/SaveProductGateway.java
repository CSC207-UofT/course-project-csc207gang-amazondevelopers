package UserFunctions;
import ProductFunctions.Product;
import ProductFunctions.ProductReadWriter;
import java.io.IOException;
import java.util.HashMap;


public class SaveProductGateway implements SaveProductGatewayInterface{

    /**
     * Save the product to the .ser file
     * @param productID ID of the product
     * @param product the product object
     * @throws IOException error occured during reading a file, when there is an input / output error
     * @throws ClassNotFoundException when you try to load a class at run time using Class
     */
    public void save(String productID, Product product) throws IOException, ClassNotFoundException {
        // save the changed, new Product.
        ProductReadWriter rw = new ProductReadWriter();
        HashMap<String, Object> productSavedDict = rw.readFromFile("src/Main/IdToProduct.ser");
        productSavedDict.put(productID, product);
        rw.saveToFile("src/Main/IdToProduct.ser", productSavedDict);
    }
}
