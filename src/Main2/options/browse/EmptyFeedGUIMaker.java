package options.browse;

import gui.GUIFactoryInterface;
import options.browse.EmptyFeedPresenter.EnglishEmptyFeedPresenter;
import user.User;
import options.OptionsGUIMaker;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmptyFeedGUIMaker implements ActionListener, GUIFactoryInterface {
    EnglishEmptyFeedPresenter feedPresenter = new EnglishEmptyFeedPresenter();
    JFrame frame = new JFrame();
    JButton backButton = new JButton(feedPresenter.presentReturn());
    JLabel emptyLabel = new JLabel(feedPresenter.presentEmpty());
    User user;
    public EmptyFeedGUIMaker(User user){
        emptyLabel.setBounds(25,25,400,50);
        backButton.setBounds(160, 340, 100, 25);
        backButton.addActionListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420); frame.setLayout(null); frame.setVisible(true);
        frame.add(backButton);
        frame.add(emptyLabel);
        this.user = user;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton){
            frame.dispose();
            OptionsGUIMaker userOptionsGUIMaker = new OptionsGUIMaker(user);
        }
    }

    @Override
    public void createGUI() {

    }
}
