package cart_functions;

import login_functions.WelcomePageGUI;
import options.OptionsGUI;
import productFunctions.Product;
import userFunctions.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CartGUI implements ActionListener {
    JFrame frame = new JFrame();
    JButton returnHome = new JButton("Return to Options Menu");
    JPanel panel = new JPanel();
    JFrame productFrame = new JFrame();
    User user;

    /**
     * A constructor for cart which user can use to buy items saved in cart
     * @param user The user who you have accessed
     */

    public CartGUI(User user){

        if (user.getShoppingCart().size()==0){
            returnHome.setBounds(50, 150, 75, 25);
            returnHome.addActionListener(this);
            frame.add(returnHome);
        }
        else{
            frame.add(panel);
            for(Product i:user.getShoppingCart()){
                panel.add(productFrame);
            }
        }



        this.user = user;
    }

    @Override
    public void actionPerformed(ActionEvent action) {
        if(action.getSource()==returnHome) {
            frame.dispose();
            OptionsGUI optionsGUI = new OptionsGUI(this.user);
        }
    }
}