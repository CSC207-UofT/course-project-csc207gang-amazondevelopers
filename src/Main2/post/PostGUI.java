package post;

import options.OptionsGUI;
import userFunctions.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PostGUI implements ActionListener { User user;
EnglishPostPresenter productPresenter = new EnglishPostPresenter();
JFrame frame = new JFrame();
JLabel welcomeMessage = new JLabel(productPresenter.Welcome());
JLabel nameMessage = new JLabel(productPresenter.namePresenter());
JLabel priceMessage = new JLabel(productPresenter.pricePresenter());
JLabel categoryMessage = new JLabel(productPresenter.categoryPresenter());
JLabel sizeMessage = new JLabel(productPresenter.sizePresenter());
JLabel quantityMessage = new JLabel(productPresenter.quantityPresenter());
JLabel descriptionMessage = new JLabel(productPresenter.describePresenter());
String[] sizes = {"Extra small", "Small", "Medium", "Large", "Extra Large", "N/A"};
JComboBox size = new JComboBox(sizes);


JTextField name = new JTextField();
JTextField price = new JTextField();
JTextField category = new JTextField();
JTextField quantity = new JTextField();
JTextField description = new JTextField();

JButton back = new JButton(productPresenter.backPresenter());
JButton post = new JButton(productPresenter.sharePresenter());

    /**
     * The constructor for the gui where sizes and positions of buttons, labels, texts are set
     * @param user the user object which is passed on so that posts created can be attributed to them
     */
    public PostGUI(User user) {
    this.user = user;

    welcomeMessage.setBounds(125, 20, 200, 35);
    welcomeMessage.setFont(new Font(null, Font.PLAIN, 13));

    nameMessage.setBounds(50, 50, 75, 25);
    nameMessage.setFont(new Font(null, Font.PLAIN, 15));
    name.setBounds(125, 50, 200, 25);

    priceMessage.setBounds(50, 100, 75, 25);
    priceMessage.setFont(new Font(null, Font.PLAIN, 15));
    price.setBounds(125, 100, 200, 25);

    categoryMessage.setBounds(50, 150, 75, 25);
    categoryMessage.setFont(new Font(null, Font.PLAIN, 15));
    category.setBounds(125, 150, 200, 25);

    quantityMessage.setBounds(50, 200, 75, 25);
    quantityMessage.setFont(new Font(null, Font.PLAIN, 15));
    quantity.setBounds(125, 200, 200, 25);

    descriptionMessage.setBounds(30, 250, 75, 25);
    descriptionMessage.setFont(new Font(null, Font.PLAIN, 12));
    description.setBounds(125, 250, 200, 25);

    back.setBounds(125, 350, 100, 25);
    back.addActionListener(this);

    post.setBounds(225, 350, 100, 25);
    post.addActionListener(this);

    sizeMessage.setBounds(50, 300, 75, 25);
    sizeMessage.setFont(new Font(null, Font.PLAIN, 15));
    size.setBounds(125, 300, 200, 25);

    frame.add(welcomeMessage);
    frame.add(nameMessage);
    frame.add(name);
    frame.add(priceMessage);
    frame.add(price);
    frame.add(categoryMessage);
    frame.add(category);
    frame.add(quantityMessage);
    frame.add(quantity);
    frame.add(descriptionMessage);
    frame.add(description);
    frame.add(size);
    frame.add(sizeMessage);
    frame.add(back);
    frame.add(post);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 500);
    frame.setLayout(null);
    frame.setVisible(true);
}

    /**
     * Moderates the actions of the user and the subsequent results of the user actions
     * @param action the actions of the user
     */
    public void actionPerformed(ActionEvent action) {
    EnglishPostPresenter productPresenter = new EnglishPostPresenter();
    double priceValue;
    int quantityAmount;
    if(action.getSource()==back){
        OptionsGUI optionsGUI = new OptionsGUI(user);
    }
    if(action.getSource()==post) {
        String nameField = name.getText();
        String priceField = price.getText();
        String categoryField = category.getText();
        String quantityField = quantity.getText();
        String descriptionField = description.getText();
        String sizeBox = size.getSelectedItem().toString();
        //check if any fields are empty
        if (nameField.equals("") | priceField.equals("") | categoryField.equals("") | quantityField.equals("") |
                descriptionField.equals("") | sizeBox.equals("")) {
            welcomeMessage.setForeground(Color.red);
            welcomeMessage.setText(productPresenter.fillInPresenter());
        }
        //check if price and quantity are double and int
        else {
            boolean isDouble = false;
            boolean isInteger = false;
            try {
                quantityAmount = Integer.parseInt(quantityField);
                isInteger = true;
            } catch (NumberFormatException numberFormatException) {
                welcomeMessage.setForeground(Color.red);
                welcomeMessage.setText(productPresenter.quantityValidityPresenter());
            }
            try {
                priceValue = Double.parseDouble(priceField);
                isDouble = true;
            } catch (NumberFormatException numberFormatException) {
                welcomeMessage.setForeground(Color.red);
                welcomeMessage.setText(productPresenter.priceValidityPresenter());
            }
            if (isDouble && isInteger) {
                frame.dispose();
                SuccesfulProductCreationGUI succesfulProductCreation = new SuccesfulProductCreationGUI(this.user);
            }
        }
    }

    }






}