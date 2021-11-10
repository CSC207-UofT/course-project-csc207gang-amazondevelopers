package ProductFunctions;

import UserFunctions.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Product implements Serializable {
    private String name;
    private String id;
    private Double price;
    private String category;
    private String sizes;
    private int quantity;
    private HashMap<User, String> comments;
    private ArrayList<User> likers;
    private int likes;

    /**
     * Creates a new Product object.
     * The Constructor takes in 4 arguments, the name of the Product. The price
     * of the Product. The Product category as well as a list of sizes of the
     * product or null if there is only one size.
     *
     */


    public Product(String name, String id, Double price, String category, int quantity) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.category = category;
        this.sizes = null;
        this.quantity = quantity;
    }

    public Product(String name, String id, Double price, String category, String sizes, int quantity) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.category = category;
        this.sizes = sizes;
        this.quantity = quantity;
        this.comments = new HashMap<>();
        this.likers = new ArrayList<>();
        this.likes = 0;
    }

    /**
     *
     * @return the string representation of the product
     */
    public String toString() {
        return name + " (" + id + ")"+ "\n" + "$" + price + ", "+ "\n" + quantity + " in stock, "+ "\n"
                + "size "+ sizes + "\n" + "likes: "+ likes + "\n" +comments + ": " + displayComments();
    }


    // getter for name of product
    public String getName() {return name;}

    // setter for name of product
    public void setName(String pname) {this.name = pname;}

    // getter for id of product
    public String getId() {return id;}

    //setter for id of product
    public void setId(String pid) {this.id = pid;}

    // getter for price of product
    public Double getPrice() {return price;}

    //setter for price of product
    public void setPrice(Double pprice) {this.price = pprice;}

    // getter for category of product
    public String getCategory() {return category;}

    //setter for category of product
    public void setCategory(String pcategory) {this.category = pcategory;}

    // getter for sizes
    public String getSizes() {return sizes;}

    // setter for sizes
    public void setSizes(String psize) {this.sizes = psize;}

    //getter for quantity
    public int getQuantity() {return quantity;}

    //setter for quantity
    public void setQuantity(int pquantity) {this.quantity = pquantity;}

    public void setLikes(){this.likes = this.likers.size();}

    public int getLikes(){return this.likes;}

    public String[] getComments() {

        ArrayList<String> comments = new ArrayList<>();

        for(Map.Entry<User, String> entry : this.comments.entrySet()){
            User key = entry.getKey();
            String value = entry.getValue();

            comments.add(key.getUsername() + ": "+ value);

        }
        String[] commentsList = new String[comments.size()];
        commentsList = comments.toArray(commentsList);
        return commentsList;
    }

    public StringBuilder displayComments() {
        StringBuilder comments;
        comments = new StringBuilder();
        for(Map.Entry<User, String> entry : this.comments.entrySet()){
            User key = entry.getKey();
            String value = entry.getValue();

            if (comments.length() != 0) {
                comments.append("\n");
            }
            comments.append(key.getUsername()).append(": ").append(value);
        }
        return comments;
    }

    public void addLikes(User user){
        if (!this.likers.contains(user)){
            this.likers.add(user);
            this.setLikes();
        }
    }

    public void removeLikes(User user){
        if (this.likers.contains(user)){
            this.likers.remove(user);
            this.setLikes();
        }
    }

    public void addComments(User user, String comment){
        this.comments.put(user, comment);
    }

    public void removeComments(User user){
        if (this.comments.containsKey(user)){
            this.comments.remove(user, this.comments.get(user));
        }
    }
}
