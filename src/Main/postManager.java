import java.util.ArrayList;

public class postManager{
    private productManager productmanager = new productManager();
    private userManager usermanager = new userManager();


    // create a post and the product it is based on, add this post to the postList in the user that created it

    /**
     * Creates a post by taking in a tag, a User, a String description, s String productName, a String id, a float price
     * of the product, a String category, a String size and an int quantity of the product.
     *
     * @param t
     * @param u
     * @param d
     * @param productName
     * @param id
     * @param price
     * @param category
     * @param size
     * @param quantity
     * @return A new created post.
     */
    public Post createPost (ArrayList<String > t, User u, String d, String productName, String id, float price,
                            String category, String size, int quantity){
        Product p = productmanager.createProduct(productName, id, price, category, size, quantity);
        Post post = new Post(p,t,d,u);
        usermanager.addToPostList(post,u);
        for (String tag : post.getTags()) {
            masterManager.setterProductTagMap(tag, post.getPost_topic());
        }
        return post;
    }

    /**
     * Creates a post by taking in a tag, a User, a String description, s String productName, a String id, a float price
     * of the product, a String category and an int quantity of the product.
     *
     * @param t
     * @param u
     * @param d
     * @param productName
     * @param id
     * @param price
     * @param category
     * @param quantity
     * @return A new created post.
     */

    public Post createPost (ArrayList<String > t, User u, String d, String productName, String id, float price,
                            String category, int quantity){
        Product p = productmanager.createProduct(productName, id, price, category, quantity);
        Post post = new Post(p,t,d,u);
        usermanager.addToPostList(post,u);
        for (String tag : post.getTags()) {
            masterManager.setterProductTagMap(tag, post.getPost_topic());
        }
        return post;
    }
}

