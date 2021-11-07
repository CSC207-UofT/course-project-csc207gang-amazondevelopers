package ProductFunctions;

import java.io.Serializable;

public class Product implements Serializable {
    private String name;
    private String id;
    private float price;
    private String category;
    private String sizes;
    private int quantity;

    /**
     * Creates a new Product object.
     * The Constructor takes in 4 arguments, the name of the Product. The price
     * of the Product. The Product category as well as a list of sizes of the
     * product or null if there is only one size.
     *
     */


    public Product(String name, String id, float price, String category, int quantity) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.category = category;
        this.sizes = null;
        this.quantity = quantity;
    }

    public Product(String name, String id, float price, String category, String sizes, int quantity) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.category = category;
        this.sizes = sizes;
        this.quantity = quantity;
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
    public float getPrice() {return price;}

    //setter for price of product
    public void setPrice(float pprice) {this.price = pprice;}

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
}
