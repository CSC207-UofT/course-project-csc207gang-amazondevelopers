package options.commands;

import gui.ButtonCommandInterface;
import options.follow_users.FollowController;
import options.follow_users.FollowGUIMaker;
import options.follow_users.FollowPresenter;
import user.User;

import java.awt.*;

public class FollowCommand implements ButtonCommandInterface {

    FollowGUIMaker followGUIMaker;
    User user;
    FollowPresenter followPresenter = new FollowPresenter();

    /**
     * class initializer
     *
     * @param user user logged in
     * @param followGUIMaker constructor for following gui
     */

    public FollowCommand(User user, FollowGUIMaker followGUIMaker) {
        this.user = user;
        this.followGUIMaker = followGUIMaker;
    }

    /** opens follows user that was searched
     *
     */

    @Override
    public void apply() {
        FollowController followController = new FollowController(this.user);
        String username = FollowGUIMaker.searchBar.getText();
        if(followController.canFollow(username)){
            followGUIMaker.messageLabel.setForeground(Color.black);
            followGUIMaker.messageLabel.setText(followPresenter.presentCanFollow());
        }
        else{
            followGUIMaker.messageLabel.setForeground(Color.red);
            followGUIMaker.messageLabel.setText(followPresenter.presentCantFollow());
        }
    }
}
