package options.browse;

import gui.ButtonCommandInterface;
import gui.GUIFactoryInterface;
import options.browse.FeedPresenter.EnglishFeedPresenter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import options.browse.commands.AddToCartCommand;
import options.browse.commands.BackCommand;
import options.browse.commands.NextCommand;
import options.post.Post;
import product.GetProductGateway;
import product.Product;
import user.User;

/**
 * Class that presents a options.post to a user using our JFrame command line interface, allowing
 * a user to view the next post, view the last post or add to cart
 *
 */
public class FeedGUIMaker implements ActionListener, GUIFactoryInterface {
    ArrayList<Post> feed;
    Post post;
    int index;
    User user;
    Product product;
    static Map<String, ButtonCommandInterface> commandMap = new HashMap<>();
    JFrame frame = new JFrame();

    /**
     * Represents a constructor for the JFrame of a Post in the Feed
     * @param feed        Represents the total feed of the current user
     * @param user        The user viewing posts
     */
    public FeedGUIMaker(ArrayList<Post> feed, User user, int index){
        this.feed = feed;
        this.index = index;
        this.user = user;
    }

    /**
     * Represents different actions when the JButtons are interacted with the user
     * @param action the Action event performed in
     */
    @Override
    public void actionPerformed(ActionEvent action) {
        String buttonText = action.getActionCommand();
        ButtonCommandInterface button = commandMap.get(buttonText);
        button.apply();
    }

    /**
     * creates gui for feed
     */

    @Override
    public void createGUI() {

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
        this.post = feed.get(index);
        GetProductGateway getProductGateway = new GetProductGateway();
        this.product = getProductGateway.getProduct(post.getProduct());
        posterLabel.setText(feedPresenter.presentPostedBy() + post.getUser().getUsername());
        posterLabel.setBounds(25, 25, 400, 25);

        captionLabel.setText(feedPresenter.presentCaption() + post.getCaption());
        captionLabel.setBounds(25, 75, 400, 25);

        productNameLabel.setText(feedPresenter.presentProductName() + product.getName());
        productNameLabel.setBounds(25, 125, 400, 25);

        productQuantityLabel.setText(feedPresenter.presentQuantity() + product.getQuantity());
        productQuantityLabel.setBounds(25, 175, 400, 25);

        productSizeLabel.setText(feedPresenter.presentSize() + product.getSizes());
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

        commandMap.put(nextButton.getText(), new NextCommand(this.user, frame, feed, index));
        commandMap.put(backButton.getText(), new BackCommand(this.user, frame, feed, index));
        commandMap.put(cartButton.getText(), new AddToCartCommand(product, this.user, frame));
        //
    }
}


