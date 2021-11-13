package ProductFunctions;
import java.io.IOException;

public class ProductManager {

    CreateProductGatewayInterface createProduct;
    GetProductGatewayInterface getProduct;

    public ProductManager(CreateProductGatewayInterface createProduct){
        this.createProduct = createProduct;

    }

    public ProductManager(GetProductGatewayInterface getProduct){
        this.getProduct = getProduct;
    }

    /**
     * Create a new Product object.
     * This method takes in a String for Product name, a double for the Product price, another String for the
     * product category, a String for size, and an int for the quantitiy.
     * Returns the Product if created and null otherwise.
     *
     * @return a newly created product or null.
     */
    public Product createProduct(String name, String id, Double price, String category, String size, int quantity) throws IOException, ClassNotFoundException {
        if (getProduct.getProduct(id) == null){
            //product not yet created
            Product newProduct = new Product(name, id, price, category, size, quantity);
            createProduct.addProductToRepo(newProduct, newProduct.getId(), newProduct.getCategory());
            return newProduct;
        }
        return null;
    }

    //Overloaded method for if there is no size attributed to this Product

    /**
     * Create a new Product object.
     * This method takes in a String for Product name, a double for the Product price, another String for the
     * product category, and an int for the quantitiy.
     * Returns the Product if created and null otherwise.
     *
     * @return a newly created product or null.
     */
    public Product createProduct(String name, String id, Double price, String category, int quantity) throws IOException, ClassNotFoundException {
        if (getProduct.getProduct(id).equals(null)) {
            //product not yet created
            Product newProduct = new Product(name, id, price, category, quantity);
            createProduct.addProductToRepo(newProduct, newProduct.getId(), newProduct.getCategory());
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
        Product productOfId = (Product) getProduct.getProduct(productId);
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
        Product productOfId = (Product) getProduct.getProduct(productId);
        if (productOfId != null){
            int newQuantity = productOfId.getQuantity() + quantity;
            productOfId.setQuantity(newQuantity);
            return true;
        }
        //means that product does not exists
        return false;
    }
}
