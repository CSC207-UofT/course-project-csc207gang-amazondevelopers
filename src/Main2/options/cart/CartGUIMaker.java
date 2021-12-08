package options.cart;

import gui.GUIFactoryInterface;
import options.OptionsGUIMaker;
import product.Product;
import user.User;
import user.UserUseCase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CartGUIMaker implements ActionListener, GUIFactoryInterface {
    CartPresenter presenter = new CartPresenter();
    JFrame frame = new JFrame();
    JButton returnHome = new JButton("Back");
    JButton buyButton = new JButton("Buy Cart");
    JButton buy = new JButton("Buy");
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

    public CartGUIMaker(User user){
        this.user = user;
        UserUseCase userUseCase = new UserUseCase(user);
//        if (userUseCase.userShoppingCart()==null || userUseCase.userShoppingCart().size()==0){
        // System.out.println(userUseCase.userShoppingCart());
         if (userUseCase.userShoppingCart().size()==0){
             EmptyCartGUIMaker emptyCartGUIMaker = new EmptyCartGUIMaker(this.user);
//
//            emptyCartMessage.setBounds(150, 100, 250, 35);
//            emptyCartMessage.setFont(new Font("Serif", Font.PLAIN, 14));
//
//            returnHome.setBounds(60, 150, 300, 25);
//            returnHome.addActionListener(this);
//
//            frame.add(returnHome);
//            frame.add(emptyCartMessage);
//
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.setSize(420, 420);
//            frame.setLayout(null);
//            frame.setVisible(true);
        }
        else{
            Product prod = userUseCase.userShoppingCart().get(0);
            JScrollPane jScrollPane = new JScrollPane(this.createProductFrame(prod));

            for(Product i : userUseCase.userShoppingCart()){
                if (!(user.getShoppingCart().indexOf(i) == 0)){
                    jScrollPane.add(this.createProductFrame(i));
                }
            }

            DefaultListModel<String> list = new DefaultListModel<String>();
            for (Product item : userUseCase.userShoppingCart()) {
                list.addElement(item.getName());
            }
            JList listOfProductDisplay = new JList(list);
            JScrollPane listScroller = new JScrollPane(listOfProductDisplay);

            // back button
            returnHome.setBounds(100, 300, 50, 35);
            returnHome.addActionListener(this);
            listScroller.setBounds(100, 100, 100, 100);
            scrollPanel.add(listScroller);

            buyButton.setBounds(160, 300, 50, 35);
            buyButton.addActionListener(this);

            indexPanel.add(buyButton);
            indexPanel.add(returnHome);

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
            OptionsGUIMaker optionsGUIMaker = new OptionsGUIMaker(user);
        }
        else if (action.getSource()==buyButton){
            frame.dispose();
            BoughtCart boughtCart = new BoughtCart(user);
            CartController cart = new CartController();
            try {
                cart.buyCart(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void createGUI() {

    }
}
