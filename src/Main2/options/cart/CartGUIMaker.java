package options.cart;

import gui.ButtonCommandInterface;
import gui.GUIFactory;
import gui.GUIFactoryInterface;
import options.commands.OptionsCommand;
import product.Product;
import user.User;
import user.UserUseCase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class CartGUIMaker implements ActionListener, GUIFactoryInterface {
    User user;
    static Map<String, ButtonCommandInterface> commandMap = new HashMap<>();

    /**
     * A constructor for cart which user can use to buy items saved in cart
     * @param user The user who you have accessed
     */

    public CartGUIMaker(User user){
        this.user = user;
    }

    /**
     * interprets the action performed
     * @param action action performed
     */

    @Override
    public void actionPerformed(ActionEvent action) {
        String buttonText = action.getActionCommand();
        ButtonCommandInterface button = commandMap.get(buttonText);
        button.apply();
    }

    /**
     * creates cart gui
     *
     */

    @Override
    public void createGUI(){

        JFrame frame = new JFrame();
        JButton returnHome = new JButton("Back");
        JButton buyButton = new JButton("Buy Cart");
        JPanel scrollPanel = new JPanel();
        JPanel indexPanel = new JPanel();
        JPanel titlePanel = new JPanel();
        JPanel backPanel = new JPanel();
        JLabel messageLabel = new JLabel();

        UserUseCase userUseCase = new UserUseCase(user);
        if (userUseCase.userShoppingCart().size()==0){
            GUIFactory guiFactory = new GUIFactory(this.user);
            GUIFactoryInterface guiFrame = guiFactory.getFrame("EMPTYCART");
            guiFrame.createGUI();
        }
        else{
            Product prod = userUseCase.userShoppingCart().get(0);
            JScrollPane jScrollPane = new JScrollPane(this.createProductFrame(prod));

            for(Product i : userUseCase.userShoppingCart()){
                if (!(user.getShoppingCart().indexOf(i) == 0)){
                    jScrollPane.add(this.createProductFrame(i));
                }
            }

            DefaultListModel<String> list = new DefaultListModel<>();
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

            commandMap.put(returnHome.getText(), new OptionsCommand(frame, this.user));
            commandMap.put(buyButton.getText(), new BoughtCartCommand(frame, this.user));

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
}
