package login.welcome_page.WelcomePagePresenter;

public class EnglishWelcomePagePresenter implements WelcomePagePresenterInterface {
    /**
     * Presents message to user to help instruct them on how to use the program
     * @return A string message
     */
    public String welcomeMessage(){
        return "Welcome to BAZAAR! Choose an option!";
    }

    public String presentSignIn() {
        return "SignIn";
    }
    public String presentSignUp() {
        return "SignUp";
    }
    public String presentQuit() {
        return "Quit";
    }
}
