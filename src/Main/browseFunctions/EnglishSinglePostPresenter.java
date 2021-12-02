package browseFunctions;

import inputOutputFunctions.SystemInOut;
import postFunctions.Post;

/**
 * Present A representation of a singular post in english
 */
public class EnglishSinglePostPresenter implements SinglePostPresenterInterface {
    public void presentSinglePost(Post post){
        SystemInOut output = new SystemInOut();
        output.sendOutput("Caption: " + post.getCaption()+"\n");
        output.sendOutput("Product\n");
        output.sendOutput(post.getProduct());
        if (post.getCanComment() == true) {
            output.sendOutput("Comments:\n");
            for (String comment : post.getComments()) {
                output.sendOutput(comment + "\n");
            }
        }
        if (post.getCanRate() == false){
            output.sendOutput("Ratings:\n");
            for (float rating : post.getRatings()) {
                output.sendOutput(rating     + "\n");
            }
        }
    }
}
