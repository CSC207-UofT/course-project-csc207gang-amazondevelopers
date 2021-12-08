package login.welcome_page;

import gui.ButtonCommandInterface;
import gui.GUIFactoryInterface;
import login.welcome_page.WelcomePagePresenter.EnglishWelcomePagePresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Take user input for what they want to do upon seeing the login page.
 */

public class WelcomePageGUIMaker implements ActionListener, GUIFactoryInterface {
    EnglishWelcomePagePresenter englishWelcomePagePresenter = new EnglishWelcomePagePresenter();
    JFrame frame = new JFrame();
    JButton signinButton = new JButton(englishWelcomePagePresenter.presentSignIn());
    JButton signupButton = new JButton(englishWelcomePagePresenter.presentSignUp());
    JButton quit = new JButton(englishWelcomePagePresenter.presentQuit());
    static Map<String, ButtonCommandInterface> commandMap = new HashMap<>();

    /**
     * Constructor for the WelcomePageGUIMaker
     */
    public WelcomePageGUIMaker(){
    }

    /**
     *
     * @param action The action event, helps to maintain the actions performed by the user and the results from their
     *          actions that they perform on the page
     */
    @Override
    public void actionPerformed(ActionEvent action) {
        String buttonText = action.getActionCommand();
        ButtonCommandInterface button = commandMap.get(buttonText);
        button.apply();
        frame.dispose();
    }

    /**
     * Creates the JFame for the WelcomePage.
     */
    @Override
    public void createGUI() {
        JLabel messageLabel = new JLabel(englishWelcomePagePresenter.welcomeMessage());

        messageLabel.setBounds(70, 100, 250, 35);
        messageLabel.setFont(new Font("Serif", Font.PLAIN, 14));

        signupButton.setBounds(45, 200, 100, 25);
        signupButton.addActionListener(this);

        signinButton.setBounds(145, 200, 100, 25);
        signinButton.addActionListener(this);

        quit.setBounds(245, 200, 100, 25);
        quit.addActionListener(this);

        frame.add(messageLabel);
        frame.add(signupButton);
        frame.add(signinButton);
        frame.add(quit);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);

        commandMap.put(quit.getText(), new QuitCommand());
        commandMap.put(signinButton.getText(), new SignInCommand());
        commandMap.put(signupButton.getText(), new SignUpCommand());
    }
}
