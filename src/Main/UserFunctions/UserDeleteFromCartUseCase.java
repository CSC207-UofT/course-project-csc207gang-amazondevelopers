package UserFunctions;

import java.util.ArrayList;
import java.util.List;

public class UserDeleteFromCartUseCase {
    // TODO add delete from cart

    /**
     * Empties this user's shopping cart.
     *
     */
    public void emptyShoppingCart(){
        List<Product> currentShoppingCart = this.user.getShoppingCart();
        productManager productManager = new productManager();
        for (Product product : currentShoppingCart){
            productManager.decreaseQuantity(product, 1);
        }
        this.user.setShoppingCart(new ArrayList<>());
    }

}
