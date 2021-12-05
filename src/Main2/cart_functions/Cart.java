package cart_functions;

import inputOutputFunctions.SystemInOut;
import options.buy_functions.BuyController;
import productFunctions.Product;
import user.User;
import userFunctions.User;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;

public class Cart {

    public void buyCart(User user) throws Exception {
        BuyController buyController = new BuyController();
        SystemInOut inOut = new SystemInOut();
        List<String> cartIDs = new ArrayList<>();

        for (Product i:user.getShoppingCart()) {
            cartIDs.add(i.getId());
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
