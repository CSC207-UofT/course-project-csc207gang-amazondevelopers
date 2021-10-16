
public class Product {
    private String name;
    private float price;
    private String category;
    private String sizes;

    /**
     * Creates a new Product object.
     * The Constructor takes in 4 arguments, the name of the Product. The price
     * of the Product. The Product category as well as a list of sizes of the
     * product or null if there is only one size.
     *
     */

    public Product(String name, float price, String category, String sizes) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.sizes = sizes;
    }

    public Product(String name, float price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.sizes = null;
    }

    // getter for name of product
    public String getName() {return name;}

    // setter for name of product
    public void setName(String pname) {this.name = pname;}

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

//
}
