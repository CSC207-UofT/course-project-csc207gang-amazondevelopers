package login.sign_in;

/**
 * Presenter to be used for our SignInGUI
 */
public class EnglishSignInPresenter implements SignInPresenterInterface {
    public String presentInputUsername() {
        return "Input your username and password";
    }
    public String presentWrongPasswordUsername() {
        return "Wrong password or username";
    }
    public String presentLogin() {
        return "Login";
    }
    public String presentReset() {
        return "Reset";
    }
    public String presentBack() {
        return "Back";
    }
    public String presentUserID() {
        return "userID: ";
    }
    public String presentPassword() {
        return "password: ";
    }
}
