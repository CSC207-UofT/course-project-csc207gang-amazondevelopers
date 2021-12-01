package login_functions;

import userFunctions.User;

import javax.swing.*;
import java.awt.*;

public class OptionsController {

    JFrame frame = new JFrame();
    JLabel welcomeLabel = new JLabel("Hello");

    OptionsController(User user) {

        welcomeLabel.setBounds(0, 0, 200, 35);
        welcomeLabel.setFont(new Font(null, Font.PLAIN, 25));

        frame.add(welcomeLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

}
