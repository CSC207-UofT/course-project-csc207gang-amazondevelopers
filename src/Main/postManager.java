import java.util.ArrayList;
public class postManager{
    private productManager productmanager = new productManager();
    private userManager usermanager = new userManager();
    // create a post and the product it is based on, add this post to the postList in the user that created it
    public Post createPost (ArrayList<String > t, User u, String d, String productName, String id, float price,
                            String category, String size, int quantity){
        Product p = productmanager.createProduct(productName, id, price, category, size, quantity);
        Post post = new Post(p,t,d,u);
        usermanager.addToPostList(post,u);
        return post;
    }
    public Post createPost (ArrayList<String > t, User u, String d, String productName, String id, float price,
                            String category, int quantity){
        Product p = productmanager.createProduct(productName, id, price, category, quantity);
        Post post = new Post(p,t,d,u);
        usermanager.addToPostList(post,u);
        return post;
    }
}

