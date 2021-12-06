package cart_functions;

import options.buy_functions.BuyController;
import product.Product;
import user.User;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;

import options.follow_users.UserUseCase;

public class CartManager {

    /**
     * Buys the users cart
     * @param user The user who you have accessed
     */
    public void buyCart(User user) throws Exception {
        List<String> cartIDs = new ArrayList<>();
        UserUseCase userUseCase = new UserUseCase(user);

        for (Product i:userUseCase.userShoppingCart()) {
            cartIDs.add(i.getId());
        }
        for (Product i:userUseCase.userShoppingCart()){
            this.buyItem(user, i);
        }
    }

    /**
     * Adds product to user's cart
     * @param user The user who you have accessed
     * @param product the product to add to the cart
     */
    public void addToCart(User user, Product product){
        List<Product> productList = new ArrayList<>();
        productList.add(product);

        user.setShoppingCart(Stream.concat(user.getShoppingCart().stream(),
                productList.stream()).collect(Collectors.toList()));
    }

    /**
     * updates product quantity
     * @param product The user who you have accessed
     */
    public void updateProductQuantity(Product product){
        product.setQuantity(product.getQuantity() - 1);
    }

    /**
     * Buys an item of the user's choosing
     * @param user The user who you have accessed
     * @param product the product to add to the cart
     */

    public void buyItem(User user, Product product) throws IOException, ClassNotFoundException {
        BuyController buyController = new BuyController();
        List<String> cartIDs = new ArrayList<>();
        UserUseCase userUseCase = new UserUseCase(user);

        for (Product i:userUseCase.userShoppingCart()) {
            cartIDs.add(i.getId());
        }
        buyController.allowBuy(user, cartIDs, cartIDs.indexOf(product.getId()));
        this.updateProductQuantity(product);
    }

}
