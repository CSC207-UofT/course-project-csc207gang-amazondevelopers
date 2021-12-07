package options.buy;


import options.search.SearchGateway;
import product.SaveProductGateway;
import user.UserUseCase;
import product.GetProductGateway;
import product.Product;
import user.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

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

            // check product quantity, and add to cart
            if (product.getQuantity() > 0) {
                UserUseCase userUseCase = new UserUseCase(user);
                userUseCase.userAddToCart(product);
                return true;
            }
        }
        return false;
    }

    /**
     * Changes the quantity of a certain productId after it is purchased
     * @return True if this is possible, false if not
     */
    public boolean buy(String productId) throws IOException, ClassNotFoundException {
        GetProductGateway getProductGateway = new GetProductGateway();
        Product product = getProductGateway.getProduct(productId);
        ProductUseCase productUseCase = new ProductUseCase();
        //changing product quantity
        if(productUseCase.productBuy(product)){
            //saves product with updated quantity
            SaveProductGateway saveProductGateway = new SaveProductGateway();
            saveProductGateway.saveChangedProduct(product);
            return true;
        }
        else{
            return false;
        }
    }
}



