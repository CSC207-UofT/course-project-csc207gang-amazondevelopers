package browse;

import browse.AddedToCartPresenter.EnglishAddedPresenter;
import browse.EmptyFeedPresenter.EnglishEmptyFeedPresenter;
import options.OptionsGUI;
import user.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * JFrame GUI to call when a product was added to your cart from Feed
 */
public class AddedToCartGUI implements ActionListener {
    EnglishEmptyFeedPresenter feedPresenter = new EnglishEmptyFeedPresenter();
    EnglishAddedPresenter addedPresenter = new EnglishAddedPresenter();
    JFrame frame = new JFrame();
    JButton backButton = new JButton(feedPresenter.presentReturn());
    JLabel addedLabel = new JLabel();
    User user;
    public AddedToCartGUI(User user,String productName){
        addedLabel.setBounds(25,25,400,50);
        addedLabel.setText(productName + addedPresenter.presentAddedToCart());
        backButton.setBounds(160, 340, 100, 25);
        backButton.addActionListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420); frame.setLayout(null); frame.setVisible(true);
        frame.add(backButton);
        frame.add(addedLabel);
        this.user = user;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton){
            frame.dispose();
            OptionsGUI userOptionsGUI = new OptionsGUI(user);
        }
    }
}
