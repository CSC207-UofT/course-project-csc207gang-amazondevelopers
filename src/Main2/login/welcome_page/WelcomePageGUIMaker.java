package login.welcome_page;

import gui.ButtonActionInterface;
import gui.GUI;
import gui.GUIFactoryInterface;
import login.GetIDandPasswordsGateway;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Take user input for what they want to do upon seeing the login page.
 */

public class WelcomePageGUIMaker implements ActionListener, GUIFactoryInterface {

    JFrame frame = new JFrame();
    JButton signinButton = new JButton("Signin");
    JButton signupButton = new JButton("Signup");
    JButton quit = new JButton("Quit");
    static Map<String, ButtonActionInterface> actionMap = new HashMap<>();

    /**
     * Constructor for the WelcomePageGUIMaker
     */
    public WelcomePageGUIMaker() throws IOException, ClassNotFoundException {
    }

    /**
     *
     * @param e The action event, helps to maintain the actions performed by the user and the results from their
     *          actions that they perform on the page
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        String buttonText = e.getActionCommand();
        ButtonActionInterface button = actionMap.get(buttonText);
        try {
            button.apply();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Creates the JFame for the WelcomePage.
     * @return a GUI
     */
    @Override
    public GUI createGUI() throws IOException, ClassNotFoundException {

        WelcomePagePresenter welcomePagePresenter = new WelcomePagePresenter();
        JLabel messageLabel = new JLabel(welcomePagePresenter.welcomeMessage());

        GetIDandPasswordsGateway login = new GetIDandPasswordsGateway();
        HashMap<String, Object> logininfo = login.getUsernamePasswordHash();

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

        actionMap.put(quit.getText(), new QuitButton());
        actionMap.put(signinButton.getText(), new SignInButton());
        actionMap.put(signupButton.getText(), new SignUpButton());

        return new WelcomePageGUI(frame);
    }
}