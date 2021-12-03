package options;

import javax.swing.*;
import java.awt.*;

public class SearchGUI {
    SearchPresenterInterface searchPresenter = new SearchPresenter();
    JFrame frame = new JFrame();

    // JLabel welcomeLabel = new JLabel(searchPresenter.searchButton());
    JButton search = new JButton(searchPresenter.searchButton());
    JTextField searchBar = new JTextField();

    JLabel clear = new JLabel(searchPresenter.clearButton());
    JButton back = new JButton(searchPresenter.backButton());

    public SearchGUI() {
        search.setBounds(125, 25, 200, 35);
        search.setFont(new Font(null, Font.PLAIN, 15));

        clear.setBounds(125, 25, 200, 35);
        clear.setFont(new Font(null, Font.PLAIN, 15));

        back.setBounds(125, 25, 200, 35);
        back.setFont(new Font(null, Font.PLAIN, 15));
    }

}
