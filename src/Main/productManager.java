
public class productManager{


    /**
     * Create a new Product object.
     * This method takes in a String for Product name, a float for the Product price, another String for the
     * product category, and also a String for size.
     * Returns true if Product is created and false otherwise.
     *
     * @return
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

    public void increaseQuantity(Product product, int quantity) {
        int newQuantity = product.getQuantity() + quantity;
        product.setQuantity(newQuantity);
    }

    public boolean decreaseQuantity(Product product, int quantity) {
        int newQuantity = product.getQuantity() - quantity;
        if (newQuantity >= 0) {
            product.setQuantity(newQuantity);
            return true;
        }
        return false;
    }



    private boolean checkProductStatus(String id) {
        return masterManager.getterProduct(id).equals(false);
    }
}
