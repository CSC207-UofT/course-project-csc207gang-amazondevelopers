package options;

public class OptionsPresenter{

    /**
     * Asks user what they want to do
     * @ Returns a message to user asking them what they want to do (instructions)
     */
    public String message1(){
        return "What do you want to do?";
    }

    /**
     * Logout option
     * @return String of logout
     */
    public String message2(){
        return "Logout";
    }
    /**
     * Browse option
     * @return String of options.browse
     */
    public String message4(){
        return "Browse";
    }
    /**
     * Find sellers option
     * @return String of finding sellers
     */
    public String message5(){
        return "Find Sellers";
    }
    /**
     * Making options.post option
     * @return String of making options.post
     */
    public String message6(){
        return "Make a Post";
    }
    /**
     * Searching option
     * @return String of search
     */
    public String message7(){
        return "Search";
    }

    /**
     * Tells user that this leads to their options.cart
     * @return A string of options.cart
     */
    public String message8() {return "Cart";}
}
