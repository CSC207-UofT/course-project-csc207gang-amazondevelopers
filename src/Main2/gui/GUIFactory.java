package gui;

import login.sign_in.SignInGUIMaker;
import login.sign_up.SignUpGUIMaker;
import login.welcome_page.WelcomePageGUIMaker;
import options.OptionsGUIMaker;
import options.browse.EmptyFeedGUIMaker;
import options.browse.FeedGUIMaker;
import options.cart.CartGUIMaker;
import options.cart.EmptyCartGUIMaker;
import options.follow_users.FollowGUIMaker;
import options.post.Post;
import options.search.ScrollSearchGUIMaker;
import options.search.SearchGUIMaker;
import user.User;

import java.io.IOException;
import java.util.ArrayList;

public class GUIFactory {
    User user;
    ArrayList<Post> feed;
    int index;
    String tag;

    public GUIFactory() {
    }

    public GUIFactory(User user) {
        this.user = user;
    }

    public GUIFactory(ArrayList<Post> feed, User user, int index) {
        this.feed = feed;
        this.user = user;
        this.index = index;
    }

    public GUIFactory(User user, String tag) {
        this.user = user;
        this.tag = tag;
    }

    public GUIFactoryInterface getFrame(String frameType) throws IOException, ClassNotFoundException {
        if (frameType.equalsIgnoreCase("WELCOME")) {
            return new WelcomePageGUIMaker();
        }
        else if (frameType.equalsIgnoreCase("SIGNIN")) {
            return new SignInGUIMaker();
        }
        else if (frameType.equalsIgnoreCase("SIGNUP")) {
            return new SignUpGUIMaker();
        }
        else if (frameType.equalsIgnoreCase("OPTIONS")) {
            return new OptionsGUIMaker(this.user);
        }
        else if (frameType.equalsIgnoreCase("SEARCH")) {
            return new SearchGUIMaker(this.user);
        }
        else if (frameType.equalsIgnoreCase("FOLLOW")) {
            return new FollowGUIMaker(this.user);
        }
        else if (frameType.equalsIgnoreCase("CART")) {
            return new CartGUIMaker(this.user);
        }
        else if (frameType.equalsIgnoreCase("EMPTYCART")) {
            return new EmptyCartGUIMaker(this.user);
        }
        else if (frameType.equalsIgnoreCase("FEED")) {
            return new FeedGUIMaker(this.feed, this.user, this.index);
        }
        else if (frameType.equalsIgnoreCase("EMPTYFEED")) {
            return new EmptyFeedGUIMaker(this.user);
        }
        else if (frameType.equalsIgnoreCase("SCROLLSEARCH")) {
            return new ScrollSearchGUIMaker(this.user, this.tag);
        }
        // need to change the return type here
        else if (frameType.equalsIgnoreCase("POST")) {
            return new EmptyCartGUIMaker(this.user);
        }
        return null;
    }
}
