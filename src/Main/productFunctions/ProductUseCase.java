package productFunctions;
import java.io.IOException;

public class ProductUseCase {

    CreateProductGatewayInterface createProduct;
    GetProductGatewayInterface getProduct;


    public ProductUseCase(CreateProductGatewayInterface createProduct) {
        this.createProduct = createProduct;
    }

    public ProductUseCase(GetProductGatewayInterface getProduct) {
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


    public Product saveNewProduct(String name, String id, Double price, String category, String size, int quantity)
            throws IOException, ClassNotFoundException {
        Product newProduct = new Product(name, id, price, category, size, quantity);
        createProduct.addProductToRepo(newProduct, newProduct.getId(), newProduct.getCategory());
        return newProduct;
    }

    public void saveNewProductToSer(Product newProduct) throws IOException, ClassNotFoundException {
        createProduct.addProductToRepo(newProduct, newProduct.getId(), newProduct.getCategory());

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
    public Product saveNewProduct(String name, String id, Double price, String category, int quantity) throws IOException, ClassNotFoundException {
        Product newProduct = new Product(name, id, price, category, quantity);
        createProduct.addProductToRepo(newProduct, newProduct.getId(), newProduct.getCategory());
        return newProduct;
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
