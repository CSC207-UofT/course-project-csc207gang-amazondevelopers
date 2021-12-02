package options;

import login_functions.WelcomePageGUI;
import userFunctions.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class OptionsGUI implements ActionListener {
    OptionsPresenter optionsPresenter = new OptionsPresenter();
    JFrame frame = new JFrame();
    JLabel welcomeLabel = new JLabel(optionsPresenter.message1());
    JButton logout = new JButton(optionsPresenter.message2());
    JButton browse = new JButton(optionsPresenter.message4());
    JButton findSellers = new JButton(optionsPresenter.message5());
    JButton makePost = new JButton(optionsPresenter.message6());
    JButton search = new JButton(optionsPresenter.message7());
    User user;

    /**
     * A constructor for options page which user can use to guide them to one of several options
     * @param user The user who you have accessed
     */
    public OptionsGUI(User user) {

        welcomeLabel.setBounds(125, 10, 200, 35);
        welcomeLabel.setFont(new Font(null, Font.PLAIN, 15));

        logout.setBounds(100, 300, 200, 35);
        logout.setFont(new Font(null, Font.PLAIN, 15));
        logout.addActionListener(this);

        browse.setBounds(100, 200, 200, 35);
        browse.setFont(new Font(null, Font.PLAIN, 15));
        browse.addActionListener(this);

        findSellers.setBounds(100, 150, 200, 35);
        findSellers.setFont(new Font(null, Font.PLAIN, 15));
        findSellers.addActionListener(this);

        makePost.setBounds(100, 100, 200, 35);
        makePost.setFont(new Font(null, Font.PLAIN, 15));
        makePost.addActionListener(this);

        search.setBounds(100, 50, 200, 35);
        search.setFont(new Font(null, Font.PLAIN, 15));
        search.addActionListener(this);

        frame.add(welcomeLabel); frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420); frame.setLayout(null); frame.setVisible(true);

        frame.add(logout); frame.add(browse); frame.add(findSellers); frame.add(makePost);
        frame.add(search);

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
                WelcomePageGUI welcomePageGUI = new WelcomePageGUI();
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        if(e.getSource()==makePost) {
            System.exit(0);
        }
        if(e.getSource()==search) {
            System.exit(0);
        }
        if(e.getSource()==findSellers) {
            System.exit(0);
        }
        if(e.getSource()==browse) {
            System.exit(0);
        }
    }

}
