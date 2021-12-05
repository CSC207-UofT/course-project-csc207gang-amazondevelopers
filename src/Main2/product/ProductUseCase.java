package product;


import java.io.IOException;
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
    public void saveNewProductToSer(Product newProduct) throws IOException, ClassNotFoundException {
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


    /**
     * Takes in a product and an int representing the quantity of the product to decrease it by.
     * Decreases quantity of that product by quantity.
     *
     * @param product product whose quantity is decreased.
     * @param quantity  Int amount to remove from existing quantity of the product.
     * @return true successfully decreased amount and false otherwise.
     */
    public boolean decreaseQuantity(Product product, int quantity) {
        if (quantity >= 0) {
            int newQuantity = product.getQuantity() - quantity;
            product.setQuantity(newQuantity);
            return true;
        }
        return false;
    }

    /**
     * Takes in a product and an int representing the quantity of the product to increase it by.
     * Increases quantity of that product by quantity.
     *
     * @param product Product whose quantity is increased.
     * @param quantity  Int amount to add from existing quantity of the product.
     * @return true successfully increased amount and false otherwise.
     */
    public boolean increaseQuantity(Product product, int quantity){
        if (quantity >= 0){
            int newQuantity = product.getQuantity() + quantity;
            product.setQuantity(newQuantity);
            return true;
        }

        return false;
    }
}
