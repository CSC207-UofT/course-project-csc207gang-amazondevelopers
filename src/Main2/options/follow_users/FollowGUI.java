package options.follow_users;

import options.OptionsGUI;
import user.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class FollowGUI implements ActionListener {
    FollowPresenter followPresenter = new FollowPresenter();
    JFrame frame = new JFrame();
    JButton followButtonLabel = new JButton(followPresenter.followButton());
    JTextField searchBar = new JTextField();
    JButton clear = new JButton(followPresenter.clearButton());
    JButton back = new JButton(followPresenter.backButton());
    JLabel followLabel = new JLabel(followPresenter.followInstructions());
    JLabel messageLabel = new JLabel();
    User user;


    public FollowGUI(User user) {
        this.user = user;

        followLabel.setBounds(125, 25, 250, 35);
        followLabel.setFont(new Font("Serif", Font.PLAIN, 14));

        // search bar + search button
        followButtonLabel.setBounds(50, 50, 200, 35);
        searchBar.setBounds(125, 50, 200, 35);
        followButtonLabel.setBounds(125, 100, 200, 35);
        followButtonLabel.setFont(new Font(null, Font.PLAIN, 15));
        followButtonLabel.addActionListener(this);

        // button to clear the search bar
        clear.setBounds(125, 150, 200, 35);
        clear.setFont(new Font(null, Font.PLAIN, 15));
        clear.addActionListener(this);

        // go back button
        back.setBounds(125, 300, 100, 35);
        back.setFont(new Font(null, Font.PLAIN, 15));
        back.addActionListener(this);
        //Label after clicking follow button

        messageLabel.setBounds(125, 125, 200, 130);


        frame.add(followButtonLabel);
        frame.add(followLabel);
        frame.add(searchBar);
        frame.add(clear);
        frame.add(back);
        frame.add(messageLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(messageLabel);
    }

    /**
     * The action listener that sees what the user is doing and determines the results from this action.
     * @param action the action of the user
     */
    @Override
    public void actionPerformed(ActionEvent action) {
        if(action.getSource() == back){
            frame.dispose();
            OptionsGUI optionsGUI = new OptionsGUI(user);
        }

        if(action.getSource() == clear) {
            searchBar.setText("");
        }

        if(action.getSource() == followButtonLabel) {
            String username = searchBar.getText();
            FollowController followController = new FollowController(user);
            if(followController.canFollow(username)){
                messageLabel.setForeground(Color.black);
                messageLabel.setText(followPresenter.presentCanFollow());
            }
            else{
                messageLabel.setForeground(Color.red);
                messageLabel.setText(followPresenter.presentCantFollow());
            }
            }
        }

    }

