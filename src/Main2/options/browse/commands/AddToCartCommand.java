package options.browse.commands;

import gui.ButtonCommandInterface;
import gui.GUIFactory;
import gui.GUIFactoryInterface;
import product.Product;
import user.User;
import user.UserUseCase;

import javax.swing.*;
import java.io.IOException;

public class AddToCartCommand implements ButtonCommandInterface {
    Product product;
    User user;
    JFrame frame;
    public AddToCartCommand(Product product, User user, JFrame frame) {
        this.product = product;
        this.user = user;
        this.frame = frame;
    }

    @Override
    public void apply() throws IOException, ClassNotFoundException {
        UserUseCase userUseCase = new UserUseCase(user);
        userUseCase.userAddToCart(product);
        frame.setVisible(false);
        frame.dispose();

        GUIFactory guiFactory = new GUIFactory(this.user, product.getName());
        GUIFactoryInterface guiFrame = guiFactory.getFrame("ADDEDTOCART");
        guiFrame.createGUI();
    }
}
