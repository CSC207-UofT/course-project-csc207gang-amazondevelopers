package product;
import java.io.Serializable;

public class Product implements Serializable{
    private static final long serialVersionUID = -7950046950879175491L;
    private String name = "";
    private String id = "";
    private Double price = 0.0;
    private String category = "";
    private String sizes = "";
    private int quantity = 0;
    private String username;

    /**
     * Empty Initializer for use in SaveProductGateway
     */
    public Product(String user) {
        this.username = user;
    }

    /**
     * Creates a new Product object.
     * The Constructor takes in 4 arguments, the name of the Product. The price
     * of the Product. The Product category as well as a list of sizes of the
     * product or null if there is only one size.
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
    }

    /**
     * @return the string representation of the product
     */
    public String toString() {
        if (this.sizes == null) {
            return name + " (" + id + ")" + ": $" + price + ", " + quantity + " in stock";
        } else {
            return name + " (" + id + ")" + ": $" + price + ", " + quantity + " in stock" + ", size: " + sizes;
        }
    }

    // getter for name of product
    public String getName() {
        return name;
    }

    // setter for name of product
    public void setName(String pname) {
        if (!pname.strip().equals("")) {
            this.name = pname;
        }
    }

    // getter for id of product
    public String getId() {
        return id;
    }

    //setter for id of product
    public void setId(String pid) {
        this.id = pid;
    }

    // getter for price of product
    public Double getPrice() {
        return price;
    }

    //setter for price of product
    public void setPrice(Double pprice) {
        if (pprice < 0) {
            this.price = 0.0;
        } else {
            // round to 2 decimal places
            this.price = (double) Math.round(pprice * 100) / 100;
        }
    }

    // getter for category of product
    public String getCategory() {
        return category;
    }

    //setter for category of product
    public void setCategory(String pcategory) {
        this.category = pcategory;
    }

    // getter for sizes
    // returns an Object since size can be a string or null
    public Object getSizes() {
        return sizes;
    }

    // setter for sizes
    public void setSizes(String psize) {
        if (psize.equals("")) {
            this.sizes = null;
        } else {
            this.sizes = psize;
        }
    }

    //getter for quantity
    public int getQuantity() {
        return quantity;
    }

    //setter for quantity
    public void setQuantity(int pquantity) {
        this.quantity = Math.max(pquantity, 0);
    }
    //getter for username
    public String getUsername() {return this.username;}



}

