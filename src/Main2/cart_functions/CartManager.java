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

    public void addToCart(User user, Product product){
        List<Product> productList = new ArrayList<>();
        productList.add(product);

        user.setShoppingCart(Stream.concat(user.getShoppingCart().stream(),
                productList.stream()).collect(Collectors.toList()));
    }

    public void updateProductQuantity(Product product){
        product.setQuantity(product.getQuantity() - 1);
    }

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
