package options.cart;

import options.OptionsGUI;
import options.cart.CartPresenter;
import user.UserUseCase;
import product.Product;
import user.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CartGUI implements ActionListener {
    CartPresenter presenter = new CartPresenter();
    JFrame frame = new JFrame();
    JButton returnHome = new JButton("Back");
    JButton buyButton = new JButton("Buy Cart");
    JButton buy = new JButton("Buy");
    JTextField searchBar = new JTextField(10);
    JPanel scrollPanel = new JPanel();
    JPanel indexPanel = new JPanel();
    JPanel titlePanel = new JPanel();
    JPanel backPanel = new JPanel();
    JLabel messageLabel = new JLabel();


    JLabel emptyCartMessage = new JLabel(presenter.emptyCartMessage());
    User user;
    ArrayList<String> cartList;

    /**
     * A constructor for cart which user can use to buy items saved in cart
     * @param user The user who you have accessed
     */

    public CartGUI(User user){

        if (user.getShoppingCart().size()==0){

            emptyCartMessage.setBounds(150, 100, 250, 35);
            emptyCartMessage.setFont(new Font("Serif", Font.PLAIN, 14));

            returnHome.setBounds(60, 150, 300, 25);
            returnHome.addActionListener(this);

            frame.add(returnHome);
            frame.add(emptyCartMessage);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(420, 420);
            frame.setLayout(null);
            frame.setVisible(true);
        }
        else{
            Product prod = user.getShoppingCart().get(0);
            JScrollPane jScrollPane = new JScrollPane(this.createProductFrame(prod));

            for(Product i:user.getShoppingCart()){
                if (!(user.getShoppingCart().indexOf(i) == 0)){
                    jScrollPane.add(this.createProductFrame(i));
                }
            }

            UserUseCase userUseCase = new UserUseCase(this.user);

            DefaultListModel list = new DefaultListModel();
            for (Product item : userUseCase.userShoppingCart()) {
                list.addElement(item.getName());
            }
            JList listOfProductDisplay = new JList(list);
            JScrollPane listScroller = new JScrollPane(listOfProductDisplay);

            // back button
            returnHome.setBounds(100, 400, 50, 35);
            returnHome.addActionListener(this);
            listScroller.setBounds(100, 100, 100, 100);
            scrollPanel.add(listScroller);

            buyButton.setBounds(160, 300, 50, 35);
            buyButton.addActionListener(this);

            indexPanel.add(searchBar);
            indexPanel.add(buy);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(550, 500);
            frame.setLayout(null);
            frame.setVisible(true);
            frame.getContentPane().setLayout(new FlowLayout());
            frame.getContentPane().add(listScroller);
            frame.add(titlePanel);
            frame.add(messageLabel);


            listScroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            listScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

            frame.add(backPanel);
            frame.add(indexPanel);
            frame.add(scrollPanel);


        }

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
            CartManager cart = new CartManager();
            try {
                cart.buyCart(user);
                BoughtCart boughtCart = new BoughtCart(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}