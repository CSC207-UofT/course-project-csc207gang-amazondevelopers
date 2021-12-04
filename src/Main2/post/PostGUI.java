package post;

import login_functions.WelcomePageGUI;
import options.OptionsGUI;
import userFunctions.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class PostGUI implements ActionListener { User user;
EnglishPostPresenter productPresenter = new EnglishPostPresenter();
JFrame frame = new JFrame();
JLabel welcomeMessage = new JLabel(productPresenter.Welcome());
JLabel nameMessage = new JLabel(productPresenter.namePresenter());
JLabel priceMessage = new JLabel(productPresenter.pricePresenter());
JLabel categoryMessage = new JLabel(productPresenter.categoryPresenter());
JLabel sizeMessage = new JLabel(productPresenter.sizePresenter());
JLabel rateMessage = new JLabel(productPresenter.ratePresenter());
JLabel commentMessage = new JLabel(productPresenter.commentPresenter());
JLabel quantityMessage = new JLabel(productPresenter.quantityPresenter());
JLabel descriptionMessage = new JLabel(productPresenter.describePresenter());
String[] sizes = {"Extra small", "Small", "Medium", "Large", "Extra Large", "N/A"};
String[] choices = {"Yes", "No"};
JComboBox size = new JComboBox(sizes);
JComboBox rate = new JComboBox(choices); JComboBox comment = new JComboBox(choices);

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
    descriptionMessage.setFont(new Font(null, Font.PLAIN, 13));
    description.setBounds(125, 250, 200, 25);

    back.setBounds(125, 450, 100, 25);
    back.addActionListener(this);

    post.setBounds(225, 450, 100, 25);
    post.addActionListener(this);

    sizeMessage.setBounds(50, 300, 75, 25);
    sizeMessage.setFont(new Font(null, Font.PLAIN, 15));
    size.setBounds(125, 300, 200, 25);

    rateMessage.setBounds(50, 350, 75, 25);
    rateMessage.setFont(new Font(null, Font.PLAIN, 15));
    rate.setBounds(125, 350, 200, 25);

    commentMessage.setBounds(50, 400, 75, 25);
    commentMessage.setFont(new Font(null, Font.PLAIN, 15));
    comment.setBounds(125, 400, 200, 25);


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
    frame.add(rateMessage);
    frame.add(commentMessage);
    frame.add(comment);
    frame.add(rate);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 550);
    frame.setLayout(null);
    frame.setVisible(true);
    frame.setResizable(false);
}

    /**
     * Moderates the actions of the user and the subsequent results of the user actions
     * @param action the actions of the user
     */
    public void actionPerformed(ActionEvent action) {
    EnglishPostPresenter productPresenter = new EnglishPostPresenter();
    PostInformationController postInformationController = new PostInformationController();
        String nameField = name.getText();
        String priceField = price.getText();
        String categoryField = category.getText();
        String quantityField = quantity.getText();
        String descriptionField = description.getText();
        String sizeBox = Objects.requireNonNull(size.getSelectedItem()).toString();
        String rateBox = Objects.requireNonNull(rate.getSelectedItem()).toString();
        String commentBox = Objects.requireNonNull(comment.getSelectedItem()).toString();

    if(action.getSource()==back){
        frame.dispose();
        OptionsGUI optionsGUI = new OptionsGUI(user);
    }
    if(action.getSource()==post) {
        //check if any fields are empty
        boolean emptyFields = postInformationController.Empty(nameField, priceField, categoryField, quantityField,
                descriptionField);
        boolean isInteger = postInformationController.integerOrNot(quantityField);
        boolean isDouble = postInformationController.doubleOrNot(priceField);
        if (emptyFields) {
            welcomeMessage.setForeground(Color.red);
            welcomeMessage.setText(productPresenter.fillInPresenter());}
        else {
        //check if price and quantity are double and int
        if (!isInteger) {welcomeMessage.setForeground(Color.red);
            welcomeMessage.setText(productPresenter.quantityValidityPresenter());}
            if (!isDouble) {welcomeMessage.setForeground(Color.red);
                welcomeMessage.setText(productPresenter.priceValidityPresenter());}}

            //IF ALL THE FIELDS ARE FILLED IN AND CORRECT (WE CAN ACTUALLY MAKE A POST)
            if (isDouble && isInteger && !emptyFields) {
                ArrayList<String> information = new ArrayList<>(Arrays. asList(nameField, priceField, categoryField
                ,quantityField, descriptionField, sizeBox, rateBox, commentBox));
                CreatePostController createPostController = new CreatePostController(this.user);
                try {
                    createPostController.createPost(information);
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                frame.dispose();

                SuccessfulPostCreationGUI successfulProductCreation = new SuccessfulPostCreationGUI(this.user);
            }
        }
    }








}
