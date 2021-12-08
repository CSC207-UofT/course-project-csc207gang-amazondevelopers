package options.commands;

import gui.ButtonCommandInterface;
import options.buy.BuyController;
import options.search.ScrollSearchGUIMaker;
import options.search.SearchController;
import options.search.SearchPresenter;
import options.search.SearchPresenterInterface;
import user.User;
import java.awt.*;
import java.util.ArrayList;

public class BuyCommand implements ButtonCommandInterface {

    User user;
    String tag;
    ScrollSearchGUIMaker scrollSearchGUIMaker;

    /**
     * class initializer
     *
     * @param user user logged in
     */

    public BuyCommand(User user,String tag, ScrollSearchGUIMaker scrollSearchGUIMaker) {
        this.user = user;
        this.tag  = tag;
        this.scrollSearchGUIMaker = scrollSearchGUIMaker;
    }

    /**  attempts to buy user cart
     *
     */

    @Override
    public void apply(){
        SearchPresenterInterface searchPresenter = new SearchPresenter();
        SearchController searchController = new SearchController(user);
        String index = scrollSearchGUIMaker.searchBar.getText();
        int indexInt = Integer.parseInt(index);

        BuyController buyController = new BuyController();
        ArrayList<String> productIds = searchController.getProductIDStrings(this.tag);
        boolean allowedBuy = buyController.allowBuy(user, productIds, indexInt);
        if (allowedBuy) {
            scrollSearchGUIMaker.messageLabel.setForeground(Color.green);
            scrollSearchGUIMaker.messageLabel.setText(searchPresenter.canBuy());
        } else {
            scrollSearchGUIMaker.messageLabel.setForeground(Color.red);
            scrollSearchGUIMaker.messageLabel.setText(searchPresenter.cannotBuy());
        }
    }
}
