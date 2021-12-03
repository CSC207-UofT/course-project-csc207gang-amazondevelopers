package post;

public class EnglishPostPresenter implements PostPresenterInterface{
    /**
     *
     * @return A string instructing the user on what to do
     */
    public String Welcome(){
        return "Fill boxes about your product!";
    }

    /**
     *
     * @return A String asking for products name
     */
    public String namePresenter(){
        return "Name : ";
    }

    /**
     *
     * @return A String asking for products price
     */
    public String pricePresenter(){
        return "Price: ";
    }

    /**
     *
     * @return A String asking for product category
     */
    public String categoryPresenter(){
        return "Category: ";
    }

    /**
     *
     * @return A String asking user for the size of the product
     */
    public String sizePresenter(){
        return "Size:";
    }

    /**
     *
     * @return A string asking for quantity of the product
     */
    public String quantityPresenter(){
        return "Quantity: ";
    }

    /**
     *
     * @return A string telling user to go back to previous page
     */
    public String backPresenter(){
        return "Back";
    }

    /**
     *
     * @return A String that indicates to the user to press the button to share
     */
    public String sharePresenter(){
        return "Share!";
    }

    /**
     *
     * @return A String that indicates to the user to describe their product(caption)
     */
    public String describePresenter(){
        return "Description: ";
    }

    /**
     *
     * @return A String that indicates to the user that they forgot to fill in a textfield
     */
    public String fillInPresenter() {return "please fill everything in!";}
}
