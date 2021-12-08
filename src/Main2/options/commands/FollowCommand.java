package options.commands;

import gui.ButtonCommandInterface;
import options.follow_users.FollowController;
import options.follow_users.FollowGUIMaker;
import options.follow_users.FollowPresenter;
import user.User;

import java.awt.*;
import java.io.IOException;

public class FollowCommand implements ButtonCommandInterface {

    FollowGUIMaker followGUIMaker;
    User user;

    FollowPresenter followPresenter = new FollowPresenter();
    public FollowCommand(User user, FollowGUIMaker followGUIMaker) {
        this.user = user;
        this.followGUIMaker = followGUIMaker;
    }

    @Override
    public void apply() throws IOException, ClassNotFoundException {
//        String username = followGUIMaker.searchBar.getText();
//        FollowController followController = new FollowController(user);
//        if(followController.canFollow(username)){
//            followGUIMaker.messageLabel.setForeground(Color.black);
//            followGUIMaker.messageLabel.setText(followPresenter.presentCanFollow());
//        }
//        else{
//            followGUIMaker.messageLabel.setForeground(Color.red);
//            followGUIMaker.messageLabel.setText(followPresenter.presentCantFollow());
//        }
    }
}
