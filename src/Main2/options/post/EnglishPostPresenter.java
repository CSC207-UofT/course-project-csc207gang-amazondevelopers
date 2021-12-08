package options.post;

import product.PostPresenterInterface;

public class EnglishPostPresenter implements PostPresenterInterface {
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
     * @return A String asking the user whether other others can leave ratings
     */
    public String ratePresenter(){
        return "Rate:";
    }

    /**
     *
     * @return A String asking the user whether other others can leave comments
     */
    public String commentPresenter(){
        return "Comment:";
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
        return "Description:";
    }

    /**
     *
     * @return A String that indicates to the user that they forgot to fill in a textfield
     */
    public String fillInPresenter() {return "please fill everything in!";}

    /**
     *
     * @return A String indicating to user that the price they set is not valid, they need to redo
     */
    public String priceValidityPresenter() {return "price must be a positive number!";}

    /**
     *
     * @return A String indicating to user that the quantity they set is not valid, must redo
     */
    public String quantityValidityPresenter() {return "quantity must be a positive integer!";}

    /**
     *
     * @return A String telling the user that they have successfully made a options.post
     */
    public String congrats() {return "You have successfully shared your options.post!";}

    public String backToMenu() {return "Return back to options";}
}
