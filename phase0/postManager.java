import java.util.ArrayList;

public class postManager{
    private productManager productmanager = new productManager();
    // create a post and the product it is based on, add this post to the postList in the user that created it

    /**
     * Creates a post by taking in a tag, a User, a String description, s String productName, a String productId, a float price
     * of the product, a String category, a String size and an int quantity of the product.
     *
     * @param tag
     * @param user
     * @param description
     * @param productName
     * @param productId
     * @param price
     * @param category
     * @param size
     * @param quantity
     * @return A new created post.
     */
    public Post createPost (ArrayList<String > tag, User user, String description, String productName, String productId, float price,
                            String category, String size, int quantity){
        Product p = productmanager.createProduct(productName, productId, price, category, size, quantity);
        Post post = new Post(p,tag,description,user);
        userManager userManager = new userManager(user);
        userManager.addToPostList(post);
        for (String aTag : post.getTags()) {
            masterManager.setterProductTagMap(aTag, post.getPost_topic());
        }
        return post;
    }

    /**
     * Creates a post by taking in a tag, a User, a String description, s String productName, a String productId, a float price
     * of the product, a String category and an int quantity of the product.
     *
     * @param tag
     * @param user
     * @param description
     * @param productName
     * @param productId
     * @param price
     * @param category
     * @param quantity
     * @return A new created post.
     */

    public Post createPost (ArrayList<String > tag, User user, String description, String productName, String productId, float price,
                            String category, int quantity){
        Product p = productmanager.createProduct(productName, productId, price, category, quantity);
        Post post = new Post(p,tag,description,user);
        userManager userManager = new userManager(user);
        userManager.addToPostList(post);
        for (String atag : post.getTags()) {
            masterManager.setterProductTagMap(atag, post.getPost_topic());
        }
        return post;
    }
}

