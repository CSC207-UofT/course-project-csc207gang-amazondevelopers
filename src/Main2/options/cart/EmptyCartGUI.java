package options.cart;

import options.OptionsGUI;
import user.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EmptyCartGUI implements ActionListener {
    CartPresenter presenter = new CartPresenter();
    JFrame frame = new JFrame();
    JButton returnHome = new JButton("Back");


    JLabel emptyCartMessage = new JLabel(presenter.emptyCartMessage());
    ArrayList<String> cartList;
    User user;

    public EmptyCartGUI(User user) {
        this.user = user;

            emptyCartMessage.setBounds(150, 100, 250, 35);
            emptyCartMessage.setFont(new Font("Serif", Font.PLAIN, 14));

            returnHome.setBounds(60, 150, 300, 25);
            returnHome.addActionListener(this);

            frame.add(returnHome);
            frame.add(emptyCartMessage);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(420, 420);
            frame.setLayout(null);
            frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent action) {
        if(action.getSource()==returnHome) {
            frame.dispose();
            OptionsGUI optionsGUI = new OptionsGUI(user);
        }
    }
}
