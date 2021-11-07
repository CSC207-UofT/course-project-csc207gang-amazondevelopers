public class productManager{

    /**
     * Create a new Product object.
     * This method takes in a String for Product name, a float for the Product price, another String for the
     * product category, and also a String for size.
     * Returns true if Product is created and false otherwise.
     *
     * @return a newly created product.
     */

    public Product createProduct(String name, String id, float price, String category, String size, int quantity) {
        Product newProduct = new Product(name, id, price, category, size, quantity);
        if (checkProductStatus(id)){
            //product not yet created
            masterManager.setterProduct(id, newProduct);
            return newProduct;
        }
        return null;
    }

    //Overloaded method for if there is no size attributed to this Product
    public Product createProduct(String name, String id, float price, String category, int quantity) {
        Product newProduct2 = new Product(name, id, price, category, quantity);
        if (checkProductStatus(id)) {
            //product not yet created
            masterManager.setterProduct(id, newProduct2);
            return newProduct2;
        }
        return null;
    }


    /**
     * Takes in a product and an int representing the quantity of the product to increase it by.
     * Increases quantity of that product by quantity.
     *
     * @param product Product whose quantity is increased.
     * @param quantity Int amount to add to existing quantity of the product.
     */
    public void increaseQuantity(Product product, int quantity) {
        int newQuantity = product.getQuantity() + quantity;
        product.setQuantity(newQuantity);
    }

    /**
     * Takes in a product and an int representing the quantity of the product to decrease it by.
     * Decreases quantity of that product by quantity.
     *
     * @param product Product whose quantity is decreased.
     * @param quantity Int amount to remove from existing quantity of the product.
     * @return true successfully decreased amount and false otherwise.
     */
    public boolean decreaseQuantity(Product product, int quantity) {
        int newQuantity = product.getQuantity() - quantity;
        if (newQuantity >= 0) {
            product.setQuantity(newQuantity);
            return true;
        }
        return false;
    }


    /**
     * Method that takes in a String representing an id.
     * Returns true if product associated with the id exists and false otherwise.
     *
     *
     * @param id Id of product whose status is checked.
     * @return true if product exists and false otherwise.
     */
    private boolean checkProductStatus(String id) {
        return masterManager.getterProduct(id).equals(false);
    }
}
