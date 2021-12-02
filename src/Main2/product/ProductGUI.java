package product;

import inputOutputFunctions.SystemInOut;
import userFunctions.User;

public class ProductGUI {

    User user;

    public ProductGUI(User user) {
        this.user = user;
    }

    public void createProduct() throws Exception {
        CreateProductController createProductController = new CreateProductController();
        SystemInOut inout = new SystemInOut();
        createProductController.createNewProductFromInput(inout, this.user);
    }
}
