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
    public boolean addToCart(Product item, User user){
        List<Product> userCart = user.getShoppingCart();
        if (item.getQuantity() > 0){
            userCart.add(item);
            return true;
        }
        return false;
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
            prodUseCase.decreaseQuantity(prod, 1);
            // Todo: delete the product with the old information from the file
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



