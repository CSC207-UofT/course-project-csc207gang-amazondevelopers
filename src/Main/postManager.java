import java.util.ArrayList;
public class postManager {
    private productManager productmanager = new productManager();
    private userManager usermanager = new userManager();
    /** create a post and the product it is based on, add this post to the postList in the user that created it **/
    public Post createPost (ArrayList<String > t, User u, String d, objects to initialize product){
        private Product p = productmanager.createProduct(variables);/*need to know what variables to create a product are*/
        private Post post = new Post(p,t,d,u);
        usermanager.addToPostList(u,post); /* need userManager to implement this method*/
        return post;
    }
}

