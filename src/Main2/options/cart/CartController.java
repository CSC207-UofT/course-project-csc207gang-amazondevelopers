package options.cart;

import login.SaveUserGateway;
import options.buy.BuyController;
import product.Product;
import user.User;
import user.UserUseCase;

import java.util.ArrayList;

/**
 * A use case class that adds items to the user's options.cart, or allows them to buy
 */
public class CartController {
    /**
     * Buys all the items in the users cart.
     * @param user user that is buying
     */
    public void buyCart(User user){
        UserUseCase userUseCase = new UserUseCase(user);
        BuyController buyController = new BuyController();
        for (Product i: userUseCase.userShoppingCart()) {
            buyController.buy(i.getId());
        }
        ArrayList<Product> emptyCart = new ArrayList<>();
        user.setShoppingCart(emptyCart);
        SaveUserGateway saveUserGateway = new SaveUserGateway();
        saveUserGateway.saveUser(user.getUsername(), user);
    }
}

