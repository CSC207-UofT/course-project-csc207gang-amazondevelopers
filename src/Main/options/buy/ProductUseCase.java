package options.buy;


import product.Product;

public class ProductUseCase {

    /**
     * buy the product, and reduce its quantity
     * @param product the product to be bought
     * @return if the product can be bought
     */

    public boolean productBuy(Product product){
        int quantity = product.getQuantity();
        if (quantity > 0){
            product.setQuantity(quantity - 1);
            return true;
        }
        return false;
    }
}
