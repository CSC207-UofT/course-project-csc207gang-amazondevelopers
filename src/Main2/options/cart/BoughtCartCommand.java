package options.cart;

import gui.ButtonCommandInterface;
import gui.GUIFactory;
import gui.GUIFactoryInterface;
import user.User;

import javax.swing.*;
import java.io.IOException;

public class BoughtCartCommand implements ButtonCommandInterface {
    JFrame frame;
    User user;

    public BoughtCartCommand(JFrame frame, User user) {
        this.frame = frame;
        this.user = user;
    }

    @Override
    public void apply() throws IOException, ClassNotFoundException {
        frame.dispose();
        GUIFactory guiFactory = new GUIFactory(this.user);
        GUIFactoryInterface guiFrame = guiFactory.getFrame("BOUGHTCART");
        guiFrame.createGUI();
        CartController cart = new CartController();
        try {
            cart.buyCart(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
