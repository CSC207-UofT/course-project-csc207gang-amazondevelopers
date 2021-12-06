package options.cart;

import options.buy.BuyController;
import product.Product;
import user.User;
import user.UserUseCase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A use case class that adds items to the user's options.cart, or allows them to buy
 */
public class CartManager {
    /**
     * Buys all of the items in the users cart.
     * @param user user that is buying
     * @throws Exception ignored
     */
    public void buyCart(User user) throws Exception {
        UserUseCase userUseCase = new UserUseCase(user);
        BuyController buyController = new BuyController();
        for (Product i: userUseCase.userShoppingCart()) {
            buyController.buy(i.getId());
        }
        try{
            user.setShoppingCart(Collections.emptyList());
        }catch (Exception ignored){
            ;
        }


    }

    /**
     * adds a specific product to the users cart.
     * @param user
     * @param product
     */
    public void addToCart(User user, Product product){
        List<Product> productList = new ArrayList<>();
        productList.add(product);

        user.setShoppingCart(Stream.concat(user.getShoppingCart().stream(),
                productList.stream()).collect(Collectors.toList()));
    }
}

