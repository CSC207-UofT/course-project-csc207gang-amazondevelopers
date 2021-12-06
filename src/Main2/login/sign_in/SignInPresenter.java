package login.sign_in;

//TODO change name to EnglishSignInPresenter
public class SignInPresenter {
    /**
     * Presents message to user to put in their username and password
     * @return A string message
     */
    public String message() {
        return "Input your username and password";
    }
    /**
     * Presents user message that their login was successful
     * @return A string message
     */
    public String message3() {
        return "login successful";
    }
    /**
     * Presents user message that their password is wrong
     * @return A string message
     */
    public String message4() {
        return "Wrong password or username";
    }
    /**
     * Presents user message that their username was not found
     * @return A string message
     */
    public String message5() {
        return "username not found";
    }
}
