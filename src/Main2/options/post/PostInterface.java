package options.post;

import user.User;


public interface PostInterface {

    void setCaption(String caption);
    void setProduct(String productID);
    void addlike(int likes);
    void addRating(float rating);
    void addComment(String comment);
    void setCanRate(boolean bool);
    void setCanComment(boolean bool);
    void setUser(User user);

}
//