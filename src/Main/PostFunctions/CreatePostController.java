package PostFunctions;

import InputAndOutput.SystemInOut;
import ProductFunctions.Product;
import UserFunctions.User;
import java.util.ArrayList;

public class CreatePostController {
    public Post createPost(SystemInOut input,Product product, User user,boolean from_product_creation) throws Exception {
        ArrayList<Post.Memento> memento_list = new ArrayList<Post.Memento>();
        Post new_post = new Post(product,user);
        new_post.set(0);
        memento_list.add(new_post.saveToMemento());
        boolean is_post_complete = false;
        while (is_post_complete == false){
            if (new_post.getState() == 0) {
                input.sendOutput("What is the caption of your post?");
                String captionInput = input.getInput();
                if (captionInput.equals("*")) {
                    if(from_product_creation = true){
                        input.sendOutput("Sorry, you cannot undo from here");
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
                input.sendOutput("Would you like your post to have Comments? Input 1 for yes, 2 for no");
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
                input.sendOutput("Would you like your post to have Ratings? Input 1 for yes, 2 for no");
                String ratingInput = input.getInput();
                if (ratingInput.equals("*")) {
                    new_post.restoreFromMemento(memento_list.get(memento_list.size() -1));
                    memento_list.remove(memento_list.size() -1);
                }
                else if (ratingInput.equals("1")) {
                    memento_list.add(new_post.saveToMemento());
                    new_post.setCanRate(true);
                    new_post.set(2);
                    input.sendOutput("Are you happy with this post? Type * for no, or anything else for yes.");
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
                    input.sendOutput("Are you happy with this product? Type * for no, or anything else for yes.\n If you say yes, you will be asked to create a post about this product");
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
