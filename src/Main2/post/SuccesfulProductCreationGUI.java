package post;

import options.OptionsGUI;
import userFunctions.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SuccesfulProductCreationGUI implements ActionListener {
    User user;
    EnglishPostPresenter presenter = new EnglishPostPresenter();
    JFrame frame = new JFrame();
    JButton back = new JButton(presenter.backToMenu());
    JLabel message = new JLabel(presenter.congrats());

    public SuccesfulProductCreationGUI(User user) {
        this.user = user;
        back.setBounds(125, 100, 200, 25);
        back.addActionListener(this);

        message.setBounds(125, 50, 300, 25);
        message.setFont(new Font(null, Font.PLAIN, 15));

        frame.add(back);
        frame.add(message);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 200);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent action) {
        if(action.getSource()==back){
            OptionsGUI optionsGUI = new OptionsGUI(this.user);
        }
    }
}
