package Settings;

import InputAndOutput.SystemInOut;
import OptionsPackage.UserOptionsController;
import ProductFunctions.Product;
import ProductFunctions.ProductReadWriter;
import UserFunctions.User;
import UserFunctions.UserReadWriter;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class DeleteProductsGateway {

    String product;
    User user;

    public DeleteProductsGateway(String product, User user) {
        this.product = product;
        this.user = user;
    }

    public void deleteProduct(String id, SystemInOut input) throws IOException, ClassNotFoundException {



        File file = new File("src/Main/IdToProduct.ser");
        if (!(file.length() == 0)) {
            // access the serialized file for this user.
            ProductReadWriter rw = new ProductReadWriter();
            HashMap<String, Object> productSavedDict = rw.readFromFile("src/Main/IdToProduct.ser");
            if (productSavedDict.containsKey(id)) {
                productSavedDict.remove(id);
                rw.saveToFile("src/Main/IdToProduct.ser", productSavedDict);



            }
            input.sendOutput("This product does not exist, so it cannot be deleted ");
            SettingsController options = new SettingsController(user);
            options.getSettingOptions(input);

        }
        input.sendOutput("This product does not exist, so it cannot be deleted ");
        SettingsController options = new SettingsController(user);
        options.getSettingOptions(input);


    }

}
