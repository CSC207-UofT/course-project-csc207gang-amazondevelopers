package options.post;

public class PostInformationController {
    /**
     * Checks if there are any missing fields from the user
     * @param name the name of the product given by user
     * @param price the price given by the user
     * @param category the category of product given by user
     * @param quantity the quantity of the product given by user
     * @param description the description of the product given by user
     * @return true if there are any missing fields
     */
    public boolean Empty(String name, String price, String category, String quantity, String description) {
        return name.equals("") | price.equals("")| category.equals("") | quantity.equals("")| description.equals("");
    }

    /**
     * Checks to see if the price is double or not
     * @param price the price given by the user
     * @return returns true if the price is a positive double
     */
    public boolean doubleOrNot(String price) {
        double priceValue;
        try {priceValue = Double.parseDouble(price);
             if (priceValue > 0) {return true;}}
        catch (NumberFormatException numberFormatException) {return false;}
        return false;
    }

    /**
     * Checks to see if the quantity is an integer or not
     * @param quantity the quantity given by the user
     * @return returns true if the quantity is a positive integer
     */
    public boolean integerOrNot(String quantity) {
        int quantityValue;
        try {quantityValue = Integer.parseInt(quantity);
              if (quantityValue > 0) {return true;}}
        catch (NumberFormatException numberFormatException) {return false;}
        return false;
    }
}
