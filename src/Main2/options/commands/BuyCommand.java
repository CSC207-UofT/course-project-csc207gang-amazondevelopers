package options.commands;

import gui.ButtonCommandInterface;
import options.buy.BuyController;
import options.search.ScrollSearchGUIMaker;
import options.search.SearchController;
import options.search.SearchPresenter;
import options.search.SearchPresenterInterface;
import user.User;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class BuyCommand implements ButtonCommandInterface {

    User user;
    String tag;
    ScrollSearchGUIMaker scrollSearchGUIMaker;

    public BuyCommand(User user,String tag, ScrollSearchGUIMaker scrollSearchGUIMaker) {
        this.user = user;
        this.tag  = tag;
        this.scrollSearchGUIMaker = scrollSearchGUIMaker;
    }

    @Override
    public void apply() throws IOException, ClassNotFoundException {
        SearchPresenterInterface searchPresenter = new SearchPresenter();
        SearchController searchController = new SearchController(user);
        String index = scrollSearchGUIMaker.searchBar.getText();
        int indexInt = Integer.parseInt(index);

        BuyController buyController = new BuyController();
        boolean allowedBuy = false;
        try {
            ArrayList<String> productIds = searchController.getProductIDStrings(this.tag);
            allowedBuy = buyController.allowBuy(user, productIds, indexInt);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (allowedBuy) {
            scrollSearchGUIMaker.messageLabel.setForeground(Color.green);
            scrollSearchGUIMaker.messageLabel.setText(searchPresenter.canBuy());
        } else {
            scrollSearchGUIMaker.messageLabel.setForeground(Color.red);
            scrollSearchGUIMaker.messageLabel.setText(searchPresenter.cannotBuy());
        }
    }
}
