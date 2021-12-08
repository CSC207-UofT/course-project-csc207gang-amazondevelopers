package options.post;

import gui.ButtonCommandInterface;
import gui.GUIFactory;
import gui.GUIFactoryInterface;
import user.User;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class CreatePostCommand implements ButtonCommandInterface {
    PostGUIMaker postGUIMaker;
    User user;

    /**
     * Initializer for create post command
     *
     * @param postGUIMaker constructor for post gui
     * @param user user logged in
     */

    public CreatePostCommand(PostGUIMaker postGUIMaker, User user) {
        this.postGUIMaker = postGUIMaker;
        this.user = user;
    }

    /**
     * creates window for creating a post
     */

    @Override
    public void apply(){
        EnglishPostPresenter productPresenter = new EnglishPostPresenter();
        PostInformationController postInformationController = new PostInformationController();
        String nameField = postGUIMaker.name.getText();
        String priceField = postGUIMaker.price.getText();
        String categoryField = postGUIMaker.category.getText();
        String quantityField = postGUIMaker.quantity.getText();
        String descriptionField = postGUIMaker.description.getText();
        String sizeBox = Objects.requireNonNull(postGUIMaker.size.getSelectedItem()).toString();
        String rateBox = Objects.requireNonNull(postGUIMaker.rate.getSelectedItem()).toString();
        String commentBox = Objects.requireNonNull(postGUIMaker.comment.getSelectedItem()).toString();

        //check if any fields are empty
        boolean emptyFields = postInformationController.Empty(nameField, priceField, categoryField, quantityField,
                descriptionField);
        boolean isInteger = postInformationController.integerOrNot(quantityField);
        boolean isDouble = postInformationController.doubleOrNot(priceField);
        if (emptyFields) {
            postGUIMaker.welcomeMessage.setForeground(Color.red);
            postGUIMaker.welcomeMessage.setText(productPresenter.fillInPresenter());}
        else {
            //check if price and quantity are double and int
            if (!isInteger) {postGUIMaker.welcomeMessage.setForeground(Color.red);
                postGUIMaker.welcomeMessage.setText(productPresenter.quantityValidityPresenter());}
            if (!isDouble) {postGUIMaker.welcomeMessage.setForeground(Color.red);
                postGUIMaker.welcomeMessage.setText(productPresenter.priceValidityPresenter());}}

        //IF ALL THE FIELDS ARE FILLED IN AND CORRECT (WE CAN ACTUALLY MAKE A POST)
        if (isDouble && isInteger && !emptyFields) {
            ArrayList<String> information = new ArrayList<>(Arrays. asList(nameField, priceField, categoryField
                    ,quantityField, descriptionField, sizeBox, rateBox, commentBox));
            CreatePostController createPostController = new CreatePostController(this.user);
            createPostController.createPost(information);

            postGUIMaker.frame.dispose();

            GUIFactory guiFactory = new GUIFactory(this.user);
            GUIFactoryInterface guiFrame = guiFactory.getFrame("SUCCESSPOST");
            guiFrame.createGUI();
        }
    }
}
