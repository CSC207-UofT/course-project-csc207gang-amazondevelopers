package login_functions;

public class SignUpPresenter {
    /**
     * A presenter to help guide the user
     * @return returns a message for the reader to see
     */
    public String message(){return "Sign up for Bazaar!";}

    /**
     * A message to the user that the username is taken
     * @return returns a message to reader to see that username is taken
     */
    public String message2(){return "This username is taken, please enter another one!";}

    /**
     *
     * @return a message if the user was made
     */
    public String message3(){return "success!";}

    /**
     *
     * @return if the password or userID field is empty
     */
    public String message4(){return "You should input all required fields!";}
}
