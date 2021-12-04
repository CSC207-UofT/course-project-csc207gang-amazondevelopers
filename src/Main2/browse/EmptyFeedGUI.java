package browse;

import browse.EmptyFeedPresenter.EnglishEmptyFeedPresenter;
import userFunctions.User;
import options.OptionsGUI;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmptyFeedGUI implements ActionListener {
    EnglishEmptyFeedPresenter feedPresenter = new EnglishEmptyFeedPresenter();
    JFrame frame = new JFrame();
    JButton backButton = new JButton(feedPresenter.presentReturn());
    JLabel emptyLabel = new JLabel(feedPresenter.presentEmpty());
    User user;
    public EmptyFeedGUI(User user){
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
            OptionsGUI userOptionsGUI = new OptionsGUI(user);
        }
    }
}
