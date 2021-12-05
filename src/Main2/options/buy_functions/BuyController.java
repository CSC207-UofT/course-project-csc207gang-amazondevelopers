package options.buy_functions;


import options.follow_users.UserUseCase;
import product.GetProductGateway;
import productFunctions.Product;
import userFunctions.User;

import java.io.IOException;
import java.util.List;


public class BuyController {

    /**
     *
     * @param user the user who wants to buy something
     * @param listIds the list of IDs of products
     * @param index the index of the item of interest from listIds
     * @throws IOException
     * @throws ClassNotFoundException
     */

    public void allowBuy(User user, List<String> listIds, int index) throws IOException, ClassNotFoundException {

        String productId = listIds.get(index);
        // get the product at the index
        GetProductGateway getProductGateway = new GetProductGateway();
        Product product = getProductGateway.getProduct(productId);

        UserUseCase userUseCase = new UserUseCase(user);
        userUseCase.userAddToCart(product);

    }
}



