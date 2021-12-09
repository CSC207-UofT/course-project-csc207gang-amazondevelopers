package options.browse.commands;

import gui.ButtonCommandInterface;
import gui.GUIFactory;
import gui.GUIFactoryInterface;
import product.Product;
import user.User;
import user.UserUseCase;

import javax.swing.*;

public class AddToCartCommand implements ButtonCommandInterface {
    Product product;
    User user;
    JFrame frame;

    /**
     * Initializer for adding to cart
     *
     * @param product product the user wants to add to their cart
     * @param user user in question
     * @param frame the JFrame frame being operated on
     */

    public AddToCartCommand(Product product, User user, JFrame frame) {
        this.product = product;
        this.user = user;
        this.frame = frame;
    }

    /**
     *Uses UserUseCase to add initialized items in AddToCartCommand to the user's cart
     *
     */

    @Override
    public void apply(){
        UserUseCase userUseCase = new UserUseCase(user);
        userUseCase.userAddToCart(product);
        frame.setVisible(false);
        frame.dispose();

        GUIFactory guiFactory = new GUIFactory(this.user, product.getName());
        GUIFactoryInterface guiFrame = guiFactory.getFrame("ADDEDTOCART");
        guiFrame.createGUI();
    }
}
