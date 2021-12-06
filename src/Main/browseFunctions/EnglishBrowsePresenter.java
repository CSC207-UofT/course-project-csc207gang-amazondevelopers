package browseFunctions;

import inputOutputFunctions.SystemInOut;
import postFunctions.Post;

public class EnglishBrowsePresenter implements SinglePostPresenterInterface {
    /**
     * Present A representation of a singular options.post in english
     */
    public void presentSinglePost(Post post){
        SystemInOut output = new SystemInOut();
        output.sendOutput("Posted by: " + post.getUser().getUsername());
        output.sendOutput("Caption: " + post.getCaption());
        output.sendOutput("Product:");
        output.sendOutput(post.getProduct());
        if (post.getCanComment() == true) {
            output.sendOutput("Comments:");
            for (String comment : post.getComments()) {
                output.sendOutput(comment);
            }
        }
        if (post.getCanRate() == true){
            output.sendOutput("Ratings:");
            for (float rating : post.getRatings()) {
                output.sendOutput(rating);
            }
        }
    }
    public void presentProduct(){
        SystemInOut output = new SystemInOut();
        output.sendOutput("Products from your options.post:");
    }
}
