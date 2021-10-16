import java.util.ArrayList;
public class postManager {
    private productManager productmanager = new productManager();
    private userManager um = new userManager();
    /** create a post and the product it is based on, add this post to the postList in the user that created it **/
    public void createPost (ArrayList<String > t, User u, String d, String n, float pr, String c, String size){
        Product p = productmanager.createProduct(n,pr,c,size);
        Post post = new Post(p,t,d,u);
        um.addToPostList(post,u); /* need userManager to implement this method*/
    }
    public void createPost (ArrayList<String > t, User u, String d, String n, float pr, String c){
        Product p = productmanager.createProduct(n,pr,c);
        Post post = new Post(p,t,d,u);
        um.addToPostList(post,u); /* need userManager to implement this method*/
    }
}
