package options.buy;


import user.UserUseCase;
import product.GetProductGateway;
import product.Product;
import user.User;

import java.io.IOException;
import java.util.List;


public class BuyController {

    /**
     * @param user    the user who wants to buy something
     * @param listIds the list of IDs of products
     * @param index   the index of the item of interest from listIds
     * @throws IOException
     * @throws ClassNotFoundException
     */

    public boolean allowBuy(User user, List<String> listIds, int index) throws IOException, ClassNotFoundException {

        if (0 <= index && index < listIds.size()) {

            String productId = listIds.get(index);
            // get the product at the index
            GetProductGateway getProductGateway = new GetProductGateway();
            Product product = getProductGateway.getProduct(productId);
            // check product quantity, and add to options.cart
            UserUseCase userUseCase = new UserUseCase(user);
            userUseCase.userAddToCart(product);
            return true;
        }
        return false;
    }
}



