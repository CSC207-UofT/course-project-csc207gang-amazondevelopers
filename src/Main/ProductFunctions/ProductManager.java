package ProductFunctions;

import InputAndOutput.SystemInOut;

import java.io.IOException;

public class ProductManager {

    /**
     * Create a new Product object.
     * This method takes in a String for Product name, a float for the Product price, another String for the
     * product category, and also a String for size.
     * Returns true if Product is created and false otherwise.
     *
     * @return a newly created product.
     */

    public Product createProduct(String name, String id, Double price, String category, String size, int quantity) throws IOException, ClassNotFoundException {
        Product newProduct = new Product(name, id, price, category, size, quantity);
        if (checkProductStatus(id)){
            //product not yet created
            CreateProductGateway createProductGateway = new CreateProductGateway();
            createProductGateway.addProductToRepo(newProduct, newProduct.getId());
            return newProduct;
        }
        return null;
    }

    //Overloaded method for if there is no size attributed to this Product
    public Product createProduct(String name, String id, Double price, String category, int quantity) throws IOException, ClassNotFoundException {
        Product newProduct = new Product(name, id, price, category, quantity);
        if (checkProductStatus(id)) {
            //product not yet created
            CreateProductGateway createProductGateway = new CreateProductGateway();
            createProductGateway.addProductToRepo(newProduct, newProduct.getId());
            return newProduct;
        }
        return null;
    }

    /**
     * Takes in a product and an int representing the quantity of the product to decrease it by.
     * Decreases quantity of that product by quantity.
     *
     * @param productId id of product whose quantity is decreased.
     * @param quantity Int amount to remove from existing quantity of the product.
     * @return true successfully decreased amount and false otherwise.
     */
    public boolean decreaseQuantity(String productId, int quantity) throws IOException, ClassNotFoundException {
        GetProductGateway getProductGateway = new GetProductGateway();
        Product productOfId = getProductGateway.getProduct(productId);
        if (productOfId != null){
            int newQuantity = productOfId.getQuantity() - quantity;
            if (newQuantity > 0) {
                productOfId.setQuantity(newQuantity);
                return true;
            }
        }
        // means that product does not exists
        return false;
    }

    /**
     * Takes in a product and an int representing the quantity of the product to decrease it by.
     * Decreases quantity of that product by quantity.
     *
     * @param productId id of product whose quantity is decreased.
     * @param quantity Int amount to add from existing quantity of the product.
     * @return true successfully increased amount and false otherwise.
     */
    public boolean increaseQuantity(String productId, int quantity) throws IOException, ClassNotFoundException {
        GetProductGateway getProductGateway = new GetProductGateway();
        Product productOfId = getProductGateway.getProduct(productId);
        if (productOfId != null){
            int newQuantity = productOfId.getQuantity() + quantity;
            productOfId.setQuantity(newQuantity);
            return true;
        }
        //means that product does not exists
        return false;
    }

    /**
     * Method that takes in a String representing an id.
     * Returns true if product associated with the id exists and false otherwise.
     *
     * @param id Id of product whose status is checked.
     * @return true if product exists and false otherwise.
     */
    private boolean checkProductStatus(String id) throws IOException, ClassNotFoundException {
        GetProductGateway getProductGateway = new GetProductGateway();
        Product productOfId = getProductGateway.getProduct(id);
        return productOfId != null;
    }
}
