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
 * A use case class that adds items to the user's options.cart
 */
public class CartManager {
    public void buyCart(User user) throws Exception {
        List<String> cartIDs = new ArrayList<>();
        UserUseCase userUseCase = new UserUseCase(user);
        for (Product i: userUseCase.userShoppingCart()) {
            cartIDs.add(i.getId());
            BuyController buyController = new BuyController();
            buyController.allowBuy(user, cartIDs, cartIDs.indexOf(i.getId()));
        }
        try{
            user.setShoppingCart(Collections.emptyList());
        }catch (Exception ignored){
            ;
        }

        //buyController.allowBuy(inOut, user, cartIDs);
    }

    public void addToCart(User user, Product product){
        List<Product> productList = new ArrayList<>();
        productList.add(product);

        user.setShoppingCart(Stream.concat(user.getShoppingCart().stream(),
                productList.stream()).collect(Collectors.toList()));
    }
}

