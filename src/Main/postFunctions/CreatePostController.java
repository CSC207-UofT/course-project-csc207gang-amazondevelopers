package postFunctions;

import inputOutputFunctions.SystemInOut;
import product.Product;
import userFunctions.User;
import java.util.ArrayList;

public class CreatePostController {
    /**
     * Method to create a new post from user input. Uses the memento design pattern in the Post class, as it inherites
     * the Originator superclass.
     * It also instructs the gateway to add specific posts to the serilized file that stores our data
     * @param input
     * @param product Product that the post is about
     * @param user User makng the post
     * @param from_product_creation A flag, that is true only if this method is called in CreatePostController
     * @return A Post that has been created
     * @throws Exception A generic exception to stop the method, and return to user options controller
     */
    public Post createPost(SystemInOut input,Product product, User user,boolean from_product_creation) throws Exception {
        ArrayList<Post.Memento> memento_list = new ArrayList<Post.Memento>();
        Post new_post = new Post(product,user);
        new_post.set(0);
        memento_list.add(new_post.saveToMemento());
        EnglishPostPresenter pcp = new EnglishPostPresenter();
        boolean is_post_complete = false;
        while (is_post_complete == false){
            if (new_post.getState() == 0) {
                pcp.presentCaption();
                String captionInput = input.getInput();
                if (captionInput.equals("*")) {
                    if(from_product_creation = true){
                        pcp.presentUnableToUndo();
                    }else{
                        throw new Exception();
                    }
                } else {
                    memento_list.add(new_post.saveToMemento());
                    new_post.setCaption(captionInput);
                    new_post.set(1);
                }
            }
            if (new_post.getState() == 1) {
                pcp.presentComments();
                String commentInput = input.getInput();
                if (commentInput.equals("*")) {
                    new_post.restoreFromMemento(memento_list.get(memento_list.size() -1));
                    memento_list.remove(memento_list.size() -1);
                } else if (commentInput.equals("1")) {
                    memento_list.add(new_post.saveToMemento());
                    new_post.setCanComment(true);
                    new_post.set(2);
                } else if (commentInput.equals("2")) {
                    memento_list.add(new_post.saveToMemento());
                    new_post.setCanComment(false);
                    new_post.set(2);
                }
                //If they didnt enter these 3 options
            }
            if (new_post.getState() == 2) {
                pcp.presentRatings();
                String ratingInput = input.getInput();
                if (ratingInput.equals("*")) {
                    new_post.restoreFromMemento(memento_list.get(memento_list.size() -1));
                    memento_list.remove(memento_list.size() -1);
                }
                else if (ratingInput.equals("1")) {
                    memento_list.add(new_post.saveToMemento());
                    new_post.setCanRate(true);
                    new_post.set(2);
                    pcp.presentPostConformation();
                    String yes_no = input.getInput();
                    if (yes_no.equals("*")){
                        new_post.restoreFromMemento((memento_list.get(memento_list.size() -1)));
                        memento_list.remove(memento_list.size() -1);
                    }
                    else{
                        is_post_complete = true;
                    }
                } else if (ratingInput.equals("2")) {
                    memento_list.add(new_post.saveToMemento());
                    new_post.setCanRate(false);
                    new_post.set(2);
                    pcp.presentPostConformation();
                    String yes_no = input.getInput();
                    if (yes_no.equals("*")){
                        new_post.restoreFromMemento((memento_list.get(memento_list.size() -1)));
                        memento_list.remove(memento_list.size() -1);
                    }
                    else{
                        is_post_complete = true;
                    }
                }

            }
        }
        AddPostGatewayInterface addPostGateway = new AddPostGateway();
        PostManager postManager = new PostManager(addPostGateway);
        postManager.savePost(new_post, user);
        return new_post;
    }
}
