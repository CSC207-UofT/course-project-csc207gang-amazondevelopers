package cart_functions;

import options.OptionsGUI;
import product.Product;
import user.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CartGUI implements ActionListener {
    CartPresenter presenter = new CartPresenter();
    JFrame frame = new JFrame();
    JButton returnHome = new JButton("Return to Options Menu");
    JButton buyButton = new JButton("Buy Cart");

    JLabel emptyCartMessage = new JLabel(presenter.emptyCartMessage());
    User user;

    /**
     * A constructor for cart which user can use to buy items saved in cart
     * @param user The user who you have accessed
     */

    public CartGUI(User user){

        //TODO cannot access getShoppingCart() use user Use case

        if (user.getShoppingCart().size()==0){

            emptyCartMessage.setBounds(150, 100, 250, 35);
            emptyCartMessage.setFont(new Font("Serif", Font.PLAIN, 14));

            returnHome.setBounds(60, 150, 300, 25);
            returnHome.addActionListener(this);

            frame.add(returnHome);
            frame.add(emptyCartMessage);
        }
        else{
            Product prod = user.getShoppingCart().get(0);
            JScrollPane jScrollPane = new JScrollPane(this.createProductFrame(prod));

            for(Product i:user.getShoppingCart()){
                if (!(user.getShoppingCart().indexOf(i) == 0)){
                    jScrollPane.add(this.createProductFrame(i));
                }
            }

            jScrollPane.setSize(300, 300);

            jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            jScrollPane.setLayout(null);
            jScrollPane.setVisible(true);

            frame.getContentPane().add(jScrollPane);

            buyButton.setBounds(60, 300, 300, 25);
            buyButton.addActionListener(this);

        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);

        this.user = user;
    }

    /**
     *
     * Constructor for a small frame of a product that displays product name price and size
     *
     * @param product the product we are making a frame for
     * @return JFrame
     */

    private JPanel createProductFrame(Product product){

        JPanel productPanel = new JPanel();
        JLabel name = new JLabel(product.getName());
        JLabel price = new JLabel(product.getPrice().toString());



        name.setBounds(10, 0, 230, 40);
        price.setBounds(120, 50, 110, 40);

        name.setLayout(null);
        name.setLayout(null);
        name.setVisible(true);
        price.setVisible(true);

        productPanel.add(name);
        productPanel.add(price);

        if (product.getSizes() != null){
            JLabel size = new JLabel(product.getSizes().toString());
            size.setBounds(10, 50, 110, 40);
            size.setVisible(true);
            productPanel.add(size);
        }
        else {
            JLabel size = new JLabel("n/a");
            size.setBounds(10, 50, 110, 40);
            size.setVisible(true);
            productPanel.add(size);
        }

        productPanel.setSize(250, 100);
        productPanel.setLayout(null);
        productPanel.setVisible(true);

        return productPanel;
    }

    @Override
    public void actionPerformed(ActionEvent action) {
        if(action.getSource()==returnHome) {
            frame.dispose();
            OptionsGUI optionsGUI = new OptionsGUI(this.user);
        }
        else if (action.getSource() == buyButton){
            frame.dispose();
            Cart cart = new Cart();
            try {
                cart.buyCart(user);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}