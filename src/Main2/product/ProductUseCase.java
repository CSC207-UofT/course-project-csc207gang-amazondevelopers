package product;

import java.util.ArrayList;

public class ProductUseCase {

    SaveProductGatewayInterface saveProduct;

    public ProductUseCase(SaveProductGatewayInterface saveProduct) {
        this.saveProduct = saveProduct;
    }

    /**
     * Method that takes in a Product and saves it to the product.ser file and the idtoProduct.ser file.
     *
     */
    public void saveNewProductToSer(Product newProduct){
        saveProduct.addProductToRepo(newProduct, newProduct.getId(), newProduct.getCategory());
    }

    /**
     * Takes in an arraylist containing all information needed to create a product and the id of the product and
     * return the created product.
     * @param information a list of all information needed to create a product
     * @param id a String id of the product to be created
     * @return a newly created product
     */

    public Product createProduct(ArrayList<String> information, String id) {
        String priceString = information.get(1);
        String quantityString = information.get(3);
        return new Product(information.get(0), id, Double.valueOf(priceString), information.get(2), Integer.parseInt(quantityString));
    }
}
