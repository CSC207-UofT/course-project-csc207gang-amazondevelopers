package userFunctions;
import productFunctions.GetProductGateway;
import productFunctions.GetProductGatewayInterface;
import productFunctions.Product;
import productFunctions.ProductUseCase;
import loginFunctions.SaveUserGatewayInterface;
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

    /**
     *
     * @param item The product that we want to add to the cart
     * @param user The user whom we want to add the product to their cart
     * @return true or false if the product was or was not added to the user's cart
     */

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
     * @param user the user whom we want to update their cart
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

    /**
     *
     * @param user The user whom we will empty their cart
     * @throws IOException
     * @throws ClassNotFoundException
     */

    public void emptyCart(User user) throws IOException, ClassNotFoundException {
        List<Product> userCart = user.getShoppingCart();
        userCart.clear();
        user.setShoppingCart(userCart);
        saveUserGatewayInterface.saveUser(user.getUsername(), user);
    }
}



