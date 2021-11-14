package UserFunctions;

import ProductFunctions.Product;
import ProductFunctions.ProductUseCase;
import login.SaveUserGatewayInterface;

import java.io.IOException;
import java.util.List;

/**
 * A use case class that adds items to the user's cart
 */
public class CartManager {
    SaveProductGatewayInterface saveProductChangesInterface;
    SaveUserGatewayInterface saveUserGatewayInterface;

    public CartManager(SaveProductGatewayInterface saveProductChangesInterface,
                       SaveUserGatewayInterface saveUserGatewayInterface){
        this.saveUserGatewayInterface = saveUserGatewayInterface;
        this.saveProductChangesInterface = saveProductChangesInterface;
    }


    // TODO buying
    public void addToCart(Product item, User user){
        List<Product> userCart = user.getShoppingCart();
        userCart.add(item);
    }

    /**
     * Empty the cart of this user.
     * @param user
     */

    public void emptyCart(User user) throws IOException, ClassNotFoundException {
        List<Product> userCart = user.getShoppingCart();
        for (Product prod: userCart){
            ProductUseCase prodUseCase = new ProductUseCase();
            prodUseCase.decreaseQuantity(prod.getId(), 1);
            saveProductChangesInterface.save(prod.getId(),prod);
        }
        userCart.clear();
        saveUserGatewayInterface.saveUser(user.getUsername(), user);


    }
}



