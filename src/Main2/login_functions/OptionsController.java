package login_functions;

import product.ProductGUI;
import userFunctions.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class OptionsController implements ActionListener {
    OptionsPresenter optionsPresenter = new OptionsPresenter();
    JFrame frame = new JFrame();
    JLabel welcomeLabel = new JLabel(optionsPresenter.message1());
    JButton logout = new JButton(optionsPresenter.message2());
    JButton settings = new JButton(optionsPresenter.message3());
    JButton browse = new JButton(optionsPresenter.message4());
    JButton findSellers = new JButton(optionsPresenter.message5());
    JButton makePost = new JButton(optionsPresenter.message6());
    JButton search = new JButton(optionsPresenter.message7());

    /**
     * A constructor for options page which user can use to guide them to one of several options
     * @param user The user who you have accessed
     */
    OptionsController(User user) {

        welcomeLabel.setBounds(125, 10, 200, 35);
        welcomeLabel.setFont(new Font(null, Font.PLAIN, 15));

        logout.setBounds(125, 300, 200, 35);
        logout.setFont(new Font(null, Font.PLAIN, 15));

        settings.setBounds(125, 250, 200, 35);
        settings.setFont(new Font(null, Font.PLAIN, 15));

        browse.setBounds(125, 200, 200, 35);
        browse.setFont(new Font(null, Font.PLAIN, 15));

        findSellers.setBounds(125, 150, 200, 35);
        findSellers.setFont(new Font(null, Font.PLAIN, 15));

        makePost.setBounds(125, 100, 200, 35);
        makePost.setFont(new Font(null, Font.PLAIN, 15));

        search.setBounds(125, 50, 200, 35);
        search.setFont(new Font(null, Font.PLAIN, 15));

        frame.add(welcomeLabel); frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420); frame.setLayout(null); frame.setVisible(true);

        frame.add(logout); frame.add(settings); frame.add(browse); frame.add(findSellers); frame.add(makePost);
        frame.add(search);

    }

    /**
     * The action listener that sees what the user is doing and determines the results from this action
     * @param e the action of the user
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
