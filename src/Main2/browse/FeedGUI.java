package browse;

import browse.FeedPresenter.EnglishFeedPresenter;

import cart_functions.Cart;
import options.UserOptionsController;
import options.OptionsGUI;
import userFunctions.User;
import postFunctions.Post;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import userFunctions.CartManager;

/**
 * Class that presents a post to a user using our JFrame command line interface,
 *
 */
public class FeedGUI implements ActionListener {
    JFrame frame = new JFrame();
    EnglishFeedPresenter feedPresenter = new EnglishFeedPresenter();
    JButton nextButton = new JButton(feedPresenter.presentNext());
    JButton cartButton = new JButton(feedPresenter.presentBuy());
    JButton backButton = new JButton(feedPresenter.presentBack());
    JLabel posterLabel = new JLabel();
    JLabel captionLabel = new JLabel();
    JLabel productNameLabel = new JLabel();
    JLabel productDescriptionLabel = new JLabel();
    JLabel productQuantityLabel = new JLabel();
    JLabel productSizeLabel = new JLabel();
    JLabel indexLabel = new JLabel();
    ArrayList<Post> feed;
    Post post;
    int index;
    User user;

    /**
     * Represents a constructor for the JFrame of a Post in the Feed
     * @param feed        Represents the total feed of the current user
     * @param user        The user viewing posts
     */
    public FeedGUI( ArrayList<Post> feed, User user, int index) {
        this.post = feed.get(index);
        this.feed = feed;
        this.index = index;
        this.user = user;
        posterLabel.setText(feedPresenter.presentPostedBy() + post.getUser().getUsername());
        posterLabel.setBounds(25, 25, 400, 25);

        captionLabel.setText(feedPresenter.presentCaption() + post.getCaption());
        captionLabel.setBounds(25, 75, 400, 25);

        productNameLabel.setText(feedPresenter.presentProductName() + post.getProduct().getName());
        productNameLabel.setBounds(25, 125, 400, 25);

        productQuantityLabel.setText(feedPresenter.presentQuantity() + post.getProduct().getQuantity());
        productQuantityLabel.setBounds(25, 175, 400, 25);

        productSizeLabel.setText(feedPresenter.presentSize() + post.getProduct().getSizes());
        productSizeLabel.setBounds(25, 225, 400, 25);

        backButton.setBounds(45, 400, 100, 25);
        backButton.addActionListener(this);

        cartButton.setBounds(145, 400, 100, 25);
        cartButton.addActionListener(this);

        nextButton.setBounds(245, 400, 100, 25);
        nextButton.addActionListener(this);

        indexLabel.setText(index + 1 + "/" + feed.size());
        indexLabel.setBounds(425, 425, 50, 25);
        frame.add(indexLabel);
        frame.add(productNameLabel);
        frame.add(productDescriptionLabel);
        frame.add(productQuantityLabel);
        frame.add(productSizeLabel);
        frame.add(nextButton);
        frame.add(cartButton);
        frame.add(backButton);
        frame.add(posterLabel);
        frame.add(captionLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    /**
     * Represents different actions when the JButtons are interacted with the user
     *
     * @param e the Action event performed in
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextButton) {
            if (index == feed.size() - 1) {
                frame.setVisible(false);
                frame.dispose();
                OptionsGUI optionsGateway = new OptionsGUI(user);
            } else {
                frame.setVisible(false);
                frame.dispose();
                FeedGUI feedGUI = new FeedGUI(feed, user, index + 1);
            }
            if (e.getSource() == backButton) {
                if (this.index == 0) {
                    frame.setVisible(false);
                    frame.dispose();
                    OptionsGUI optionsGUI = new OptionsGUI(user);
                } else {
                    frame.setVisible(false);
                    frame.dispose();
                    FeedGUI feedGUI = new FeedGUI( feed, user, index - 1);
                }
            }
            if (e.getSource() == cartButton) {
                CartManager cartManager = new CartManager();
                cartManager.addToCart(post.getProduct(), user);
                frame.setVisible(false);
                frame.dispose();
                AddedToCartGUI addedToCartGUI = new AddedToCartGUI(user, post.getProduct().getName());
            }
        }

        else if (e.getSource() == cartButton) {
            Cart cart = new Cart();
            cart.addToCart(user, post.getProduct());
            frame.setVisible(false);
            frame.dispose();
            AddedToCartGUI addedToCartGUI = new AddedToCartGUI(user,post.getProduct().getName());
            }
        }

    }
}

