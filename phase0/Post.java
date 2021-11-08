import java.util.ArrayList;

public class Post{
    private Product postTopic; /* The product that the post is about */
    private ArrayList<String> tags;/* The tags about the posts */
    private String description;/* The description or information about a post*/
    private User poster;/*The user that posts the post*/

    /**
     * Creates a new Post object.
     * The Constructor takes in 4 arguments, a Product, the tag of the Product, the description of the
     * product and the user that makes the post.
     *
     */
    public Post (Product p, ArrayList<String> t, String d, User u){
        this.postTopic = p;
        this.tags = t;
        this.description = d;
        this.poster = u;
    }

    // getter for instance variable post_topic
    public Product getPost_topic (){
        return this.postTopic;
    }

    // getter for instance variable tags
    public ArrayList<String> getTags (){
        return this.tags;
    }

    // getter for instance variable description
    public String getDescription(){
        return this.description;
    }



}