package login.sign_up.SignUpPresenter;

import login.sign_up.SignUpPresenter.SignUpPresenterInterface;

//TODO Change name to EnglishSignUpPresenter
public class EnglishSignUpPresenter implements SignUpPresenterInterface {
    /**
     * A presenter to help guide the user
     * @return returns a message for the reader to see
     */
    public String message(){return "Sign up for Bazaar!";}

    /**
     * A message to the user that the username is taken
     * @return returns a message to reader to see that username is taken
     */
    public String message2(){return "<html>This username is taken, <br> please enter another one!</html>";}

    /**
     * @return a message if the user was made
     */
    public String message3(){return "success!";}

    /**
     * @return if the password or userID field is empty
     */
    public String message4(){return "You should input all required fields!";}

    /**
     * @return string for button used to signup
     */
    public String signUp(){return "Sign Up";}

    /**
     * @return string for button used to reset username and password
     */
    public String reset(){return "Reset";}

    /**
     * @return string for button used to go back to Welcome Page
     */
    public String back(){return "Back";}

    /**
     * @return string to prompt user to enter username
     */
    public String userID (){return "userID: ";}

    /**
     *
     * @return string to prompt user to enter password
     */
    public String password(){return "password: ";}
}

