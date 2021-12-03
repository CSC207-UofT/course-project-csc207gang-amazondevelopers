package cart_functions;

import login_functions.WelcomePageGUI;
import options.OptionsGUI;
import productFunctions.Product;
import userFunctions.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CartGUI implements ActionListener {
    CartPresenter presenter = new CartPresenter();
    JFrame frame = new JFrame();
    JButton returnHome = new JButton("Return to Options Menu");
    JPanel panel = new JPanel();
    JLabel emptyCartMessage = new JLabel(presenter.emptyCartMessage());
    User user;

    /**
     * A constructor for cart which user can use to buy items saved in cart
     * @param user The user who you have accessed
     */

    public CartGUI(User user){

        if (user.getShoppingCart().size()==0){

            emptyCartMessage.setBounds(70, 100, 250, 35);
            emptyCartMessage.setFont(new Font("Serif", Font.PLAIN, 14));

            returnHome.setBounds(145, 150, 100, 25);
            returnHome.addActionListener(this);

            frame.add(returnHome);
            frame.add(emptyCartMessage);
        }
        else{
            for(Product i:user.getShoppingCart()){
                panel.add(createProductFrame(i));
            }
            frame.add(panel);
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);

        this.user = user;
    }

    private JFrame createProductFrame(Product product){
        JFrame productFrame = new JFrame();
        JLabel name = new JLabel(product.getName());
        JLabel size = new JLabel(product.getSizes().toString());
        JLabel price = new JLabel(product.getPrice().toString());

        name.setBounds(10, 0, 230, 40);
        size.setBounds(10, 50, 110, 40);
        price.setBounds(120, 50, 110, 40);

        frame.add(name);
        frame.add(size);
        frame.add(price);

        frame.setSize(250, 100);
        frame.setLayout(null);
        frame.setVisible(true);





        return productFrame;
    }

    @Override
    public void actionPerformed(ActionEvent action) {
        if(action.getSource()==returnHome) {
            frame.dispose();
            OptionsGUI optionsGUI = new OptionsGUI(this.user);
        }
    }
}