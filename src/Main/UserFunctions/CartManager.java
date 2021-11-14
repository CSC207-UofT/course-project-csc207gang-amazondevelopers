package UserFunctions;

import ProductFunctions.GetProductGateway;
import ProductFunctions.GetProductGatewayInterface;
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

    public CartManager(SaveProductGatewayInterface saveProductChangesInterface){

        this.saveProductChangesInterface = saveProductChangesInterface;
    }

    public CartManager(SaveUserGatewayInterface saveUserGatewayInterface){
        this.saveUserGatewayInterface = saveUserGatewayInterface;
    }

    public CartManager(){};


    // TODO buying
    public void addToCart(Product item, User user){
        List<Product> userCart = user.getShoppingCart();
        userCart.add(item);
    }

    /**
     * Updates the quanitity of the cart when the user buys
     * @param user
     */

    public void updateProductQuantity(User user) throws IOException, ClassNotFoundException {
        List<Product> userCart = user.getShoppingCart();
        for (Product prod: userCart){
            GetProductGatewayInterface getProductGatewayInterface = new GetProductGateway();
            ProductUseCase prodUseCase = new ProductUseCase(getProductGatewayInterface);
            prodUseCase.decreaseQuantity(prod.getId(), 1);
            saveProductChangesInterface.save(prod.getId(),prod);
        }



    }

    public void emptyCart(User user) throws IOException, ClassNotFoundException {
        List<Product> userCart = user.getShoppingCart();
        userCart.clear();
        user.setShoppingCart(userCart);
        saveUserGatewayInterface.saveUser(user.getUsername(), user);
    }
}



