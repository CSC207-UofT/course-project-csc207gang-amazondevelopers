package options;

import login.welcome_page.WelcomePageGUIMaker;
import options.browse.BrowseController;
import options.browse.EmptyFeedGUI;
import options.browse.FeedGUI;
import options.cart.CartGUI;
import options.follow_users.FollowGUI;
import options.search.SearchGUI;
import options.post.Post;
import options.post.PostGUI;
import user.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class OptionsGUI implements ActionListener {
    OptionsPresenter optionsPresenter = new OptionsPresenter();
    JFrame frame = new JFrame();
    JLabel welcomeLabel = new JLabel(optionsPresenter.message1());
    JButton logout = new JButton(optionsPresenter.message2());
    JButton browse = new JButton(optionsPresenter.message4());
    JButton findSellers = new JButton(optionsPresenter.message5());
    JButton makePost = new JButton(optionsPresenter.message6());
    JButton search = new JButton(optionsPresenter.message7());
    JButton cart = new JButton(optionsPresenter.message8());
    User user;

    /**
     * A constructor for options page which user can use to guide them to one of several options
     * @param user The user who you have accessed
     */
    public OptionsGUI(User user) {

        welcomeLabel.setBounds(125, 25, 200, 35);
        welcomeLabel.setFont(new Font(null, Font.PLAIN, 15));

        logout.setBounds(100, 300, 200, 35);
        logout.setFont(new Font(null, Font.PLAIN, 15));
        logout.addActionListener(this);

        browse.setBounds(100, 250, 200, 35);
        browse.setFont(new Font(null, Font.PLAIN, 15));
        browse.addActionListener(this);

        findSellers.setBounds(100, 200, 200, 35);
        findSellers.setFont(new Font(null, Font.PLAIN, 15));
        findSellers.addActionListener(this);

        makePost.setBounds(100, 150, 200, 35);
        makePost.setFont(new Font(null, Font.PLAIN, 15));
        makePost.addActionListener(this);

        search.setBounds(100, 100, 200, 35);
        search.setFont(new Font(null, Font.PLAIN, 15));
        search.addActionListener(this);

        cart.setBounds(100, 50, 200, 35);
        cart.setFont(new Font(null, Font.PLAIN, 15));
        cart.addActionListener(this);

        frame.add(welcomeLabel); frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420); frame.setLayout(null); frame.setVisible(true);

        frame.add(logout); frame.add(browse); frame.add(findSellers); frame.add(makePost);
        frame.add(search); frame.add(cart);

        this.user = user;
    }

    /**
     * The action listener that sees what the user is doing and determines the results from this action
     * @param e the action of the user
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==logout) {
            frame.dispose();
            try {
                WelcomePageGUIMaker welcomePageGUIMaker = new WelcomePageGUIMaker();
                welcomePageGUIMaker.createGUI();
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        if(e.getSource()==makePost) {
            frame.dispose();
            PostGUI productGUI = new PostGUI(this.user);
        }
        if(e.getSource()==search) {
            frame.dispose();
            SearchGUI searchGUI = new SearchGUI(this.user);
        }
        if(e.getSource()==findSellers) {

            frame.dispose();
            FollowGUI followGUI = new FollowGUI(this.user);

        }
        if(e.getSource()==browse) {
            frame.dispose();
            BrowseController browseController = new BrowseController(user);
            ArrayList<Post> feed = null;
            try {
                feed = browseController.getFeed();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
            if (0 == feed.size()){
                EmptyFeedGUI emptyFeedGUI = new EmptyFeedGUI(user);
            }
            else{
                FeedGUI feedGUI = new FeedGUI(feed,user,0);
            }
        }
        if(e.getSource()==cart) {
            frame.dispose();
            CartGUI cartGUI = new CartGUI(this.user);
        }
    }
}
