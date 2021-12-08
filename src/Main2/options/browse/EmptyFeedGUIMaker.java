package options.browse;

import gui.ButtonCommandInterface;
import gui.GUIFactoryInterface;
import options.browse.EmptyFeedPresenter.EnglishEmptyFeedPresenter;
import options.commands.OptionsCommand;
import user.User;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EmptyFeedGUIMaker implements ActionListener, GUIFactoryInterface {

    User user;
    static Map<String, ButtonCommandInterface> commandMap = new HashMap<>();

    /**
     * Initializes empty feed gui
     *
     * @param user the user currently logged in
     */

    public EmptyFeedGUIMaker(User user){
        this.user = user;
    }

    /**
     * interprets the action performed
     * @param action action performed
     */

    @Override
    public void actionPerformed(ActionEvent action) {
        String buttonText = action.getActionCommand();
        ButtonCommandInterface button = commandMap.get(buttonText);
        button.apply();
    }

    /**
     * Creates gui for empty feed
     */

    @Override
    public void createGUI() {
        EnglishEmptyFeedPresenter feedPresenter = new EnglishEmptyFeedPresenter();
        JFrame frame = new JFrame();
        JButton backButton = new JButton(feedPresenter.presentReturn());
        JLabel emptyLabel = new JLabel(feedPresenter.presentEmpty());
        emptyLabel.setBounds(25,25,400,50);
        backButton.setBounds(160, 340, 100, 25);
        backButton.addActionListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420); frame.setLayout(null); frame.setVisible(true);
        frame.add(backButton);
        frame.add(emptyLabel);

        commandMap.put(backButton.getText(), new OptionsCommand(frame, this.user));
    }
}
