package browse;

import post.Post;

import javax.swing.*;

public class FeedGUI {
    JFrame frame = new JFrame();
    EnglishFeedPresenter feedPresenter = new EnglishFeedPresenter();
    JButton nextButton = new JButton(feedPresenter.presentNext());
    JButton cartButton = new JButton(feedPresenter.presentBuy());
    JButton backButton = new JButton(feedPresenter.presentBack());
    JLabel posterLabel = new JLabel();
    JLabel captionLabel = new JLabel();
    JLabel productNameLabel = new JLabel();
    public FeedGUI(){
        posterLabel.setText(feedPresenter.presentPostedBy() + post.getUser().getUsername());
        posterLabel.setBounds(25,25,100,25);

        captionLabel.setText(feedPresenter.presentCaption() + post.getCaption());
        captionLabel.setBounds(25,75,100,25);

        productNameLabel.setText(feedPresenter.presentProductName() + post.getProduct().getName());
        productNameLabel.set


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
